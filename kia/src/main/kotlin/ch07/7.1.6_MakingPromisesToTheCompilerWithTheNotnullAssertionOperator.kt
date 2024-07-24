package ch07.ex1_6_MakingPromisesToTheCompilerWithTheNotnullAssertionOperator

fun ignoreNulls(str: String?) {
    // we are promising str is not null
    val strNotNull: String = str!!
    println(strNotNull.length)
}

fun main() {
    // this will generate a null pointer exception. We must be very sure that the argument is not null
    ignoreNulls(null)
}
