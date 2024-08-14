package ch09.OperatorMember

data class Point(val x: Int, val y: Int) {

    // operator created using a member function
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

fun main() {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)
    // Point(x=40, y=60)
}

/*

a + b       plus
a - b       minus
a * b       times
a / b       div
a % b       mod

 */