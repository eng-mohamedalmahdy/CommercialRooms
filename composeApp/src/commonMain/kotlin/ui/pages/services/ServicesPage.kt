package ui.pages.services

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource
import ui.composables.AppTopBar
import ui.composables.RegularAppTabRow
import ui.composables.ServiceCard
import ui.entity.UiService
import ui.entity.UiText
import ui.pages.signin.SignInPageScreen

@Composable
fun ServicesPage() {
    val navigator = LocalNavigator.currentOrThrow
    var selectedService by remember { mutableStateOf(AppServices.DigitalServices) }
    val dummyServices by remember {
        mutableStateOf(
            listOf(
                UiService("", "شهادة تعديل", ""),
                UiService("", "شهادة", ""),
                UiService("", "شهادة", ""),
                UiService("", "إصدار", ""),
                UiService("", "خدمة", ""),
            )
        )
    }
    LazyVerticalGrid(
        GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize()
    ) {
        item(
            span = { GridItemSpan(3) }
        ) {
            AppTopBar(
                leadingTitle = stringResource(MR.strings.welcome_back_user, ""),
            )
        }
        item(
            span = { GridItemSpan(3) }
        ) {
            Spacer(Modifier.height(16.dp))
            RegularAppTabRow(
                AppServices.entries,
                AppServices.entries.map { it.localizedName },
                selectedService,
                onTabClick = { selectedService = it }
            )
        }
        items(dummyServices) {
            ServiceCard(
                it,
                modifier = Modifier.clickable {
                    navigator.push(SignInPageScreen)
                }
            )
        }
        item(span = { GridItemSpan(3) }) {
            Spacer(Modifier.height(150.dp))
        }
    }
}

object ServicesPageScreen : Screen {

    @Composable
    override fun Content() = ServicesPage()

}


enum class AppServices {
    DigitalServices, PublicServices
}

val AppServices.localizedName
    get() = when (this) {
        AppServices.DigitalServices -> MR.strings.digital_services
        AppServices.PublicServices -> MR.strings.public_services
    }.let { UiText.StringResource(it).asString() }


