package ui.pages.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource
import ui.composables.AppFilledButton
import ui.composables.AppTextField
import ui.composables.AppTopBar
import ui.pages.signin.SignInPageScreen

@Composable
fun SignUpPage() {
    val navigator = LocalNavigator.currentOrThrow
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppTopBar(
            leadingTitle = stringResource(MR.strings.register)
        )

        Spacer(modifier = Modifier.height(16.dp))

        val fullName = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }
        val phoneNumber = remember { mutableStateOf("") }
        val message = remember { mutableStateOf("") }

        AppTextField(
            value = fullName.value,
            label = "Full Name",
            onValueChange = { fullName.value = it },
            leadingIcon = Icons.Default.Person,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = email.value,
            label = "Email",
            onValueChange = { email.value = it },
            leadingIcon = Icons.Default.Email,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = phoneNumber.value,
            label = "Phone Number",
            onValueChange = { phoneNumber.value = it },
            leadingIcon = Icons.Default.Phone,
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Next
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = message.value,
            label = "Message",
            onValueChange = { message.value = it },
            leadingIcon = Icons.Default.Message,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Default,
            singleLine = false
        )

        Spacer(modifier = Modifier.height(32.dp))

        AppFilledButton(
            text = "Sign Up",
            onClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an account?",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Sign In",
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.primary),
                modifier = Modifier.clickable { navigator.push(SignInPageScreen) }
            )
        }
    }
}

object SignUpPage : Screen {

    @Composable
    override fun Content() = SignUpPage()

}