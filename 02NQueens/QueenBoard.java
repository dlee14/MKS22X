public class QueenBoard {
  private int[][] board;
  private int solutionCount;

  public QueenBoard(int size) {
    board = new int[size][size];
  }

  /**
  *precondition: board is filled with 0's only.
  *@return false when the board is not solveable. true otherwise.
  *postcondition:
  *if false: board is still filled with 0's
  *if true: board is filled with the
  *final configuration of the board after adding
  *all n queens. Uses solveH
  */
  public void solve() {
  }

  private boolean solveH(int col){
    return false;
  }

  /**
  *@return the number of solutions found, or -1 if the board was never solved.
  *The board should be reset after this is run.
  */
  public void getSolutionCount(){
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = 0;
      }
    }
  }

  public String toString(){
    String result = "\n";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 0) {
          result += "Q ";
        } else {
          result += "_ ";
        }
      }
      result += "\n";
    }
    return result;
  }

  public static void main(String[] args) {
    QueenBoard queenboard = new QueenBoard(10);
    System.out.println(queenboard.toString());
  }
}
