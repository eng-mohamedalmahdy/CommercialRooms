package ui.pages.more

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.HeadsetMic
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource
import ui.composables.AppTopBar
import ui.composables.SideMenuItem
import ui.composables.SignUpSuggestionCard
import ui.pages.articles.ArticlesPageScreen
import ui.pages.bookappointment.BookAppointmentPageScreen
import ui.pages.contactus.ContactUsScreen
import ui.pages.sharefeedback.ShareYourFeedbackPageScreen
import ui.pages.signin.SignInPageScreen


@Composable
fun MorePage() {
    val navigator = LocalNavigator.currentOrThrow
    LazyVerticalGrid(
        GridCells.Fixed(3)
    ) {
        item(span = { GridItemSpan(3) }) {
            Column(Modifier.padding(vertical = 8.dp)) {
                AppTopBar(
                    leadingTitle = stringResource(MR.strings.welcome_back_user, "User")
                )
                SignUpSuggestionCard {
                    navigator.push(SignInPageScreen)
                }
            }
        }

        items(sideMenuItems) {
            SideMenuItem(
                it.icon,
                it.title,
                modifier = Modifier.clickable(
                    onClick = { it.onClick(navigator) }
                ).padding(8.dp)
            )
        }

    }
}

object MorePageScreen : Screen {

    @Composable
    override fun Content() = MorePage()

}

data class SideMenuItem(
    val title: String,
    val icon: Any,
    val onClick: (Navigator) -> Unit
)

val sideMenuItems: List<SideMenuItem> = listOf(
    SideMenuItem(
        title = "تواصل معنا",
        icon = Icons.Default.HeadsetMic,
        onClick = { navigator -> navigator.push(ContactUsScreen) }
    ),
    SideMenuItem(
        title = "احجز ميعاد",
        icon = Icons.Default.CalendarMonth,
        onClick = { navigator -> navigator.push(BookAppointmentPageScreen) }
    ),
    SideMenuItem(
        title = "كيف كانت تجربتك؟",
        icon = Icons.Default.CheckCircle,
        onClick = { navigator -> navigator.push(ShareYourFeedbackPageScreen) }
    ),
    SideMenuItem(
        title = "المقالات",
        icon = Icons.Default.Newspaper,
        onClick = { navigator -> navigator.push(ArticlesPageScreen) }
    )
)