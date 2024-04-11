package demo


fun main() {
    val p1 = LaserPrinter("HP", 5)
    p1.printModel()
    println(p1.ppm)

    val p2 = SpecialLaserPrinter("Brother")
    p2.printModel()
    println(p2.ppm)

    val s1 = SomethingElse("se", 2)
}

/*
open keyword = this class is no longer final, so it can be extended
data classes cannot be opened and cannot be abstract (but they can extend other classes)
if the class is abstract, then we don't need open
 */
abstract class Printer(val modelName: String) {

    // by default functions are also final public (like the class)
    // so when we need to override them - we choose open
    // basic non-abstract one line method
    open fun printModel() = println("The model of this printer is $modelName")

    abstract fun bestSellingPrice(): Double
}

// in order to inherit a class we need to add the parent class constructor call after colon
open class LaserPrinter(modelName: String, var ppm: Int): Printer(modelName) {

    // override is a keyword in Kotlin (compared to Java's annotation)
    // override means that te method is also open (so it is not final anymore and can be overridden)
    // but we can use the final keyword to make it not overridable
    final override fun printModel() = println("The model of this laser printer is $modelName and has a ppm of $ppm")

    // even though we implement an abstract method we still need override
    override fun bestSellingPrice(): Double = 129.99
}

class SpecialLaserPrinter(modelName: String): LaserPrinter(modelName, 8)



open class Something(someString: String, x: Int) {

    constructor() : this(someString = "S", x = 1) {
        println("Something class")
    }
}

// even if the child class doesn't have any fields it can still create its secondary constructor calling the parent's primary constructor
class SomethingElse: Something {

    constructor(someOtherString: String, y: Int): super(someOtherString, y) {
        println("SomethingElse class")
    }
}