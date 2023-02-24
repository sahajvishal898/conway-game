import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CellTest {

    @Test
    fun `should return true if cell state as dead`() {
        val cell = Cell()

        assertEquals(true, cell.isDead())
    }

    @Test
    fun `should return false if cell state is live`() {
        val cell = Cell()

        assertEquals(false, cell.isLive())
    }


    @Test
    fun `should set the cell state to live`() {
        val cell = Cell()

        cell.makeLive()

        assertEquals(true, cell.isLive())
    }

    @Test
    fun `should set the cell state to dead`() {
        val cell = Cell()

        cell.makeDead()

        assertEquals(true, cell.isDead())
    }
}