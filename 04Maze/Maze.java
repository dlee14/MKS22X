import java.util.*;
import java.io.*;

public class Maze{
  private char[][] maze;
  private boolean animate;
  private int rowSize,colSize, rDir = 0, cDir = 0, sRow, sCol;
  private boolean debug = true;
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public Maze(String filename) {
    try {
      int sCount = 0, eCount = 0;
      Scanner scanner = new Scanner(new File(filename));
      rowSize = 1;
      colSize = 0;
      char[] chars = scanner.nextLine().toCharArray();
      colSize = chars.length;
      while (scanner.hasNext()) {
        rowSize++;
        scanner.nextLine();
      }
      maze = new char[rowSize][colSize];
      scanner.reset();
      scanner = new Scanner(new File(filename));
      for (int row = 0; scanner.hasNextLine() && row < rowSize; row++) {
        //Converts a line into a character array
        chars = scanner.nextLine().toCharArray();
        for (int i = 0; i < colSize && i < chars.length; i++) {
          if (chars[i] != '#' || chars[i] != 'E' || chars[i] != 'S') {
            if (chars[i] == 'S') {
              sCount += 1;
              sRow = row;
              sCol = i;
            }
            if (chars[i] == 'E') {
              eCount += 1;
            }
            maze[row][i] = chars[i];
          }
        }
      }
      if (eCount != 1) {
        System.out.println("Invalid maze file: incorrect amount of E's");
        System.exit(1);
      }
      if (sCount != 1 ) {
        System.out.println("Invalid maze file: incorrect amount of S's");
        System.exit(1);
      }
    } catch(FileNotFoundException e) {
      System.out.println("Invalid filename or path");
      System.exit(1);
    }
  }

  public boolean solve() {
    maze[sRow][sCol] = ' ';
    return solve(sRow, sCol);
  }

  /*
  Recursive Solve function:
  A solved maze has a path marked with '@' from S to E.
  Returns true when the maze is solved,
  Returns false when the maze has no solution.
  Postcondition:
  The S is replaced with '@' but the 'E' is not.
  All visited spots that were not part of the solution are changed to '.'
  All visited spots that are part of the solution are changed to '@'
  */
  private boolean solve(int row, int col) {
    if (animate){
      System.out.println("\033[2J\033[1;1H"+this);
      wait(1);
    }
    if (maze[row][col] == 'E') {
      return true;
    }
    if (maze[row][col] == ' ') {
      maze[row][col] = '@';
      for (int i = 0; i < 4; i++) {
        findDirection(row,col);
        if (solve(row + rDir, col + cDir)) {
          return true;
        }
      }
      maze[row][col] = '.';
    }
    return false;
  }

  private boolean findDirection(int row, int col) {
    if (maze[row + 1][col] == ' ') {
      rDir = 1;
      cDir = 0;
      return true;
    } else if (maze[row - 1][col] == ' ') {
      rDir = -1;
      cDir = 0;
      return true;
    } else if (maze[row][col + 1] == ' ') {
      rDir = 0;
      cDir = 1;
      return true;
    } else if (maze[row][col - 1] == ' ') {
      rDir = 0;
      cDir = -1;
      return true;
    } else {
      return false;
    }
  }

  private boolean solved(int row, int col) {
    return maze[row - 1][col] == 'E' ||
    maze[row][col + 1] == 'E' ||
    maze[row + 1][col] == 'E' ||
    maze[row][col - 1] == 'E';
  }

  public void setAnimate(boolean b) {
    animate = b;
  }

  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public void clearTerminal() {
    //erase terminal, go to top left of screen.
    System.out.println("\033[2J\033[1;1H");
  }

  public String toString() {
    String result = "\n";
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[i].length; j++) {
        result += maze[i][j] + " ";
      }
      result += "\n";
    }
    return result;
  }

  public String showSolution() {
    String result = "\n";
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[i].length; j++) {
        if (maze[i][j] == '@') {
          result += maze[i][j] + " ";
        } else {
          result += "  ";
        }
      }
      result += "\n";
    }
    return result;
  }
}
