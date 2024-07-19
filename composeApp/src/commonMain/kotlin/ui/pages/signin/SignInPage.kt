package ui.pages.signin

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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.VisibilityOff
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
import ui.pages.signup.SignUpPage

@Composable
fun SignInPage() {

    val navigator = LocalNavigator.currentOrThrow

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppTopBar(
            leadingTitle = stringResource(MR.strings.welcome_back_user, "User")
        )

        Spacer(modifier = Modifier.height(16.dp))

        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

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
            value = password.value,
            label = "Password",
            onValueChange = { password.value = it },
            leadingIcon = Icons.Default.Lock,
            trailingIcon = Icons.Default.VisibilityOff,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            singleLine = true,
            onTrailingClick = { /* Toggle password visibility */ }
        )

        Spacer(modifier = Modifier.height(32.dp))

        AppFilledButton(
            text = "Sign In",
            onClick = { /* Handle sign-in */ }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Not signed up?",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Sign Up",
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.primary),
                modifier = Modifier.clickable { navigator.push(SignUpPage) }
            )
        }
    }
}

object SignInPageScreen : Screen{

    @Composable
    override fun Content() = SignInPage()

}
