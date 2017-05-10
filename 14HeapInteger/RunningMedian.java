import java.util.*;

public class RunningMedian {
  private MyHeap max, min;

  public RunningMedian() {
    max = new MyHeap(true);
    min = new MyHeap(false);
  }

  public void add(int number) {
    if (max.getSize() + min.getSize() == 0) {
      max.add(number);
    } else if ((double) number > getMedian()) {
      min.add(number);
    } else {
      max.add(number);
    }
    if (max.getSize() - min.getSize() > 1) {
      min.add(max.remove());
    }
    if (min.getSize() - max.getSize() > 1) {
      max.add(min.remove());
    }
  }

  public double getMedian() {
    if (min.getSize() == max.getSize()) {
      return (min.peek() + max.peek()) / 2;
    } else if (min.getSize() > max.getSize()) {
      return min.peek() + 0.0;
    } else {
      return max.peek() + 0.0;
    }
  }

  public String toString() {
    return "max: " + max + "\nmin: " + min;
  }

  // public static void main(String[] args) {
  //   RunningMedian median = new RunningMedian();
  //   int size = 1000, max = 100, min = size * -1;
  //   int[] test = new int[size];
  //   for (int i = 0; i < size; i++) {
  //     Random rand = new Random();
  //     int random = rand.nextInt(max);
  //     median.add(random);
  //     test[i] = random;
  //   }
  //   System.out.println(median);
  //   System.out.println(median.getMedian());
  //
  //   Arrays.sort(test);
  //   // System.out.println(Arrays.toString(test));
  //   System.out.println( (test[test.length / 2] + test[test.length / 2 - 1]) / 2 );
  }
}
