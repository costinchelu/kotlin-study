package ch04.ex1_AccessModifiers

// internal = restrict visibility to be inside a module (in Java we can create same module structure to access
// package private classes. In Kotlin internal will restrict access outside the module (which can be the project)
internal open class TalkativeButton {

    private fun yell() = println("Hey!")

    protected fun whisper() = println("Let's talk")
}

// fun TalkativeButton.giveSpeech() { }
//      not working because of internal access modifier that is only visible inside its module.
//      To solve this we may make this function internal
internal fun TalkativeButton.giveSpeech() {}
// we will still be unable to access the protected member (whisper) because here in Kotlin it is only accessible by the
// subclasses. In Java, it was accessible by subclasses and all other classes in the module.

// Kotlin uses packages only as a way of organizing code in namespaces; it does not use them for visibility control.

// In Java, you can't make a class private so when a private class is accessed in Java, it will be package private
// internal will become public in bytecode