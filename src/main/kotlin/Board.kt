class Board(val rowCnt : Int,val colCnt: Int) {

    val grid=ArrayList<ArrayList<Cell>>()

    init{
        for(rowNo in 1..rowCnt){
            val currRow=ArrayList<Cell>()
            for(colNo in 1..colCnt){
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








}