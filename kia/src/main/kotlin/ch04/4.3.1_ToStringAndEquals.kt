package ch04.ex3_1_1_StringRepresentationToString


class Customer(val name: String, val postalCode: Int) {
    override fun toString() = "Customer(name=$name, postalCode=$postalCode)"

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Customer) return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
}

fun main() {
    val customer1 = Customer("Alice", 342562)
    val customer2 = Customer("Alice", 342562)

    // in Kotlin == checks whether the objects are equal not the references
    // by providing the equals method, customer1 will be equal to customer2
    // without equals(), the next line would have been false (== calls equals in the background)
    // in Java == compares references (does both variables are pointing to the same object in the heap?)
    println(customer1 == customer2)
    // for reference comparison we can use ===

    val processed = hashSetOf(Customer("Alice", 342562))
    // without overriding hashcode() next line will return false
    // if two objects are equal, they must have the same hashCode
    // in a hashSet, first the object's hashCodes are compared and only if they are equal, then the values are compared
    println(processed.contains(Customer("Alice", 342562)))
}