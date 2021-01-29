package kg.nurik.errorhandling.data.model.Courses

data class CoursesModel<T>(
    val rows: List<T>,
    val total_count: Int
)