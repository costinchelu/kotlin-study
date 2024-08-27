package geometry.shapes

class Rectangle(val height: Int, val width: Int) {

    // property with custom getter
    val isSquare: Boolean
        get() = height == width
}

fun createUnitSquare(): Rectangle {
    return Rectangle(1, 1)
}

fun main() {
    println(Rectangle(3, 4).isSquare)
    println(createUnitSquare().isSquare)

    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
}