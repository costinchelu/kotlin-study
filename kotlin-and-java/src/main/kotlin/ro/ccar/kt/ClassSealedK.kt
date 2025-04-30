package ro.ccar.kt.sealed

// in Kotlin a sealed class can only be inherited in the same package
sealed class ExprSealed

data class ConstPermitted(val number: Double) : ExprSealed()

data class SumPermitted(val e1: ExprSealed, val e2: ExprSealed) : ExprSealed()

object NotANumber : ExprSealed()

fun eval(expr: ExprSealed): Double = when (expr) {
    is ConstPermitted -> expr.number
    is SumPermitted -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
}

// the `else` clause is not required because we've covered all the cases
