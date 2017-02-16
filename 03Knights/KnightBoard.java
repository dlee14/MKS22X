public class KnightBoard {
  private int[][] board;

  public KnightBoard(int startingRows, int startingCols) {
    board = new int[startingRows][startingCols];
  }

  public void solve() {

  }

  private boolean solveH(int row, int col, int level) {
    if (level == board.length * board[0].length) {
      return true;
    }

  }

  public String toString() {
    String result = "\n";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        result += giveSpace(board.length * board[i].length, board[i][j]) + board[i][j];
      }
      result += "\n";
    }
    return result;
  }

  public String giveSpace(int area, int n) {
    String result = " ";
    if (area >= 10 && area < 100) {
      if (n < 10) {
        result += " ";
      }
    }
    if (area >= 100 && area < 1000) {
      if (n < 10) {
        result += "  ";
      }
      if (n < 100) {
        result += " ";
      }
    }
    return result;
  }

  private void int[][] getSpace(int row, int col) {
    if (board[row - 2][col - 1] == 0) {
      return board[row - 2][col - 1];
    }
    if (board[row - 2][col + 1]; == 0) {
      return board[row - 2][col + 1];
    }
    if (board[row - 1][col + 2] == 0) {
      return board[row - 1][col + 2];
    }
    if (board[row + 1][col + 2] == 0) {
      return board[row + 1][col + 2];
    }
    if (board[row + 2][col - 1] == 0) {
      return board[row + 2][col - 1];
    }
    if (board[row + 2][col + 1] == 0) {
      return board[row + 2][col + 1];
    }
    if (board[row - 1][col - 2] == 0) {
      return board[row - 1][col - 2];
    }
    if (board[row] + 1[col - 2] == 0) {
      return board[row] + 1[col - 2];
    }
  }

  public static void main(String[]args) {
    KnightBoard board = new KnightBoard(10, 10);
    System.out.println(board);
  }
}
