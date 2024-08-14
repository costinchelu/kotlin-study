package ch09.ex2_InOperator

data class Point(val x: Int, val y: Int)

data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x..<lowerRight.x
            &&
            p.y in upperLeft.y..<lowerRight.y
}

fun main() {
    val rectangle = Rectangle(Point(10, 20), Point(50, 50))

    println(Point(20, 30) in rectangle)     // true
    println(Point(9, 40) in rectangle)      // false

    println(Point(10, 49) in rectangle)     // true
    println(rectangle.contains(Point(10, 49)))  // true
}
