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
    if (n == 0.0) {
      return 0.0;
    }
    if (closeEnough(n, Math.pow(guess, 2))) {
      return guess;
    } else {
      double betterGuess = (n / guess + guess) / 2;
      return guessSqrt(n, betterGuess);
    }
  }

  public static boolean closeEnough(double a, double b){
	if(a==0.0 && b==0.0)return true;
	if(a==0.0)return b < 0.00000000001;
	if(b==0.0)return a < 0.00000000001;
	return Math.abs(a-b)/a < 0.0001;//very generous %error accepted
    }
}
