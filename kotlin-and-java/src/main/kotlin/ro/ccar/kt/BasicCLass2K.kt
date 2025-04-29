package ro.ccar.kt

// primary constructor between ()
class BasicCLass2K(val name: String, var age: Int) {

    private var parent: BasicClassK? = null

    // secondary constructor (calls primary constructor)
    constructor(name: String, age: Int, parent: BasicClassK) : this(name, age) {
        this.parent = parent
    }

    // because parent is private, we are creating getter and setters like in Java
    fun getParent(): BasicClassK? = parent

    fun setParent(parent: BasicClassK?) {
        this.parent = parent
    }
}





fun main() {
    val obj1 = BasicCLass2K("name", 49)
    val obj2 = BasicCLass2K("name", 49, BasicClassK("name2"))

    // name is immutable (val)
    val obj1Name = obj1.name

    // age is mutable (var) so a setter will be created by default
    obj1.age = 50

    // parent is private so no getters/setters will be created by default
    val obj1Parent = obj1.getParent()
    obj1.setParent(BasicClassK("name2"))
}