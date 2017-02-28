public class KnightBoard {
  private int[][] board;
  private int[] colDir = {-1, 1, 2, 2, 1, -1, -2, -2};
  private int[] rowDir = {-2, -2, -1, 1, 2, 2, 1, -1};

  public KnightBoard (int startingRows, int startingCols) {
    board = new int[startingRows][startingCols];
  }

  public void solve() {
    solveH(0,0,1);
  }

  private boolean solveH (int row, int col, int level) {
    if (level > board.length * board[0].length) {
      return true;
    }
    if (board[row][col] == 0) {
      board[row][col] = level;
      for (int i = 0, j = 0; i < rowDir.length && j < colDir.length; i++, j++) {
        int rowOffset = rowDir[i];
        int colOffset = colDir[j];
        if ((row + rowOffset < board.length && row + rowOffset >= 0 )
        && (col + colOffset < board[0].length && col + colOffset >= 0)) {
          if (solveH(row + rowOffset, col + colOffset, level + 1)) {
            return true;
          }
        }

      }
      board[row][col] = 0;
    }
    return false;
  }

  public String toString() {
    String result = "";
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        if (board[r][c] < 10) {
          result += " " + board[r][c];
        }
        else {
          result += board[r][c];
        }
        result += " ";
      }
      result += "\n";
    }
    return result;
  }

  public static void main (String[] args) {
    KnightBoard b = new KnightBoard(4,3);
    b.solve();
    System.out.println(b);
  }
}
