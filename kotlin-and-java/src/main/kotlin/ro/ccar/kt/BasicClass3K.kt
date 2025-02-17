package ro.ccar.kt


// class with default value
class BasicClass3K(var defaultName: String = "")



class BasicCLass4K(parent: BasicClassK) {

    private var _parent: BasicClassK? = parent

    // example with Kotlin Property with custom accessors
    // in this case the _parent acts as a backing field for the parent property
    var parent: BasicClassK?
        get() = _parent
        set(value) {
            _parent = value
        }
}


fun main() {
    val obj1 = BasicClass3K()
    obj1.defaultName = "name"

    val obj2 = BasicCLass4K(BasicClassK("name"))
    val obj2Parent = obj2.parent
    obj2.parent = BasicClassK("name2")
}