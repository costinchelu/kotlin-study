package ch09.ex2_CompoundAssignmentOperators

data class Point(val x: Int, val y: Int)

operator fun Point.plus(other: Point) = Point(x + other.x, y + other.y)


fun main() {
    // mutable point
    var point = Point(1, 2)

    // by default += is also supported
    point += Point(3, 4)
    println(point)
    // Point(x=4, y=6)


    val numbers = mutableListOf<Int>()
    // add element to collection
    numbers += 42
    numbers += 5
    println(numbers[0])
    println(numbers[1])
    // 42   5


    val list = mutableListOf(1, 2)
    list += 3
    val newList = list + listOf(4, 5)
    println(list)
    // [1, 2, 3]
    println(newList)
    // [1, 2, 3, 4, 5]
}
