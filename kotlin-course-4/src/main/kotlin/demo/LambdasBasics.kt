package demo



object Employees {

    val empList = listOf(
        Employee("John", "Smith", 2012),
        Employee("Jane", "Wilson", 2015),
        Employee("Mary", "Johnson", 2010),
        Employee("Mike", "Jones", 2002))
}

fun main() {

    //quick way to play with lambdas
    run { println("I'm in a lambda") }



    // last lambda expression can be written outside parentheses
    println(
        Employees.empList.minBy { e -> e.startYear }
    )

    // same as (but the compiler can infer the type here):
    println(
        Employees.empList.minBy { e: Employee -> e.startYear }
    )

    // we can also use it (has only one argument - employee):
    println(
        Employees.empList.minBy { it.startYear }
    )

    // also using member references operator:
    println(
        Employees.empList.maxBy(Employee::startYear)
    )

    // lambdas can also access local variables (it is a var, but in Java should be effectively final)
    var num = 10
    run {
        num += 15
        println(num)
    }

    useParameter(Employees.empList, Employees.empList.size)

    run(::someTopLevelFun)
}

fun useParameter(employees: List<Employee>, num: Int) {
    employees.forEach {
        print("${it.lastName}, ")
        println(it.firstName)
        println(num)
    }
}

fun someTopLevelFun() = println("I'm a top level function")


data class Employee(val firstName: String, val lastName: String, val startYear: Int)

