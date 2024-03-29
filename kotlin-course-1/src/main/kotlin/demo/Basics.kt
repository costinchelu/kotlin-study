package demo


typealias EmployeeSet = Set<Employee>

fun main(args: Array<String>) {
    println("Hello")

    // VAR vs VAL
    val numbers = 3
    var varNumbers: Int = 5
    var sum = varNumbers + numbers
    varNumbers = 6
    sum = varNumbers + numbers

    // NO "NEW" OPERATOR
    val employees: EmployeeSet = HashSet()

    val names = arrayListOf("John", "Jane", "Mary")
    val e1 = Employee(names[0], 1)
    val e2 = Employee(names[2], 2)
    val e3 = Employee(names[2], 2)
    val e4 = e2

    // EQUALITY IS DIFFERENT
    println(e1 == e2)   // false
    println(e2 == e3)   // true
    println(e2 == e4)   // true

    println(e1.equals(e2))  // false        equals() is same as == in Kotlin
    println(e2.equals(e3))  // true
    println(e2.equals(e4))  // true

    println(e1 === e2)  // false
    println(e2 === e3)  // false
    println(e2 === e4)  // true

    println(e4 != e2)   // false
    println(e4 !== e2)  // false
    println(e2 != e3)   // false
    println(e2 !== e3)  // true

    // IMMUTABLE OBJECT != IMMUTABLE INSTANCE VARIABLE
    e1.name = "Sarah"
    println(e1.name)

    // is (in place of "instanceOf")
    // Any is kind of like Object in Java (but not exactly)
    // casting is done with as (and we have smart casting = after we check the object with "is"
    // then casting is automatically done )
    val something: Any = e4
    if (something is Employee) {
//        val e5 = something as Employee
        println(something.name)
    }

    // string templates using $ and string expressions delimited by curly braces:
    val n1 = 34
    val n2 = 12.54
    println("n1 = $n1")
    println("n1 / n2 = ${n1 / n2}")
    println("e4's name is ${e4.name}")

    // raw strings (no need to escape). We can't include \n \t
    val someFilePath = """C:\someDir\someDir2"""
}


class Employee (var name: String, val id: Int) {

    override fun equals(other: Any?): Boolean {
        if (other is Employee) {
            return name == other.name && id == other.id
        }
        return false
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + id
        return result
    }

    override fun toString(): String {
        return "Employee (name=$name, id=$id)"
    }
}