// we can give a java name to the static class that will be created by Java in order to access Kt top level functions
@file:JvmName("StaticKt")

package callkotlin

import calljava.Car
import java.io.IOException
import kotlin.jvm.Throws

fun main() {

    val car = Car("blue", "Ford", 2015)

    car.color = null    // calls setter
    println(car.javaClass)
    println(car.color)  // calls getter

    val strings = arrayOf("Hello", "goodbye")
    car.variableMethod(5, "Hello", "goodbye")
    car.variableMethod(5, *strings) // can't directly pass an array. we are using the spread operator

    car.wantsIntArray(arrayOf(1, 2, 3).toIntArray()) // we can only pass intArrayOf for a Java primitive int[]
    car.wantsIntArray(intArrayOf(1, 2, 3))

    val kObj = car.obj  // java.lang.Object = Any

    println("x = ${Car.x}")
    println(Car.xString())

    car.demoMethod { println("In a thread") }

    "Some text".print()

    KCar.carComp()
}

// @JvmField = permits direct access to a field from Java
// @JvmStatic is used for Java to directly access a companion property without creating a companion object
class KCar(val color: String, @JvmField val model: String, val year: Int, val automatic: Boolean, fixedColor: String) {

    var fixedColor: String = fixedColor
        set(value) {
            field = fixedColor
        }

    companion object {

        const val IS_AUTO = true

        @JvmStatic
        fun carComp() = println("In the kCar's companion object")
    }

    fun printMe(text: String?) {
        println("I don't expect a null value:  $text?")
    }
}


fun topLevelFunction() = println("I'm in a Kotlin file")


@Throws(IOException::class)
fun doIO() {
    throw IOException()
}


fun String.print() {
    println(this)
}


// this annotation will make Kotlin create all overloaded versions of this function to be accessible from Java
// (or else only the default form (with both mandatory arguments) is created)
@JvmOverloads
fun defaultArgs(str: String, num: Int = 25) {

}


object SingletonObj {
    @JvmStatic
    fun doSomething() = println("I'm doing something in the singleton object.")
}