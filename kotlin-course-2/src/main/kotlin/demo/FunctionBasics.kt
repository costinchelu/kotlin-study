package demo

fun functionBasics() {
    println(labelMultiply(7, 8, "The result is"))

    //  arguments can be also named
    // varargs
    val c1 = Car("blue", "Toyota", 2015)
    val c2 = Car("red", "Ford", 2014)
    val c3 = Car("gray", "Mazda", 2024)
    val c4 = c3.copy()
    printColors(c1, c2, c3)

    val arr1 = arrayOf(c1, c2, c3)
    val arr2 =  arrayOf(c2, c3)
    // the "spread" operator: getting varargs from an Array (in Java is done automatically)
    val arr3 = arrayOf(*arr1, *arr2, c4)
    printColors(*arr1)
    printColors(*arr3)

    val input = "this is all in lowercase"
    println(input.upperFirstAndLast())

}

fun printColors(vararg cars: Car) {
    for (car in cars) {
        println(car.color)
    }
}

//fun labelMultiply(operand1: Int, operand2: Int, label: String): String {
//    return ("$label ${operand1 * operand2}")
//}

// Function(T, R)
fun labelMultiply(operand1: Int, operand2: Int, label: String) = "$label ${operand1 * operand2}"

data class Car(var color: String, val model: String, val year: Int)