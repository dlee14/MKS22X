import java.util.*;

public class Quick{
  // public static int part(int[] data, int start, int end) {
  //   int index = (int)(Math.random() * (end - start + 1) + start);
  //   int pivot = data[index];
  //   swap(data, start, index);
  //   int left = start + 1, right = end;
  //   while(left <= right) {
  //     if (data[left] <= pivot) {
  //       left++;
  //     }
  //     else if (data[left] > pivot) {
  //       swap(data, left, right);
  //       right--;
  //     }
  //   }
  //   swap(data, start, right);
  //   return right;
  // }

  public static int part(int[] data, int start, int end) {
    int index = (int)(Math.random() * (end - start + 1) + start);
    int pivot = data[index];
    int less = start, greater = end, i = start + 1;
    swap(data, start, index);
    while (i <= greater) {
      if (data[i] < data[less]) {
        swap(data, i, less);
        i++;
        less++;
      } else if (data[i] == data[less]) {
        i++;
      } else {
        swap(data, i, greater);
        greater--;
      }
    }
    System.out.println(Arrays.toString(data));
    // System.out.println("less: " + less);
    // System.out.println("i: " + i);
    // System.out.println("greater: " + greater);
    return less;
  }

  public static void quickSort(int[] data) {
    quickH(data, 0, data.length - 1);
  }

  private static void quickH(int[] data, int start, int end) {
    if (data.length != 1) {
      quickH(data, start, part(data, start, end) - 1);
    }
  }

  private static void swap(int[] data, int swap1, int swap2) {
    int save = 0;
    save = data[swap2];
    data[swap2] = data[swap1];
    data[swap1] = save;
  }

  // public static boolean test() {
  //   boolean result = true;
  //   int size = 10, number = 0, index = 0, max = 100, min = -100;
  //   int[] test, sorted;
  //   for (int i = 0; i < 100; i++) {
  //     test = new int[size];
  //     sorted = new int[size];
  //     for (int j = 0; j < size; j++) {
  //       Random rand = new Random();
  //       number = rand.nextInt(max + 1 - min) + min;
  //       test[j] = number;
  //       sorted[j] = number;
  //     }
  //     index = part(test, 0, size - 1);
  //     Arrays.sort(sorted);
  //     if (index == 0) {
  //       System.out.println(Arrays.toString(test));
  //       System.out.println(Arrays.toString(sorted));
  //     }
  //     if (sorted[index] != test[index]) {
  //       result = false;
  //     }
  //   }
  //   return result;
  // }

  public static void main(String[] args) {
    int[] data = {5,8,3,6,4,7,0,9,1,2};
    Quick.quickSort(data);
    // System.out.println(Quick.part(data,0,9));
  }
}
