data class Cell(var state: Boolean = DEAD) {

    fun isDead(): Boolean {
        return state == DEAD
    }

    fun isLive(): Boolean {
        return state == LIVE
    }

    fun makeLive() {
        state = LIVE
    }

    fun makeDead() {
        state = DEAD
    }
}