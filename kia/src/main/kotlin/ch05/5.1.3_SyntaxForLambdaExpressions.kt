package ch05.ex1_3_1_SyntaxForLambdaExpressions

fun main() {

    // we can directly run lambda
    { println(42) }()

    // or
    run { println(42) }

    // single line lambda
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    println(sum(1, 2))

    // multi-line lambda
    val sum2: (Int, Int) -> Int = {
        x: Int, y: Int -> println("Computing the sum of $x and $y...")
        x + y
    }
    println(sum2(1, 2))
}
