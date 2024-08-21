package ch09.ExpandoObject

class Person {

    private val _attributes = mutableMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    var name: String
        get() = _attributes["name"]!!
        set(value) {
            _attributes["name"] = value
        }

    var company: String
        get() = _attributes["company"]!!
        set(value) {
            _attributes["company"] = value
        }
}


class ExpandoPerson {

    private val _attributes = mutableMapOf<String, String>()

    fun setAttribute(attributeName: String, attributeValue: String) {
        _attributes[attributeName] = attributeValue
    }

    var personName: String by _attributes
    var personCompany: String by _attributes
}


fun main() {
    val p = Person()
    val ep = ExpandoPerson()
    val data = mapOf("name" to "Seb", "company" to "JetBrains")
    val data2 = mapOf("personName" to "Seb", "personCompany" to "JetBrains")

    for ((attrName, value) in data)
        p.setAttribute(attrName, value)

    for((name, value) in data2)
        ep.setAttribute(name, value)


    println(p.name)         // Seb
    p.name = "Sebastian"
    println(p.name)         // Sebastian
    println(p.company)      // JetBrains


    println(ep.personName)
    println(ep.personCompany)
    ep.personCompany = "Microsoft"
    println(ep.personCompany)
}