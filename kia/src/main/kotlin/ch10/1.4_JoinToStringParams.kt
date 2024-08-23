package ch10.JoinToStringParams


// transform specifies a default implementation of how the individual values are converted to string
fun <T> Collection<T>.joinToStringV1(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = { it.toString() },
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(transform(element))
    }

    result.append(postfix)
    return result.toString()
}

// a nullable version with no default implementation (transform is a nullable parameter)
// invoke can be called through the safe-call syntax: callback?.invoke()
// if callback is not specified it uses a default implementation with the elvis operator
fun <T> Collection<T>.joinToStringV2(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null,
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        val transformed = transform?.invoke(element) ?: element.toString()
        result.append(transformed)
    }

    result.append(postfix)
    return result.toString()
}

fun main() {
    val letters = listOf("Alpha", "Beta")

    println(letters.joinToStringV1())                         // Alpha, Beta

    // here we are changing the default implementation of the conversion function:
    println(letters.joinToStringV1 { it.lowercase() })        // alpha, beta

    println(
        letters.joinToStringV1(separator = "! ", postfix = "! ", transform = { it.uppercase() })
    )
    // ALPHA! BETA!
}
