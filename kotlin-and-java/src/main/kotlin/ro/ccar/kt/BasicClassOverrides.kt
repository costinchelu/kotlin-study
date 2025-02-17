package ro.ccar.kt


open class Base3K {

    open fun openedFunction(): String = "1"

    fun closedFunction(): String = "2"
}

class NotExtendableClassK: Base3K() {

    override fun openedFunction(): String = "11"

    // closedFunction cannot be overridden
}