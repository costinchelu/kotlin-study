package ch02.ex4_2_2_IteratingOverNumbersRangesAndProgressions

import ch02.WhenEnums.Color.*


fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun main() {
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
    println()
    println()

    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }
    println()
    println()

    val colorList = listOf(INDIGO, ORANGE, BLUE)
    for (color in colorList) {
        print("$color [${"%08X".format(color.rgb())}] ")
    }
}
