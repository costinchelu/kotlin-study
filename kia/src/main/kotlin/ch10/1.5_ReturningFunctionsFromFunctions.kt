package ch10.ex5_2_ReturningFunctionsFromFunctions1


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

    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefix = { p: Person ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber) {
            return startsWithPrefix
        }
        return {
            startsWithPrefix(it) && it.phoneNumber != null
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
    println(
        contacts.filter(contactListFilters.getPredicate())
    )
    // [Person(firstName=Dmitry, lastName=Jemerov, phoneNumber=123-4567)]

}

