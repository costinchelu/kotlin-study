package ch11.RestrictingTheTypeAGenericClassOrFunctionCanUseTypeParameterConstraints

// upper bound generic constraint
fun <T : Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}

// specific constraint for types that implements Comparable (upper bound being Comparable<Any>)
fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

// we can create multiple constraints (T must implement Appendable and be a CharSequence type)
fun <T> ensureTrailingPeriod(seq: T) where
        T : CharSequence,
        T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

// Without an upper bound, a nullable value can be used (so process(null) would be possible)
// Even if we are not intending to add an upper bound,
// if we need a non-nullable type we should at least use Any as un upper bound,
// or we can use a specific definitely non-nullable syntax at its use site (fun process(t: T & Any) {} )
class Processor<T: Any> {
    fun process(value: T) {
        value.hashCode()
    }
}

fun main() {
    println(oneHalf(3))                    // 1.5

    println(max("kotlin", "java"))              // kotlin

    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)                         // Hello World.
}
