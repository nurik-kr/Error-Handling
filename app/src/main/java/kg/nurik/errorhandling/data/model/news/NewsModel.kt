package kg.nurik.errorhandling.data.model.news

data class NewsModel(
    val rows: List<RowsItem>,
    val total_count: Int
)