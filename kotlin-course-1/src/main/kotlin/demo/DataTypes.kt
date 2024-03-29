package demo

fun main() {

    // INT LONG
    val anInt = 22
    val aLong = 22L

    // we can't do a direct conversion from int to long like in Java
    var aLong2 = anInt.toLong()

    // BYTE SHORT
    val aByte: Byte = 127
    val aShort: Short = aByte.toShort()

    // DOUBLE FLOAT
    var aDouble = 68.258
    var aFloat = 68.258F

    var aDouble2 = aFloat.toDouble()
    var aFloat2 = aDouble.toFloat()

    // CHAR
    var aChar = 'b'

    // no automatic conversion from an int to char (we need to use toChar())
    var aChar2: Char = anInt.toChar()

    // STRING
    val aString = "some String"

    // BOOLEAN
    var aBoolean = true

    // interaction with Java:
    val vacationTime = false
    val onVacationMessage = DummyClass().isVacationTime(vacationTime)
    println(onVacationMessage)

    // Any -> root of any class in Kotlin
    val anything: Any = Employee("e1", 15)
}