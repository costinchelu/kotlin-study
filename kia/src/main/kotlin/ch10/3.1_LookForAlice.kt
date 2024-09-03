package ch10.LookForAlice

data class Person(val name: String, val age: Int)

val people = listOf(Person("Alice", 29), Person("Bob", 31), Person("John", 35))

fun lookForAlice(people: List<Person>) {
    for (person in people) {
        if (person.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

// non-local return - returns from a larger block than the block containing the return statement
fun lookForAliceV2(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

// local return - it will skip over names that are not Alice (but it will iterate through all elements of the list)
fun lookForAliceV3(people: List<Person>) {
    people.forEach label@{
        if (it.name != "Alice") return@label
        print("Found Alice!")
    }
}

// we can use the name of the function that takes the lambda as an argument to be used as a label
fun lookForAliceV4(people: List<Person>) {
    people.forEach {
        if (it.name != "Alice") return@forEach
        print("Found Alice!")
    }
}

fun main() {
    lookForAlice(people)        // Found!
    lookForAliceV3(people)

    println()

    println(StringBuilder().apply sb@{
        listOf(1, 2, 3).apply {
            this@sb.append(this.toString())
        }
    })
    // [1, 2, 3]
}
