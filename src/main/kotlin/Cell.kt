class Cell {
    private var state = DEAD

    fun isDead(): Boolean {
        return state == DEAD
    }

    fun isLive(): Boolean {
        return state==LIVE
    }

    fun makeLive() {
        state=LIVE
    }
}