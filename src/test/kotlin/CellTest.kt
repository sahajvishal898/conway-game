import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CellTest {

    @Test
    fun `should return true if cell state as dead`() {
        val cell = Cell()

        assertEquals(true, cell.isDead())
    }




}