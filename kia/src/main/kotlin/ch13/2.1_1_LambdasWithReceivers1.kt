package ch13.LambdaWithReceivers1

// Using a regular lambda -> we need to add it. for each operation in the lambda
fun buildStringRegularLambda(builderAction: (StringBuilder) -> Unit): String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}

// using lambda with receivers -> no need for it because we are already referring to a StringBuilder
// because this lambda passes the StringBuilder like in an extension function
fun buildStringWReceiver(builderAction: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

fun main() {
    val s = buildStringRegularLambda {
        it.append("Hello, ")
        it.append("World!")
    }
    println(s)                      // Hello, World!


    val s2 = buildStringWReceiver {
//        this.append("Hello, ")  -> default form, referring to the passed StringBuilder
        append("Hello, ")
        append("World!")
    }
    println(s2)                      // Hello, World!
}
