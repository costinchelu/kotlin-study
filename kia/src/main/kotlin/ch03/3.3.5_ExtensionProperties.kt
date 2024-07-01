package ch03.ex3_5_ExtensionProperties


// because this property is defined outside the class, it will not be backed, and therefore it will not have getter/setter
// the getter is mandatory because there would be no way to access the extension property
val String.lastChar: Char
    get() = this[length - 1]

// example with getter and setter
var StringBuilder.lastChar: Char
    get() = this[length - 1]
    set(value) {
        this.setCharAt(length - 1, value)
    }

fun main() {
    val sb = StringBuilder("Kotlin?")
    println(sb.lastChar)
    sb.lastChar = '!'
    println(sb)

    println("test".lastChar)
}
    // in Java, we will need to access the properties using the implicit getters/setters
    // Java example: StringUtilKt.getLastChar("test");
    // Java example: StringUtilKt.setLastChar(sb, "!");
