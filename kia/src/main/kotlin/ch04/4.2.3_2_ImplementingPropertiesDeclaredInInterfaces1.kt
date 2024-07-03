package ch04.ex2_3_2_ImplementingPropertiesDeclaredInInterfaces1

// interfaces can also contain properties with getters or setters as long as it is not referring a backing field
// interfaces cannot store a state
interface EmailUser {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}
