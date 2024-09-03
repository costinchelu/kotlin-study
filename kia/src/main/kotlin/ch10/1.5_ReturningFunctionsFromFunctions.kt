package ch10.ReturningFunctionsFromFunctions


// returning a function (conditioned by a delivery type)
fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    } else {
        return { order -> 1.2 * order.itemCount }
    }
}

enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)



data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?,
)

class ContactListFilters {

    var prefix: String = ""

    var onlyWithPhoneNumber: Boolean = false // default false

    // declare a function that returns a function
    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefixPredicate = { p: Person -> p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix) }
        if (!onlyWithPhoneNumber) {
            return startsWithPrefixPredicate
            // will just return the boolean (basic case - no phone number needed)
        }
        return {
            startsWithPrefixPredicate(it) && it.phoneNumber != null
            // will return a processed boolean (checks for the existence of a phone number)
        }
    }
}


fun main() {
    val order = Order(3)
    val calculateFastDelivery = getShippingCostCalculator(Delivery.EXPEDITED)
    val calculateStandardDelivery = getShippingCostCalculator(Delivery.STANDARD)
    println("Shipping costs for fast delivery: ${calculateFastDelivery(order)}")
    println("Shipping costs for standard delivery: ${calculateStandardDelivery(order)}")


    val contacts = listOf(
        Person("Dmitry", "Jemerov", "123-4567"),
        Person("Svetlana", "Isakova", null)
    )
    val contactListFilters = ContactListFilters()

    with(contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }

    // the filter method accepts a predicate as parameter and returns only the items evaluated by the parameter
    println(contacts.filter(contactListFilters.getPredicate()))     // [Person(firstName=Dmitry, lastName=Jemerov, phoneNumber=123-4567)]

    with(contactListFilters) {
        prefix = "Sv"
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(contactListFilters.getPredicate()))   // []
}