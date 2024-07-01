package ch03.ex4_2_Varargs

fun main(args: Array<String>) {

    // * is the spread operator (it unpacks the Array<String>
    val list = listOf("args: ", *args)
    println(list)

    val newArgs = args.plusElement("args2 ").plusElement("args 3")
    val list2 = listOf("args: ", *newArgs)
    println(list2)
}
