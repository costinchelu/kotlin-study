package basics

class Book(private val title: String, private val author: String, private var pages: Int) {

    private val long = 200

    init {
        if (pages <= 0) {
            pages = 1
        }
    }

    fun isLongBook() = pages > long
}

fun main() {
    val b1 = Book("1984", "George Orwell", 250)
    print(
        if (b1.isLongBook())
            "long"
        else
            "short"
    )
}