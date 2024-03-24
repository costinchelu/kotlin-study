package beginner

import java.util.Arrays
import kotlin.random.Random

fun main() {
    // null values must be verified or use the nullable operator
    // no need for if else checks
    val random: Int = Random.nextInt(100)
    val str1: String? = if (random > 49) "str1 not null" else null

    str1?.uppercase()
    println("If str1 is null ... ${str1?.uppercase()}")

    // elvis operator - assign default values for nullable obj
    val str2 = str1?: "str2 default value"

    println("If str2 is null ... $str2")

    // safe casting to prevent ClassCastException
    val something: Any = arrayOf(1, 2, 3)
    val str3 = something as? String
    println(str3)

    // not null assertion -> used when we are sure a variable will not return null
    try {
        val str4: String? = null
        val str5 = str4!!.uppercase()
    } catch (e: Exception) {
        println(e.toString())
    }

    // using the let function
    // we have a nullable string but out printText method accepts a non-nullable string
    // let says: if str1 is not null, then call the function with it (keyword)
    //printText(str1) -> not working
    str1?.let { printText(it) }

    // == is a safe operator (remember, in Kotlin it checks for value equality)
    val str6: String? = null
    val str7 = "String not null"
    println(str6 == str7)

    // create an array of some size, that can be filled later:
    val nullableInts = arrayOfNulls<Int?>(5)
    nullableInts[0] = 54
    println(Arrays.toString(nullableInts))

    // -----

    val arr: Array<Short> = arrayOf(1, 2, 3, 4, 5)  // the Short[] arr
    val arr2 = shortArrayOf(1, 2, 3, 4, 5)   // like a primitive short array: short[] arr2
    val arr3 = Array<Int?>(200 / 5) { i -> (i + 1) * 5 } // using constructor for Array and a function
    val arr4 = charArrayOf('a', 'b', 'c')  // char[]

    val x: String? = "I AM IN UPPER"
    println(if (x != null) x.lowercase() else "I give up")
    println(x?.lowercase() ?: "I give up")
    x?.let { println(it.lowercase().replace("am", "am not")) }

}

fun printText(text: String) {
    println(text)
}