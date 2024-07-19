package ui.pages.services

import androidx.compose.foundation.background
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
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource
import ui.composables.AppTopBar
import ui.composables.RegularAppTabRow
import ui.composables.ServiceCard
import ui.entity.UiService

@Composable
fun ServicesPage() {
    var selectedService by remember { mutableStateOf(AppServices.DigitalServices) }
    val dummyServices by remember {
        mutableStateOf(List(10) {
            UiService(it.toString(), "Service #$it", it.toString())
        })
    }
    LazyVerticalGrid(
        GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize()
    ) {
        item(
            span = { GridItemSpan(3) }
        ) {
            AppTopBar(
                leadingTitle = stringResource(MR.strings.welcome_back_user, "User"),
            )
        }
        item(
            span = { GridItemSpan(3) }
        ) {
            Spacer(Modifier.height(16.dp))
            RegularAppTabRow(
                AppServices.entries,
                AppServices.entries.map { it.name },
                selectedService,
                onTabClick = { selectedService = it }
            )
        }
        items(dummyServices) {
            ServiceCard(it)
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