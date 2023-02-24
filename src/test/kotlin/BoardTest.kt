import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BoardTest {

    @Test
    fun `should return correct rowCnt and colCnt`() {

        val board = Board(5, 5)


        assertEquals(5, board.getRowsCnt())
        assertEquals(5, board.getColsCnt())
    }

    @Test
    fun `should set cell of board to live`() {
        val board = Board(5, 5)

        val isStateChanged = board.setCellStateLive(3, 3)

        assertEquals(true, isStateChanged)
        assertEquals(LIVE, board.getCellState(3, 3))

    }

    @Test
    fun `should set cell of board to dead`() {
        val board = Board(5, 5)

        val isStateChanged = board.setCellStateDead(3, 3)

        assertEquals(true, isStateChanged)
        assertEquals(DEAD, board.getCellState(3, 3))

    }

    @Test
    fun `should return number of live cell on side of given cell`() {
        val board = Board(5, 5)

        val liveCellCnt = board.liveNeighbourCells(3, 3)

        assertEquals(0, liveCellCnt)
    }

    @Test
    fun `should return number of live cell on side of given cell as 2`() {
        val board = Board(5, 5)
        board.setCellStateLive(3, 3)
        board.setCellStateLive(3, 4)


        val liveCellCnt = board.liveNeighbourCells(4, 4)

        assertEquals(2, liveCellCnt)
    }

    @Test
    fun `should return number of dead cells on side of given cell`() {
        val board = Board(5, 5)

        val deadCellCnt = board.deadNeighbourCells(4, 4)

        assertEquals(8, deadCellCnt)
    }

    @Test
    fun `should check if board is updated`() {
        val board = Board(5, 5)
        val board2 = Board(5, 5)

        board.setCellStateLive(1, 0)
        board.setCellStateLive(1, 1)
        board.setCellStateLive(1, 2)
        board.setCellStateLive(2, 1)


        board2.setCellStateLive(0, 1)
        board2.setCellStateLive(1, 0)
        board2.setCellStateLive(1, 1)
        board2.setCellStateLive(1, 2)

        board2.setCellStateLive(2, 0)
        board2.setCellStateLive(2, 1)
        board2.setCellStateLive(2, 2)


        board.updateGeneration()

        assertEquals(board.getGeneration(), board2.getGeneration())

    }

}