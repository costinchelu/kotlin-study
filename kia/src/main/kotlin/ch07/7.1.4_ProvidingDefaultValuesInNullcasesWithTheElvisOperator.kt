package ch07.ProvidingDefaultValuesInNullcasesWithTheElvisOperator

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("No address")
    with (address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

fun strLenSafe(s: String?): Int = s?.length ?: 0


fun main() {
    println(strLenSafe("abc"))
    println(strLenSafe(null))


    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person = Person("Dmitry", jetbrains)
    printShippingLabel(person)

    try {
        printShippingLabel(Person("Alexey", null))
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
