package ch02.EvalIfWhen


interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr


fun evalIf(e: Expr): Int =
    if (e is Num) e.value
    else if (e is Sum) evalIf(e.right) + evalIf(e.left)
    else throw IllegalArgumentException("Unknown expression")

fun evalWhen(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> evalIf(e.right) + evalIf(e.left)
        else -> throw IllegalArgumentException("Unknown expression")
    }


fun main() {
    println(evalIf(Sum(Num(1), Num(2))))
    println(evalWhen(Sum(Num(1), Num(2))))
}
