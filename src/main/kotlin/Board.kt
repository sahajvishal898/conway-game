class Board(rowCnt: Int, colCnt: Int) {

    private var grid = ArrayList<ArrayList<Cell>>()

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
        if (rowNo >= getRowsCnt() || colNo >= getColsCnt() || rowNo < 0 || colNo < 0) return true
        return false
    }

    fun setCellStateLive(rowNo: Int, colNo: Int): Boolean? {

        if (isRowAndColInvalid(rowNo, colNo)) return null

        val cell = getCell(rowNo, colNo)
        cell.makeLive()
        return true
    }

    fun getCellState(rowNo: Int, colNo: Int): Boolean? {

        if (isRowAndColInvalid(rowNo, colNo)) return null

        return getCell(rowNo, colNo).isLive()

    }

    fun setCellStateDead(rowNo: Int, colNo: Int): Boolean? {

        if (isRowAndColInvalid(rowNo, colNo)) return null

        val cell = getCell(rowNo, colNo)
        cell.makeDead()
        return true
    }

    fun liveNeighbourCells(rowNo: Int, colNo: Int): Int? {

        if (isRowAndColInvalid(rowNo, colNo)) return null


        val rowChange = arrayListOf(-1, -1, -1, 0, 0, 1, 1, 1)
        val colChange = arrayListOf(-1, 0, 1, -1, 1, -1, 1, 1)

        var liveCellsCnt = 0
        for (index in 1..8) {

            val currRow = rowNo + rowChange[index - 1]
            val currCol = colNo + colChange[index - 1]

            if (isRowAndColInvalid(currRow, currCol)) {
                continue
            }

            if (getCellState(currRow, currCol) == LIVE) {
                liveCellsCnt++
            }
        }
        return liveCellsCnt
    }

    fun deadNeighbourCells(rowNo: Int, colNo: Int): Int? {
        if (isRowAndColInvalid(rowNo, colNo)) return null

        return TOTAL_NEIGHBOUR_CELLS - liveNeighbourCells(rowNo, colNo)!!
    }

    fun updateGeneration() {

        val newGrid = ArrayList<ArrayList<Cell>>()


        for (rowNo in 1..getRowsCnt()) {

            val currRow = ArrayList<Cell>()

            for (colNo in 1..getColsCnt()) {

                val cell = Cell()
                val liveNeighbourCnt = liveNeighbourCells(rowNo - 1, colNo - 1)


                if (getCell(rowNo - 1, colNo - 1).isLive()) {

                    if (liveNeighbourCnt == 2 || liveNeighbourCnt == 3) {
                        cell.makeLive()
                    }
                } else {
                    if (liveNeighbourCnt == 3) {
                        cell.makeLive()
                    }
                }
                currRow.add(cell)
            }
            newGrid.add(currRow)
        }
        grid = newGrid
    }

    fun getGeneration(): ArrayList<ArrayList<Cell>> {
        return grid
    }


}