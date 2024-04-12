package demo

import java.math.BigDecimal
import java.math.RoundingMode


fun main() {
    usingWhen()
//    ranges()
//    forLoops()
//    whileLoops()
//    println(maxOf(3, 5))
//    println(maxOf(5, 2, 8))
}

// the switch statement in Java
fun usingWhen() {
    val hello = "Hello"

    when (hello) {
        "1" -> println("One")
        "Hello" -> println("Greeting")
        else -> println("Default case")
    }

    val result = when (hello) {
        "a" -> 258
        "b" -> 15.2
        "Hello" -> 25
        else -> "Other"
    }
    println(result)

    val temp = 18

    // we can use ranges
    when (temp) {
        in 0..9 -> println("very cold")
        in 10..<20 -> println("a bit cold")
        in 20..29 -> println("warm")
        else -> println("hot")
    }

    // we can use expressions
    val description = when {
        temp < 0 -> "very cold"
        temp < 10 -> "a bit cold"
        temp < 20 -> "warm"
        else -> "hot"
    }
    println(description)

    val obj: Any = "I'm actually a string"
    val obj2: Any = BigDecimal(25.2)
    val obj3: Any = 44

    val someObject: Any = obj2

    when(someObject) {
        is String -> println(someObject.uppercase())
        is BigDecimal -> println((someObject.remainder(BigDecimal(10.5)).setScale(3, RoundingMode.HALF_UP)))
        is Int -> println("${someObject - 22}")
    }

    // for expressions we need an else case
    val resultString = when(someObject) {
        is String -> someObject.uppercase()
        is BigDecimal -> someObject.remainder(BigDecimal(10.5)).toPlainString()
        is Int -> "${someObject - 22}"
        else -> "No value"
    }
    println(resultString)
}

fun ranges() {
    val intRange = 1..5
    val charRange = 'a'..'t'
    val stringRange = "ACC".. "DEF"
    val backwardRange = 5 downTo(1)
    val stepRange = 3..21 step 3
    val reversedRange = intRange.reversed()

    println(3 in intRange)
    println('m' in charRange)
    println("CCCCC" in stringRange)
    println(3 in backwardRange)
}

// If your function doesn't return a useful value then its return type is Unit.
// Unit is a type with only one value – Unit.
// You don't have to declare that Unit is returned explicitly in your function body.
// This means that you don't have to use the return keyword or declare a return type
fun forLoops() {
    val numbers = listOf(1, 2, 3, 4, 5)

    for (number in numbers) {
        println(number)
    }

    for (i in 0..4) {
        println(numbers[i])
    }

    numbers.forEach { println(it)}

    for (i in numbers.indices) {
        println(numbers[i])
    }

    for (i in 0 until numbers.size) {
        println(numbers[i])
    }

    for (i in numbers.size - 1 downTo 0) {
        println(numbers[i])
    }
}

fun whileLoops() {
    var i = 0

    while (i < 5) {
        println(i)
        i++
    }

    do {
        println(i)
        i++
    } while (i < 5)
}

// standard if (with return value)
fun maxOf(a: Int, b: Int): Int {
    return if (a > b) {
        println("a = $a is bigger")
        a
    } else {
        println("b = $b is bigger")
        b
    }
}

// expression if
fun maxOf(a: Int, b: Int, c: Int) = if (a > b && a > c) a else if (b > a && b > c) b else c