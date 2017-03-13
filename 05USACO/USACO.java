import java.util.*;
import java.io.*;

public class USACO {
  private static int R = 0, C = 0, E = 0, N = 0, R_s = 0, C_s = 0, D_s = 0, bResult = 0;
  private static int M = 0, T = 0, R1 = 0, C1 = 0, R2 = 0, C2 = 0, sResult = 0;
  private static int[][] lake, grassInt1, grassInt2;
  private static String[][] grass;

  public static int bronze(String filename) {
    readBronzeFile(filename);
    calculate();
    return bResult;
  }

  private static void readBronzeFile(String filename){
    Scanner scanner;
    try {
      scanner = new Scanner(new File(filename));
      String line1= scanner.nextLine();
      String[] temp = line1.split(" ");
      R = Integer.parseInt(temp[0]);
      C = Integer.parseInt(temp[1]);
      E = Integer.parseInt(temp[2]);
      N = Integer.parseInt(temp[3]);
      lake = new int[R][C];
      int fillerR = R;
      while(scanner.hasNextLine() && fillerR > 0){
        String row = scanner.nextLine();
        temp = row.split(" ");
        for(int i = 0; i < temp.length; i++){
          lake[R - fillerR][i] = Integer.parseInt(temp[i]);
        }
        fillerR--;
      }
      while (scanner.hasNextLine() && scanner.hasNextInt()) {
        R_s = scanner.nextInt() - 1;
        C_s = scanner.nextInt() - 1;
        D_s = scanner.nextInt();
        stompDig(R_s, C_s, D_s);
      }
    }
    catch(FileNotFoundException e) {
      System.out.println("File not found");
    }
  }

  private static void stompDig(int row, int col, int down) {
    int highest = 0;
    for (int r = row; r < row + 3; r++) {
      for (int c = col; c < col + 3; c++) {
        if (lake[r][c] > highest) {
          highest = lake[r][c];
        }
      }
    }
    for (int r = row; r < row + 3; r++) {
      for (int c = col; c < col + 3; c++) {
        if (highest - lake[r][c] < down) {
          lake[r][c] -= down - (highest - lake[r][c]);
        }
      }
    }
  }

  private static void calculate() {
    for (int r = 0; r < lake.length; r++) {
      for (int c = 0; c < lake[0].length; c++) {
        if (E - lake[r][c] > 0) {
          bResult += E - lake[r][c];
        }
      }
    }
    bResult = bResult * 72 * 72;
  }

  public String toString() {
    String result = "\n";
    for (int i = 0; i < grass.length; i++) {
      for (int j = 0; j < grass[i].length; j++) {
        result += grass[i][j] + " ";
      }
      result += "\n";
    }
    return result;
  }

  public String toStringInt() {
    String result = "\n";
    for (int i = 0; i < grassInt2.length; i++) {
      for (int j = 0; j < grassInt2[i].length; j++) {
        result += grassInt2[i][j] + " ";
      }
      result += "\n";
    }
    return result;
  }

  public int silver(String filename) {
    readSilverFile(filename);
    sResult = grassInt2[R2][C2];
    return sResult;
  }

  private static void readSilverFile(String filename){
    Scanner scanner;
    try {
      scanner = new Scanner(new File(filename));
      String line1 = scanner.nextLine();
      String[] temp = line1.split(" ");
      N = Integer.parseInt(temp[0]);
      M = Integer.parseInt(temp[1]);
      T = Integer.parseInt(temp[2]);
      grass = new String[N][M];
      grassInt1 = new int[N][M];
      grassInt2 = new int[N][M];
      int fillerN = N;
      while(scanner.hasNextLine() && fillerN > 0) {
        String row = scanner.nextLine();
        for(int i = 0; i < row.length(); i++){
          grass[N - fillerN][i] = row.substring(i,i + 1);
          if (row.substring(i,i + 1).equals("*")) {
            grassInt1[N - fillerN][i] = -1;
            grassInt2[N - fillerN][i] = -1;
          } else {
            grassInt1[N - fillerN][i] = 0;
            grassInt2[N - fillerN][i] = -1;
          }
        }
        fillerN--;
      }
      while (scanner.hasNextLine() && scanner.hasNextInt()) {
        R1 = scanner.nextInt() - 1;
        C1 = scanner.nextInt() - 1;
        R2 = scanner.nextInt() - 1;
        C2 = scanner.nextInt() - 1;
      }
      countWays(R1, C1, R2, C2, T);
    }
    catch(FileNotFoundException e) {
      System.out.println("File not found");
    }
  }

  private static void countWays(int row1, int col1, int row2, int col2, int time) {
    grassInt1[row1][col1] = 1;
    for (int t = 0; t < time; t++) {
      for (int r = 0; r < N; r++) {
        for (int c = 0; c < M; c++) {
          if (grassInt1[r][c] == 0) {
            grassInt2[r][c] = addAround(r,c);
          } else if (grassInt1[r][c] != -1){
            grassInt2[r][c] = 0;
          }
        }
      }
      for (int i = 0; i < N; i ++){
        for (int j = 0; j < M; j ++){
          grassInt1[i][j] = grassInt2[i][j];
        }
      }
    }
  }

  private static int addAround(int row, int col) {
    int result = 0, newRow = 0, newCol = 0;
    int[] rowDir = {0, -1, 0, 1};
    int[] colDir = {-1, 0, 1, 0};
    for (int i = 0; i < 4; i++) {
      newRow = row + rowDir[i];
      newCol = col + colDir[i];
      if (newRow < N && newCol < M && newRow >= 0 && newCol >= 0) {
        if (grassInt1[newRow][newCol] != -1) {
          result += grassInt1[newRow][newCol];
        }
      }
    }
    return result;
  }
}
