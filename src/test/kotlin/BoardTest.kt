import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BoardTest{

    @Test
    fun `should return correct rowCnt and colCnt`(){

        val board=Board(5,5)


        assertEquals(5,board.getRowsCnt())
        assertEquals(5,board.getColsCnt())
    }

}