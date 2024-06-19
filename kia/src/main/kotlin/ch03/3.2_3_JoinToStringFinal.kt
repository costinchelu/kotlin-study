package ch03.JoinToStringUtilityFunction


// function can be declared with default parameter values (so when invoking this function we can omit some of the parameters:
// transformed in an extension function for Collections
fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

// JvmOverloads instructs the compiler to generate Java overloaded methods, omitting each parameter one by one starting from
// the last one
@JvmOverloads
fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)


fun main() {
    val list = listOf(1, 2, 3)
    val set = setOf(1, 2, 3)

    // we can specify the name of the arguments
    println(list.joinToString(separator = "; ", prefix = "(", postfix = ")"))
    println(list.joinToString(prefix = "(", postfix = ")"))
    println(set.joinToString())
    println(set.joinToString(" "))

    println(listOf("one", "two", "eight").join(" "))

    performCountOp()
}

// we can also have top level properties
// the value of this property will be stored in a static field
var opCount = 0

// constant
const val SOME_CONSTANT = 5

fun performCountOp() {
    opCount++
    opCount += SOME_CONSTANT
    println(opCount)
}
