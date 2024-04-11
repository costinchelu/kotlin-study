package demo


fun main() {
    usingWhen()
    forLoops()
    whileLoops()
    println(maxOf(3, 5))
    println(maxOf(5, 2, 8))
}

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

    when (temp) {
        in 0..9 -> println("very cold")
        in 10..<20 -> println("a bit cold")
        in 20..29 -> println("warm")
        else -> println("hot")
    }

    val description = when {
        temp < 0 -> "very cold"
        temp < 10 -> "a bit cold"
        temp < 20 -> "warm"
        else -> "hot"
    }
    println(description)
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

// standard if
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

// expression if
fun maxOf(a: Int, b: Int, c: Int) = if (a > b && a > c) a else if (b > a && b > c) b else c