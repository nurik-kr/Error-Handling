package kg.nurik.errorhandling.data.model.Courses

import kg.nurik.errorhandling.data.model.Courses.CategoriesItem

data class RowsItem(
    val id: Int,
    val material_type: String,
    val title: String,
    val description: String,
    val content: String,
    val rank: Int,
    val duration: String,
    val categories_list: String,
    val created_at: String,
    val updated_at: String,
    val document: String,
    val preview: String,
    val comments_count: Int,
    val categories: List<CategoriesItem>
)