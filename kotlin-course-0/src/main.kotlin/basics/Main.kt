package basics

import kotlin.math.roundToInt


fun main(args: Array<String>) {

    hello()

    val a = (Math.random() * 20).roundToInt()
    val b = (Math.random() * 20).roundToInt()
    val c = (Math.random() * 20).roundToInt()

    validTriangle(a, b, c)

    val d = switchWhen(a, b)

    forLoops(d)

    printPrimes()

    aboutArrays()

    val arr = intArrayOf(1, 2, 3, 4, 5)
    println(isOrdered(arr))
    println(isOrdered(arr, false))

    aboutLambdas()

    println()
    println("a & b: $a $b")
    val perform = perform(a, b) { aa: Int, bb: Int -> aa + bb }
    println(perform)

    val pls1: (Int, Int) -> Int = ::plus
    val pls2 = ::plus

    printArray(map(arr) { x -> x * x })
    printArray(map(arr) {x -> -x})
}

fun hello() {
    val name = "Kotlin"
    println("Hello, $name!")
}

fun validTriangle(a: Int, b: Int, c: Int) {
    var res = "Lengths: $a, $b, $c"

    res += if (a + b > c && a + c > b && b + c > a)
        " = valid triangle"
    else
        " = not valid"

    println(res)
}

fun switchWhen(a: Int, b: Int): String {
    when (a) {
        15 -> println("Excellent")
        8, 7 -> println("Good")
        2, 4, 6 -> println("Passed")
        else -> println("Illegal")
    }

    return when (b) {
        15 -> "Excellent"
        8, 7 -> "Good"
        2, 4, 6 -> "Passed"
        else -> "Illegal"
    }
}

fun forLoops(d: String) {
    for (letter in d)
        println(letter)

    for (index in d.indices)
        if (index % 2 == 0)
            println(d[index])

    for ((index, letter) in d.withIndex())
        println("$index, $letter")
}

fun printPrimes() {
    val e = (Math.random() * 999).roundToInt() + 2
    var isPrime: Boolean
    println("Number is $e")
    for (i in 2..e) {
        isPrime = true
        for (j in 2..<i) {
            if (i % j == 0) {
                isPrime = false
                break
            }
        }
        if (isPrime) {
            println(i)
        }
    }
}

fun aboutArrays() {
    val f = IntArray(5)
    for (i in 2..10 step 2)
        f[i / 2 - 1] = i


    val g = DoubleArray(10)
    var sum = 0.0

    for (i in g.indices) {
        g[i] = Math.random() * 10
        sum += g[i]
    }

    val average: Double = sum / g.size
    println("the average is $average")

    for (num in g)
        println(
            "$num is " +
                    if (num > average)
                        "higher"
                    else
                        "lower"
        )
}

fun isOrdered(numbers: IntArray, asc: Boolean = true): Boolean {
    for (i in 0..numbers.size - 2)
        if (asc && numbers[i] > numbers[i + 1] || !asc && numbers[i] < numbers[i + 1])
            return false
    return true
}

fun aboutLambdas() {
    val h = { a: Int, b: Int -> a + b }
    var i: (Int) -> Int = { x -> x * x }
    print(i(4))

    i = { x -> 2 * x }
    i(5)
    // i = {x, y -> x + y} not working
}

fun perform(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    return op(a, b)
}

fun plus(a: Int, b: Int) = a + b

// Mapping function
fun map(numbers: IntArray, mapping: (Int) -> Int): IntArray {
    val copy = IntArray(numbers.size)
    for (i in numbers.indices)
        copy[i] = mapping(numbers[i])
    return copy
}

fun printArray(arr: IntArray) {
    for (num in arr) {
        print("$num\t")
    }
    println()
}