package domain.entity

import androidx.compose.runtime.Composable

interface Filterable {
    val filterName: String
        @Composable get

}