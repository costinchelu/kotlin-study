package ch07.ex1_3_CombiningNullchecksAndMethodCallsWithTheSafeCallOperator


class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee.manager?.name

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun Person.countryName(): String {
    val country: String? = this.company?.address?.country
    return if (country != null) country else "Unknown"
}

fun printAllCaps(str: String?) {
    val allCaps: String? = str?.uppercase()
    println(allCaps)
}

fun printAllCapsNoNull(str: String) {
    val allCaps: String = str.uppercase()
    println(allCaps)
}

fun main() {
    printAllCaps("abc")
    printAllCaps(null)

    var nullableString: String? = "abc"
    printAllCapsNoNull("abc")

    // nullable string can be used only with a null check when a non-nullable String is required
    if (nullableString != null) {
        printAllCapsNoNull(nullableString)
    }
//    printAllCapsNoNull(null)  -> compiler will return an error


    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(managerName(developer))
    println(managerName(ceo))


    val person = Person("Dmitry", null)
    println(person.countryName())
}







