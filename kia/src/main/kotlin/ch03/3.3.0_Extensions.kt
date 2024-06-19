package strings


//  Unlike methods defined in the class, extension functions don’t have access to private or protected members of the class.
fun String.lastChar(): Char = this.get(this.length - 1)
