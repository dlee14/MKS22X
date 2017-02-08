public class Recursion {

  public static String name() {
    return "Lee,DongJun";
  }

  public static double sqrt(double n) {
    if (n < 0) {
      throw new IllegalArgumentException("Wrong value");
    }
    return guessSqrt(n, 1);
  }

  public static double guessSqrt(double n, double guess) {
    if (closeEnough(n, Math.pow(guess, 2))) {
      return guess;
    } else {
      double betterGuess = (n / guess + guess) / 2;
      return guessSqrt(n, betterGuess);
    }
  }

  private static boolean closeEnough(double n1, double n2) {
    return (Math.abs(n1 - n2) / Math.max(Math.abs(n1), Math.abs(n2)) <= Math.pow(10, -8));
  }

  public static void main(String[] args) {
    System.out.println(sqrt(152));
    System.out.println(sqrt(144));
    System.out.println(sqrt(1571248));
  }
}
