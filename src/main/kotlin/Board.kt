class Board(rowCnt: Int, colCnt: Int) {

    private val grid = ArrayList<ArrayList<Cell>>()

    init {
        for (rowNo in 1..rowCnt) {
            val currRow = ArrayList<Cell>()
            for (colNo in 1..colCnt) {
                currRow.add(Cell())
            }
            grid.add(currRow)
        }
    }


    fun getRowsCnt(): Int {
        return grid.size
    }

    fun getColsCnt(): Int {
        return grid[0].size
    }

    private fun getCell(rowNo: Int, colNo: Int): Cell {
        return grid[rowNo][colNo]
    }

    private fun isRowAndColInvalid(rowNo: Int, colNo: Int): Boolean {
        if (rowNo >= getRowsCnt() || colNo >= getColsCnt())
            return true
        return false
    }

    fun setCellStateLive(rowNo: Int, colNo: Int): Boolean? {

        if (isRowAndColInvalid(rowNo, colNo))
            return null

        val cell = getCell(rowNo, colNo)
        cell.makeLive()
        return true
    }

    fun getCellState(rowNo: Int, colNo: Int): Boolean? {

        if (isRowAndColInvalid(rowNo, colNo))
            return null

        return getCell(rowNo, colNo).isLive()

    }

    fun setCellStateDead(rowNo: Int, colNo: Int): Boolean? {

        if (isRowAndColInvalid(rowNo, colNo))
            return null

        val cell = getCell(rowNo, colNo)
        cell.makeDead()
        return true
    }


}