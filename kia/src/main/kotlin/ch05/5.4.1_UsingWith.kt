package ch05.UsingWith

// with(receiverObject) { lambda }    : returns the result of the lambda


fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
         result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

// The with structure looks like a special construct,
// but it’s a function that takes two arguments: stringBuilder, in this case, and a lambda.
// the result is the last expression in the lambda
fun alphabet2(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        this.append("\nNow I know the alphabet!")
        this.toString()
    }
}

// The with function converts its first argument into a receiver of the lambda that’s passed as a second argument.
fun alphabet3(): String =
    with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
        toString()
}

// “A lambda is a way to define behavior similar to a regular function.
// A lambda with a receiver is a way to define behavior similar to an extension function.”

fun main() {
    println(alphabet3())

    println(
        with(StringBuilder()) { append("Hi!").toString() }
    )
}
