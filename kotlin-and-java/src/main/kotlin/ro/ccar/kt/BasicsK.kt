package can.be.named.as_needed

import ro.ccar.java.BasicsJ

// constant (outside class)
const val z: Int = 3        // const is used only in compile time

class BasicsK {

    private fun methodReturningUnit(param1: String, param2: Int) {

        // variable
        var x: Int = 1
        var x1 = 1

        // constant
        val y: Int = 2          // y is set in runtime
    }

    fun instantiationExample() {
        // instantiating an object from Java code
        val javaObject = BasicsJ()
    }

    fun whenExample(value: Int): Char {
        return when (value) {
            in 0..4 -> 'a'
            5 -> 'b'
            6, 7, 8 -> 'c'
            9 -> 'd'
            in 10..20 -> 'e'
            else -> throw Error()
        }
    }

    fun forLoopExample() {
        for ( i  in 0..10 ){
            println(i)
        }

        val intList: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        for (number in intList) {
            println(number)
        }
    }

    fun castingExample() {
        val obj: Any = "Hello"

        if (obj is String) {
            val message: String = obj // Automatic type casting
        }
    }

    fun functionalExample() {
        val numbers = listOf(1, 2, 3, 4, 5)
        val sum = numbers.sum()
    }

    fun assignFromIf(a: Int, b: Int) {
        val max =
            if (a > b) {
                println("choose a($a)")
                a
            } else {
                println("choose b($b)")
                b
            }
        println("Max: $max")
    }

    fun assignIfNotNull(value: String?) {
        value?.let {
            val length = value.length
            println(length)
        }

        val length2 = value?.length
        println(length2)
    }

    fun compactFunction1() = println("I am calling the user...");

    fun compactFunction2() = 12;
}