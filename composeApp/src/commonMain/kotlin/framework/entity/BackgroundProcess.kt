package framework.entity

data class BackgroundProcess(
    val tag: String,
    val process: () -> Unit,
    val onSuccess: () -> Unit,
    val onFailure: () -> Unit,
    val manager: Any? = null
)
