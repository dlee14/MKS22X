import java.util.*;

public class StackCalc {
  public static double eval(String input) {
    String[] token = input.split(" ");
    Stack<Double> stack = new Stack<Double>();
    for (int i = 0; i < token.length; i++) {
      if (isOp(token[i])) {
        stack.push(apply(token[i], stack.pop(), stack.pop()));
      } else {
        stack.push(Double.parseDouble(token[i]));
      }
    }
    return stack.pop();
  }

  private static boolean isOp(String input) {
    return (input.equals("+") || input.equals("-") || input.equals("/") || input.equals("*"));
  }

  private static double apply(String operation, double a, double b) {
    if (operation.equals("+")) {
      return b + a;
    } else if (operation.equals("-")) {
      return b - a;
    } else if (operation.equals("*")) {
      return b * a;
    } else {
      return b / a;
    }
  }

  public static void main(String[] args) {
    System.out.println(StackCalc.eval("0"));
  }
}
