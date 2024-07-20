package ui.pages.bookappointment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.M
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource
import ui.composables.AppDatePickerDialog
import ui.composables.AppFilledButton
import ui.composables.AppTextField
import ui.composables.AppTopBar
import ui.composables.LabeledTextWithIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookAppointmentPage() {

    val navigation = LocalNavigator.currentOrThrow
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var fromDate by remember { mutableStateOf("") }
    var toDate by remember { mutableStateOf("") }
    var isShowingFromDatePicker by remember { mutableStateOf(false) }
    var isShowingToDatePicker by remember { mutableStateOf(false) }
    Box() {
        if (isShowingFromDatePicker) {
            AppDatePickerDialog(
                stringResource(MR.strings.from),
                onDismiss = { isShowingFromDatePicker = false },
                onDateSelected = { _, date ->
                    fromDate = date ?: ""
                    isShowingFromDatePicker = false
                }
            )
        }
        if (isShowingToDatePicker) {
            AppDatePickerDialog(
                stringResource(MR.strings.to_word),
                onDismiss = { isShowingToDatePicker = false },
                onDateSelected = { _, date ->
                    toDate = date ?: ""
                    isShowingToDatePicker = false
                }
            )
        }
        Column(
            Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        ) {
            AppTopBar(
                leadingTitle = "حجز موعد",
                onBackPress = navigation::pop
            )

            AppTextField(
                value = name,
                label = stringResource(MR.strings.name),
                onValueChange = { name = it },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            )
            Spacer(Modifier.height(8.dp))

            AppTextField(
                value = email,
                label = stringResource(MR.strings.email),
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)

            )
            Spacer(Modifier.height(8.dp))

            AppTextField(
                value = phone,
                label = stringResource(MR.strings.phone_number),
                onValueChange = { phone = it },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)

            )
            Spacer(Modifier.height(8.dp))


            Row {
                AppTextField(
                    value = fromDate,
                    label = stringResource(MR.strings.from),
                    onValueChange = {},
                    modifier = Modifier.weight(1f).clickable {
                        isShowingFromDatePicker = true
                    },
                    keyboardType = null
                )
                Spacer(Modifier.width(8.dp))
                AppTextField(
                    value = toDate,
                    label = stringResource(MR.strings.to_word),
                    onValueChange = {},
                    modifier = Modifier.weight(1f).clickable {
                        isShowingToDatePicker = true
                    },
                    keyboardType = null
                )
            }
            Spacer(Modifier.height(8.dp))
            AppFilledButton(
                stringResource(MR.strings.confirm), onClick = {

                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(Modifier.height(150.dp))
        }
    }
}


object BookAppointmentPageScreen : Screen {
    @Composable
    override fun Content() = BookAppointmentPage()

}