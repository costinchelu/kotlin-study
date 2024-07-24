package ch07.ex1_7_DealingWithNullableExpressionsTheLetFunction

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun main() {
    var email: String? = "yole@example.com"
    email?.let { sendEmailTo(it) }

    // let will work like:  if (email != null) sendEmailTo(email)

    email = null
    email?.let { sendEmailTo(it) }

    var s1: String? = "+"
    val s2: String = s1?.let { it + "+" } ?: "+"
    println(s2)
}


/*

Use let together with the safe call operator ?. to execute a block of code only when the object you are working with
is not null. Use a standalone let to turn an expression into a variable, limited to the scope of its lambda.


Use apply to configure properties of your object using a builder-style API (e.g., when creating an instance).


Use also to execute additional actions that use your object, while passing the original object
to further chained operations.


Use with to group function calls on the same object, without having to repeat its name.


Use run to configure an object and compute a custom result.

 */