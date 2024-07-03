package ch04.ex1_4_2_InnerAndNestedClasses1

import java.io.Serializable



class Outer {

    inner class Inner {

        fun getOuterReference(): Outer = this@Outer
    }
}



interface State: Serializable


interface View {

    fun getCurrentState(): State

    fun restoreState(state: State) {}
}


class Button : View {

    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) { /*...*/ }

    // Button is not serializable, and it breaks the serialization of ButtonState
    // to fix the problem we need to declare ButtonState as static
    class ButtonState : State { /*...*/ }
}