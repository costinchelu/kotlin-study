package ch05

import kotlin.random.Random


/*
FUNCTION        |      Access to x via     |     Return value

x.let { ... }               it                  result of lambda
x.also { ... }              it                          x
x.apply { ... }             this                        x
x.run { ... }               this                result of lambda
with(x) { ... }             this                result of lambda

 */

fun sendNotification(recipientAddress: String): String {
    println("Hello $recipientAddress!")
    return "Notification sent"
}

fun getNextAddress(): String? {
    return if (Random.nextInt() > 0) null
    else "mail@mail.com"
}

class Client {
    var token: String? = null
    fun connect() = if (token != null) println("connect...") else println("no connection")
    fun authenticate() = if (token != null) println("authenticated") else println("no token")
    fun getData(): String = "Data..."
}

class Canvas {
    fun rectangle(x: Int, y: Int, w: Int, h: Int) = println("$x, $y, $w, $h")
    fun circle(x: Int, y: Int, rad: Int) = println("$x, $y, $rad")
    fun text(x: Int, y: Int, str: String) = println("$x, $y, $str")
}

// initialized in some other place
val client = Client()


fun usingLet() {
    val addr: String? = getNextAddress()

    val confirm1: String? = if (addr != null) sendNotification(addr) else null

    // LET{} will run the lambda (send the notification) ONLY IF addr IS NOT NULL
    val confirm2: String? = addr?.let { sendNotification(it) }
}

fun usingApply() {
    client.token = "asdf"
    client.connect()
    client.authenticate()
    client.getData()

    // or use apply to keep initialization of the client and the rest of the calls together
    // in this case apply looks like a builder
    val client2: Client = Client().apply {
        token = "1234"
        connect()
        authenticate()
    }

    client2.getData()
}

fun usingRun() {
    // RUN{} is close to APPLY{}
    // apply{} only configures the object but run also computes the result
    val result: String = client.run {
        token = "4455"
        connect()
        authenticate()
        getData()
    }
    println(result)
}

fun usingAlso() {
    // ALSO{} will introduce some side effects.
    val medals = listOf("Gold", "Silver", "Bronze")
    val reversedLongUppercaseMedals: List<String> =
        medals
            .map { it.uppercase() }
            .also { println(it) }
            .filter { it.length > 4 }
            .also { println(it) }
            .reversed()
            .also { println(it) }
}

fun usingWith() {
    val mainMonitorPrimaryBufferBackedCanvas = Canvas()

    // WITH(){} - group multiple operations applied to a variable
    with(mainMonitorPrimaryBufferBackedCanvas) {
        text(10, 10, "foo")
        circle(10, 30, 44)
        text(10, 10, "foo")
        circle(10, 30, 44)
        text(10, 10, "foo")
        circle(10, 30, 44)
        text(10, 10, "foo")
        circle(10, 30, 44)
        text(10, 10, "foo")
        circle(10, 30, 44)
        text(10, 10, "foo")
        circle(10, 30, 44)
        text(10, 10, "foo")
        circle(10, 30, 44)
    }
}

fun main() {
    usingLet()
    usingApply()
    usingRun()
    usingAlso()
    usingWith()
}

/*
Examples of conversion from if else to scope functions:


fun Order.isPaidWithKlarna(): Boolean =
    if (transactions.isNotEmpty())
        (transactions[0].type.isCreditCard() &&
        isCardNumberContainingKlarnaBins(transactions[0].cardNumber))
    else false


fun Order.isPaidWithKlarna(): Boolean =
    transactions.firstOrNull()?.let {
        it.type.isCreditCard() &&
        isCardNumberContainingKlarnaBins(it.cardNumber)
    }
    ?: false




private fun isCardNumberContainingKlarnaBins(cardNumber: String?) =
    if (cardNumber != null)
        KLARNA_BINS.any { cardNumber.contains(it) }
    else false


private fun isCardNumberContainingKlarnaBins(cardNumber: String?) =
    cardNumber?.let {
        KLARNA_BINS.any { it in cardNumber } }
    ?: false



 */
