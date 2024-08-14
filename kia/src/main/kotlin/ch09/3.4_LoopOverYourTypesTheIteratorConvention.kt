package ch09.ex4_LoopOverYourTypesTheIteratorConvention

import java.time.LocalDate

const val n = 9

val now: LocalDate = LocalDate.now()


operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object : Iterator<LocalDate> {
        var current: LocalDate = start

        override fun hasNext(): Boolean = current <= endInclusive

        override fun next(): LocalDate {
            val initialDate = current
            current = current.plusDays(1)
            return initialDate
        }
    }


fun main() {
    // x..y calls the rangeTo function (returns a Range)
    println(0..(n + 1))                 // 0..10
    (0..n).forEach { print(it) }        // 0123456789
    println()


    val vacation: ClosedRange<LocalDate> = now..now.plusDays(10)
    println(now.plusWeeks(1) in vacation)


    val newYear: LocalDate = LocalDate.ofYearDay(2042, 1)
    val daysOff: ClosedRange<LocalDate> = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) {
        println(dayOff)
    }
    // 2041-12-31
    // 2042-01-01
}