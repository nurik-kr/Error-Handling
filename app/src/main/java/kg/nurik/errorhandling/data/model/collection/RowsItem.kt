package kg.nurik.errorhandling.data.model.collection

data class RowsItem(
    val created_at: String,
    val icon: String,
    val preview: String,
    val content: String?,
    val id: Int,
    val rank: Int,
    val title: String,
    val updated_at: String
)