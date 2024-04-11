package demo

// extension function. This example will (pseudo)extend String class
fun String.upperFirstAndLast(): String {
    val upperFirst = this.substring(0, 1).uppercase() + this.substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).uppercase()
}

/*
fun String.upperFirstAndLast(input: String): String {
    val upperFirst = input.substring(0, 1).uppercase() + input.substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).uppercase()
}
 */