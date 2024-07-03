package ch04.ex1_5_2_SealedClasses1

// we can mark a superclass with sealed and then the compiler will prevent building the "when" expression
// when it is incomplete and we will not need a default branch
sealed class Expr
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()
//class Division(val left: Expr, val right: Expr) : Expr()

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
    }

// interfaces can be sealed too and we can expect similar behaviour in a when expression
sealed interface Toggleable {
    fun toggle()
}

