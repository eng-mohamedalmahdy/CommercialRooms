package ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource
import ui.config.AppIcons

@Composable
fun SignUpSuggestionCard(onSignUpClick: () -> Unit) {
    Card(
        Modifier.fillMaxWidth().padding(horizontal = 16.dp).height(150.dp)
    ) {
        Row(Modifier.fillMaxSize().padding(16.dp)) {
            AppImage(
                AppIcons.appLogo,
                modifier = Modifier.padding(8.dp).fillMaxHeight().width(50.dp)
            )
            Column {
                Text(
                    stringResource(MR.strings.sign_up_to_enjoy)
                )
                AppFilledButton(
                    text = stringResource(MR.strings.register),
                    onClick = onSignUpClick,
                    modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()
                )
            }
        }

    }

}