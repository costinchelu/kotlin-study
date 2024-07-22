package ch05.ex2_2_SAMConstructors

// single abstract method construction - the only argument being a lambda
fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All done!") }
}


// functional interface (one abstract method)
fun interface  IntCondition {

    fun check(num: Int): Boolean

    fun checkString(s: String) = check(s.toInt())

    fun checkChar(ch: Char) = check(ch.digitToInt())
}

fun checkCondition(i: Int, condition: IntCondition): Boolean {
    return condition.check(i)
}

fun interface StringConsumer {
    fun consume(s: String)
}

fun consumeFunction(stringConsumer: StringConsumer) {
    stringConsumer.consume("Hello")
}

fun consumeFunctional(stringConsumer: (String) -> Unit) {
    stringConsumer("Hello")
}

/*
When used from Java, the variant of the function using a fun interface can be called with a simple lambda,
whereas the variant using Kotlin functional types requires the lambda to explicitly return Kotlin’s Unit.INSTANCE:

import kotlin.Unit;

public class MyApp {

    public static void main(String[] args) {

        MainKt.consumeFunction(s -> System.out.println(s.toUpperCase()));

        MainKt.consumeFunctional(s -> {
            System.out.println(s.toUpperCase());
            return Unit.INSTANCE;
        });
    }
}
*/

fun main() {
    createAllDoneRunnable().run()

    val isOdd: IntCondition = IntCondition { it % 2 != 0 }
    println(isOdd.check(1))
    println(isOdd.checkString("2"))
    println(isOdd.checkChar('3'))

    println(checkCondition(2) { it % 2 != 0 })

}
