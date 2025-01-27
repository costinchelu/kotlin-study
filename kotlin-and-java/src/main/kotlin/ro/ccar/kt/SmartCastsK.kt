package ro.ccar.kt

interface Expr


class Num(val value: Int) : Expr


class Sum(val left: Expr, val right: Expr) : Expr


fun evalWhen(e: Expr): Int =
    when (e) {
        is Num ->
            e.value
        is Sum ->
            evalWhen(e.right) + evalWhen(e.left)
        else ->
            throw IllegalArgumentException("Unknown expression")
    }

class SmartCastsKotlin {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(evalIf(Sum(Sum(Num(1), Num(2)), Num(4))))
        }

        private fun evalIf(e: Expr): Int {
            if (e is Num) {
                return e.value
            }
            if (e is Sum) {
                return evalIf(e.right) + evalIf(e.left)
            }
            throw IllegalArgumentException("Unknown expression")
        }
    }
}

// main works outside the class, but inside a class it needs to be "static"
// in kotlin there is no static word, but companion objects can be created
fun main() {
    println(evalIf(Sum(Sum(Num(1), Num(2)), Num(4))))
}

private fun evalIf(e: Expr): Int {
    if (e is Num) {
        return e.value
    }
    if (e is Sum) {
        return evalIf(e.right) + evalIf(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}