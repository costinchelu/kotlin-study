package demo

fun main() {

    println(countTo100())
    println(countTo100v5())

    findByLastName(Employees.empList, "Wilson")
    findByLastName(Employees.empList, "Smithson")

    "Some String".apply ss@ {
        "Another String".apply {
            println(this@ss.uppercase())
            println(this.lowercase())
        }
    }
}

fun countTo100(): String {
    val numbers = StringBuilder()
    for (i in 1..99) {
        numbers.append(i)
        numbers.append(", ")
    }
    numbers.append(100)
    return numbers.toString()
}

// equivalent with countTo100 (no need to refer to the receiver object, or we can even refer to it with this keyword):
fun countTo100v2(): String {
    val numbers = StringBuilder()
    return with(numbers) {
        for(i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }
}

// more concise
fun countTo100v3(): String {
    return with(StringBuilder()) {
        for(i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }
}

// even more concise:
fun countTo100v4() =
    with(StringBuilder()) {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }

// using apply
fun countTo100v5() =
    StringBuilder().apply {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
    }.toString()

fun findByLastName(employees: List<Employee>, lastName: String) {
    // in Kotlin, the return will return from the lambda, as usual, but will also return from the whole function
    // if we need to return only from the lambda or from a specific block, we can use labels for that (it is a form of goto)
    // in Java, labels are like LabelName: and are called by just calling the name of the label -> break LabelName
    // in Kotlin are like LabelName@ and are called with -> break@LabelName
    employees.forEach {
        if (it.lastName == lastName) {
            println("Yes, there's an employee with last name $lastName.")
            return
        }
    }
    println("Nope, no employee with last name $lastName found.")
}