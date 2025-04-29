package ro.ccar.kt

interface Int1K {
    fun int1(): Int
}


open class Base3K {
    open fun openedFunction(): String = "1"
    fun closedFunction(): String = "2"
}


abstract class AbstractClass1K {
    abstract fun abstractMethod(): String

    fun concreteMethod(): String {
        return "This is a concrete method"
    }
}


class NotExtendableClassK: Base3K(), Int1K {
    override fun openedFunction(): String = "11"
    override fun int1(): Int = 10

    // closedFunction cannot be overridden
    // in classes by default, functions are closed, but in interfaces, they are opened
    // in the class definition Base3K has a constructor but Int1K does not, because it is an interface
    // as in Java, we can extend just one class but implement multiple interfaces
}


class Base5K: AbstractClass1K() {
    override fun abstractMethod(): String = "3"
}




fun main() {
    val obj = NotExtendableClassK()
    println(obj.openedFunction())
    println(obj.int1())

    val obj2 = Base5K()
    println(obj2.concreteMethod())
    println(obj2.abstractMethod())
}