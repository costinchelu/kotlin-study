package text.adventure

import java.util.HashMap


open class KLocation(val locationID: Int, val description: String) {

    private val exits: MutableMap<String, Int>

    init {
        this.exits = HashMap()
        this.exits.put("Q", 0)
    }

    fun getExits(): Map<String, Int> {
        return HashMap(exits)
    }

    protected fun addExit(direction: String, location: Int) {
        exits[direction] = location
    }
}