package kg.nurik.errorhandling.data.model.bottomSheat

import kg.nurik.errorhandling.data.model.Courses.CategoriesItem

data class BottomSheetModel(
    val rows: List<BottomSheetRowsItem>,
    val total_count: Int
)