package ch08.ex2_5_Arrays

fun main(args: Array<String>) {

    // we can use array index
    for (i in args.indices) {
         println("Argument $i is: ${args[i]}")
    }


    args.forEachIndexed { index, element -> println("Argument $index is: $element") }



    val letters: Array<String> = Array(26) { i -> ('a' + i).toString() }
    println(letters.joinToString(""))
    val nulls: Array<String?> = arrayOfNulls(3)
    println(nulls.joinToString(" "))




    // format method requests an array as an argument
    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray()))



    val squares = IntArray(5) { i -> (i+1) * (i+1) }
    println(squares.joinToString())
}
