package ch03.ex3_5_ExtensionProperties


// because this property is defined outside the class, it will not be backed and therefore it will not have getter/setter
// so the setter would be mandatory because there would be no way to access the property
val String.lastChar: Char
    get() = this.get(length - 1)

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
}
