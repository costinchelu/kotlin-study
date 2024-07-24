package ch06.ex2_2_CreatingSequences

import java.io.File

fun File.isInsideHiddenDirectory() = generateSequence(this) { it.parentFile }.any { it.isHidden }


fun main() {
    val naturalNumbers: Sequence<Int> = generateSequence(0) { it + 1 }
    val numbersTo100: Sequence<Int> = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())


    val file = File("/Users/svtk/.HiddenDir/a.txt")
    println(file.isInsideHiddenDirectory())
}
