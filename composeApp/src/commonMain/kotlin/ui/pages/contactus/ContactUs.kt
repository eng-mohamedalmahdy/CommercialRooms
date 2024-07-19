package ui.pages.contactus

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource
import ui.composables.AppFilledButton
import ui.composables.AppTextField
import ui.composables.AppTopBar


@Composable
fun ContactUsPage() {
    val navigation = LocalNavigator.currentOrThrow
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var msg by remember { mutableStateOf("") }
    Column(
        Modifier.fillMaxSize().verticalScroll(rememberScrollState())
    ) {
        AppTopBar(
            leadingTitle = "Contact us",
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
            value = msg,
            label = stringResource(MR.strings.message),
            onValueChange = { msg = it },
            modifier = Modifier.fillMaxWidth().height(200.dp).padding(horizontal = 16.dp)
        )
        Spacer(Modifier.height(8.dp))
        AppFilledButton(
            "Send", onClick = {},
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(150.dp))
    }
}

object ContactUsScreen : Screen {

    @Composable
    override fun Content() = ContactUsPage()

}