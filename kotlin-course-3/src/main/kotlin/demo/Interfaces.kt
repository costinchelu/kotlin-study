package demo

interface MyInterface {

    val intConst: Int

    fun myFunction(str: String): String
}

interface MySubInterface: MyInterface {

    // we can create this concrete property only by using get()
    val concreteProp: Int
        get() = 30

    fun mySubFunction(num: Int): String
}

open class Something2 {

    val someProp: String

    constructor(someParam: String) {
        someProp = someParam
        println("Something class")
    }
}

class SomethingElse2: Something2, MySubInterface {

    override val intConst: Int = 25

    constructor(someOtherString: String, y: Int): super(someOtherString) {
        println("SomethingElse class")
    }

    override fun mySubFunction(num: Int): String {
        return num.toString()
    }

    override fun myFunction(str: String): String {
        return str.uppercase()
    }
}