package framework

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

class AndroidContactPicker(private val activity: ComponentActivity) : ContactPicker {

    private val pickContact: ActivityResultLauncher<Void?> =
        activity.registerForActivityResult(ActivityResultContracts.PickContact()) { uri: Uri? ->
            uri?.let { handleContactPicked(it) }
        }

    private var continuation: Continuation<Contact?>? = null

    override suspend fun pickContact(): Contact? {
        return suspendCancellableCoroutine { continuation ->
            this.continuation = continuation
            pickContact.launch(null)
        }
    }

    private fun handleContactPicked(uri: Uri) {
        val contact = getContactFromUri(activity, uri)
        continuation?.resume(contact)
        continuation = null
    }

    @SuppressLint("Range")
    private fun getContactFromUri(context: Context, uri: Uri): Contact? {
        // First, query the contact name
        val cursor: Cursor? = context.contentResolver.query(
            uri,
            arrayOf(ContactsContract.Contacts.DISPLAY_NAME, ContactsContract.Contacts._ID),
            null, null, null
        )

        var contactName: String? = null
        var contactId: String? = null

        cursor?.use {
            if (it.moveToFirst()) {
                contactName = it.getString(it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                contactId = it.getString(it.getColumnIndex(ContactsContract.Contacts._ID))
            }
        }

        // Then, query the phone number using the contact ID
        var contactPhoneNumber: String? = null
        contactId?.let {
            val phoneCursor: Cursor? = context.contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER),
                "${ContactsContract.CommonDataKinds.Phone.CONTACT_ID} = ?",
                arrayOf(contactId),
                null
            )

            phoneCursor?.use {
                if (it.moveToFirst()) {
                    contactPhoneNumber = it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                }
            }
        }

        var contactEmail: String? = null
        contactId?.let {
            val emailCursor: Cursor? = context.contentResolver.query(
                ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                arrayOf(ContactsContract.CommonDataKinds.Email.ADDRESS),
                "${ContactsContract.CommonDataKinds.Email.CONTACT_ID} = ?",
                arrayOf(contactId),
                null
            )

            emailCursor?.use {
                if (it.moveToFirst()) {
                    contactEmail = it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS))
                }
            }
        }


        return if (contactName != null && contactPhoneNumber != null) {
            Contact(contactName ?: "", contactPhoneNumber ?: "", contactEmail)
        } else {
            null
        }
    }
}