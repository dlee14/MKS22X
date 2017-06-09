import java.util.*;

public class Driver {
  public static void main(String[] args) {
    MazeSolver s = new MazeSolver("data1.txt");
    s.solve(1);
    String ans = s.toString();
  }
}
