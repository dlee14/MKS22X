import java.util.*;
import java.io.*;

public class Maze{
  private char[][] maze;
  private boolean animate;
  private int rowSize,colSize, rDir = -1, cDir = 0, sRow, sCol;
  private boolean debug = true;

  /*Constructor loads a maze text file, and sets animate to false by default.
  1. The file contains a rectangular ascii maze, made with the following 4 characters:
  '#' - locations that cannot be moved onto
  ' ' - locations that can be moved onto
  'E' - the location of the goal (exactly 1 per file)
  'S' - the location of the start(exactly 1 per file)

  2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
  3. When the file is not found OR there is no E or S then: print an error and exit the program.
  */
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
    maze[sRow][sCol] = '@';
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
      wait(300);
    }
    if (solved(row, col)) {
      return true;
    }
    if (findDirection(row, col)) {
      maze[row][col] = '@';
      if (solve(row + rDir, col + cDir)) {
        return true;
      } else {
        maze[row + rDir][col + cDir] = '.';
        findDirection(row, col);
      }
    }
    return false;
  }

  private boolean findDirection(int row, int col) {
    if (maze[row - 1][col] == ' ') {
      rDir = -1;
      cDir = 0;
      return true;
    } else if (maze[row][col + 1] == ' ') {
      rDir = 0;
      cDir = 1;
      return true;
    } else if (maze[row + 1][col] == ' ') {
      rDir = 1;
      cDir = 0;
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

  private void wait(int millis){ //ADDED SORRY!
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

}
