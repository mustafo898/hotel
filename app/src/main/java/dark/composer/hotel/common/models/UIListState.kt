package dark.composer.hotel.common.models

data class UIListState<T>(
    val error: String = "",
    val data: List<T>? = null,
    val isLoading: Boolean = false
)