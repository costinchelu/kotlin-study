package ro.ccar.kt


open class Base2K
    private constructor(
        val attr1: String?,
        val attr2: Int?,
        val attr3: String?
    ) {
        constructor(attr1: String): this(attr1, 1, "First Constructor")
        constructor(attr1: String, attr2: Int): this(attr1, attr2, "Second Constructor")
    }

class Derived2K1(attr1: String): Base2K(attr1)

class Derived2K2(attr1: String, attr2: Int): Base2K(attr1, attr2)