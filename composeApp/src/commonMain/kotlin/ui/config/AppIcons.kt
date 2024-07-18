package ui.config

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ContactPhone
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Expand
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.GroupAdd
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.HeadsetMic
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Pending
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sports
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material.icons.filled.UploadFile
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import commercialrooms.composeapp.generated.resources.Res
import commercialrooms.composeapp.generated.resources.actitivies
import commercialrooms.composeapp.generated.resources.back
import commercialrooms.composeapp.generated.resources.bookmark
import commercialrooms.composeapp.generated.resources.bookmarkred
import commercialrooms.composeapp.generated.resources.buildings
import commercialrooms.composeapp.generated.resources.camera_svg
import commercialrooms.composeapp.generated.resources.home
import commercialrooms.composeapp.generated.resources.maintenance_info
import commercialrooms.composeapp.generated.resources.membership
import commercialrooms.composeapp.generated.resources.password
import commercialrooms.composeapp.generated.resources.payments_svg
import commercialrooms.composeapp.generated.resources.profile
import commercialrooms.composeapp.generated.resources.public
import commercialrooms.composeapp.generated.resources.referral
import commercialrooms.composeapp.generated.resources.referral_customer_icon_svg
import commercialrooms.composeapp.generated.resources.services
import commercialrooms.composeapp.generated.resources.user_only
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource


object AppIcons {
    val contact = Icons.Default.Contacts
    val expand = Icons.Default.KeyboardArrowUp
    val collapse = Icons.Default.KeyboardArrowDown
    val clock = Icons.Default.Schedule
    val cctvMonitoring = Res.drawable.camera_svg
    val inviteFriends = Icons.Filled.GroupAdd
    val announcements = Icons.Filled.Campaign
    val submitRequest = Icons.Filled.UploadFile
    val servicesHistory = Res.drawable.maintenance_info
    val activitiesHistory = Icons.Default.Sports
    val invitationHistory = Icons.Filled.Mail
    val referralHistory = Res.drawable.referral
    val addReferral = Res.drawable.referral_customer_icon_svg
    val payments = Res.drawable.payments_svg
    val activities = Res.drawable.actitivies
    val services = Res.drawable.services
    val buildingsIcon = Res.drawable.buildings

    val more: ImageVector = Icons.Default.MoreHoriz
    val language = Icons.Default.Language

    val contactUs = Icons.Filled.HeadsetMic

    val aboutUs = Icons.Filled.Groups
    val personalChannel @Composable get() = painterResource(Res.drawable.user_only)
    val membershipChannel @Composable get() = painterResource(Res.drawable.membership)
    val allChannel @Composable get() = painterResource(Res.drawable.public)
    val ArrowBack @Composable get() = painterResource(Res.drawable.back)
    val SavedBookmark @Composable get() = painterResource(Res.drawable.bookmarkred)
    val UnSavedBookmark @Composable get() = painterResource(Res.drawable.bookmark)

    val personIcon @Composable get() = painterResource(Res.drawable.profile)
    val homeIcon @Composable get() = vectorResource(Res.drawable.home)
    val lockIcon @Composable get() = painterResource(Res.drawable.password)

    val camera = Icons.Default.AddAPhoto

    val invite = inviteFriends

    val userIcon = Icons.Default.Person
    val phoneIcon: ImageVector = Icons.Default.Phone

    val appLogo: ImageVector = Icons.Default.Phone

    val tagIcon: ImageVector = Icons.Default.Tag

    val calendar: ImageVector = Icons.Default.CalendarMonth

    val playIcon: ImageVector = Icons.Default.PlayCircle

    val eyeIcon = Icons.Default.Visibility

    val eyeOffIcon = Icons.Default.VisibilityOff

    val emailIcon = Icons.Default.Mail

    val search = Icons.Default.Search


    val radioButton = Icons.Default.RadioButtonChecked

    val filter = Icons.Default.FilterList

    val paymentDone = Icons.Default.CheckCircle
    val paymentPending = Icons.Default.Pending
    val paymentFailed = Icons.Default.Cancel
    val unitIcon = Icons.Default.Home

}

