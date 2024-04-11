package demo

enum class Department(val fullName: String, val numEmployees: Int) {

    HR("Human Resources", 5),
    IT("Information Technology", 5),
    ACCOUNTING("Accounting", 3),
    SALES("Sales", 14);

    fun getDepartmentInfo(): String = "The $fullName department has $numEmployees employees."
}