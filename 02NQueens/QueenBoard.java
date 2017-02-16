public class QueenBoard {
  private int[][] board;
  private int solutionCount = -1;

  public QueenBoard(int size) {
    board = new int[size][size];
  }

  public void solve() {
    solveH(0);
    System.out.println(toString());
  }

  private boolean solveH(int col) {
    if (col >= board.length) {
      return true;
    }
    for (int i = 0; i < board.length; i++) {
      if (board[i][col] == 0) {
        board[i][col] = -1;
        markAll(i, col);
        if (solveH(col + 1)) {
          return true;
        } else {
          removeQ(i, col);
        }
      }
    }
    return false;
  }

  public void countSolutions() {
    solutionCount = 0;
    countSolutionsH(0);
  }

  private void countSolutionsH(int col) {
    if (col >= board.length) {
      solutionCount++;
    } else {
      for (int i = 0; i < board.length; i++) {
        if (board[i][col] == 0) {
          board[i][col] = -1;
          markAll(i, col);
          countSolutionsH(col + 1);
          removeQ(i, col);
        }
      }
    }
  }

  private void removeQ(int row, int col) {
    board[row][col] = 0;
    int i, j;
    for (i = col - 1; i >= 0; i--) {
      board[row][i] -= 1;
    }
    for (i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      board[i][j] -= 1;
    }
    for (i = row - 1; i >= 0; i--) {
      board[i][col] -= 1;
    }
    for (i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
      board[i][j] -= 1;
    }
    for (i = col + 1; i < board.length; i++) {
      board[row][i] -= 1;
    }
    for (i = row + 1, j = col + 1; i < board.length && j < board.length; i++, j++) {
      board[i][j] -= 1;
    }
    for (i = row + 1; i < board.length; i++) {
      board[i][col] -= 1;
    }
    for (i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {
      board[i][j] -= 1;
    }
  }

  private void markAll(int row, int col) {
    int i,j;
    for (i = col - 1; i >= 0; i--) {
      board[row][i] += 1;
    }
    for (i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      board[i][j] += 1;
    }
    for (i = row - 1; i >= 0; i--) {
      board[i][col] += 1;
    }
    for (i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
      board[i][j] += 1;
    }
    for (i = col + 1; i < board.length; i++) {
      board[row][i] += 1;
    }
    for (i = row + 1, j = col + 1; i < board.length && j < board.length; i++, j++) {
      board[i][j] += 1;
    }
    for (i = row + 1; i < board.length; i++) {
      board[i][col] += 1;
    }
    for (i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {
      board[i][j] += 1;
    }
  }

  public int getSolutionCount() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = 0;
      }
    }
    return solutionCount;
  }

  public String toString() {
    String result = "\n";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == -1) {
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
    queenboard.countSolutions();
    queenboard.solve();
    System.out.println(queenboard.getSolutionCount());
  }
}
