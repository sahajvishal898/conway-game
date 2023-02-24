import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BoardTest{

    @Test
    fun `should return correct rowCnt and colCnt`(){

        val board=Board(5,5)


        assertEquals(5,board.getRowsCnt())
        assertEquals(5,board.getColsCnt())
    }

    @Test
    fun `should set cell of board to live`(){
        val board=Board(5,5)

        val isStateChanged=board.setCellStateLive(3,3)

        assertEquals(true,isStateChanged)
        assertEquals(LIVE,board.getCellState(3,3))

    }


}