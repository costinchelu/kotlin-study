package ch09.ex1_EqualityOperators

class Point(val x: Int, val y: Int) {

    // equals doesn't need to be marked as operator (but is marked as ovveride)
    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Point) return false
        return other.x == x && other.y == y
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}

fun main() {
    // in Kotlin == is translated as equals()
    // and === is same as == in Java (reference comparison)
    // unlike all other operators, == and != can be used with nullable operands because those operators
    // check equality to null under the hood
    println(Point(10, 20) == Point(10, 20))
    // true
    println(null == Point(10, 20))
    // false
    println(Point(10, 20) != Point(5, 5))
    // true
    println(null == Point(1, 2))
    // false
}
