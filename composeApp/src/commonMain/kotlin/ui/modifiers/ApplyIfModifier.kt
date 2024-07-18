package ui.modifiers

import androidx.compose.ui.Modifier

fun Modifier.applyIf(predicate: () -> Boolean, modifier: Modifier, elseModifier: Modifier? = null): Modifier =
    if (predicate()) then(modifier)
    else {
        elseModifier?.let { then(it) } ?: this
    }

