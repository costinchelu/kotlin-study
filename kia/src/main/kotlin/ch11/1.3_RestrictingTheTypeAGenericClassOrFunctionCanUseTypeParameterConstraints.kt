package ch11.RestrictingTheTypeAGenericClassOrFunctionCanUseTypeParameterConstraints

fun <T : Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}

fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

fun <T> ensureTrailingPeriod(seq: T)
        where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

fun main() {
    println(oneHalf(3))                         // 1.5


    println(max("kotlin", "java"))              // kotlin


    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)                         //Hello World.
}
