import java.util.*;

public class Quick{

  public static void quicksort(int[] data) {
    quickH(data, 0, data.length - 1);
  }

  private static void quickH(int[] data, int start, int end) {
    if (start < end) {
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
      quickH(data, start, less - 1);
      quickH(data, i, end);
    }
  }

  public static int part(int[] data, int start, int end) {
    int index = (int)(Math.random() * (end - start + 1) + start);
    int pivot = data[index];
    swap(data, start, index);
    int left = start + 1, right = end;
    while(left <= right) {
      if (data[left] <= pivot) {
        left++;
      }
      else if (data[left] > pivot) {
        swap(data, left, right);
        right--;
      }
    }
    swap(data, start, right);
    return right;
  }

  private static int quickSelect(int[] data, int k) {
    quicksort(data);
    return data[k];
  }

  private static void swap(int[] data, int swap1, int swap2) {
    int save = 0;
    save = data[swap2];
    data[swap2] = data[swap1];
    data[swap1] = save;
  }

  public static void main(String[] args) {
    int size = 100, max = size, min = -1 * size;
    boolean sorted = true, reverse = false, random = false, same = false;
    int number = 0, timeSame, timeSorted, timeReverse, timeRandom;
    int[] test;
    test = new int[size];
    //   for (int j = 0; j < size; j++) {
    //     // Random
    //     Random rand = new Random();
    //     number = rand.nextInt(max + 1 - min) + min;
    //     random[j] = number;
    //     // Sorted
    //     number = j;
    //     sorted[j] = number;
    //     // Same
    //     number = 10;
    //     same[j] = number;
    //     // Reverse
    //     number = size - j;
    //     reverse[j] = number;
    //   }
    // }

    for (int j = 0; j < size; j++) {
      if (random) {
        Random rand = new Random();
        number = rand.nextInt(max + 1 - min) + min;
        test[j] = number;
      } else if (sorted) {
        number = j;
        test[j] = number;
      } else if (same) {
        number = 10;
        test[j] = number;
      } else {
        number = size - j;
        test[j] = number;
      }
    }

    // Quick.quickSort(same);
    // Quick.quickSort(sorted);
    // Quick.quickSort(reverse);
    // System.out.println(Arrays.toString(test));
    Quick.quickSelect(test, 5);

    System.out.println(Arrays.toString(test));
  }

  // public static int part(int[] data, int start, int end) {
  //   int index = (int)(Math.random() * (end - start + 1) + start);
  //   int pivot = data[index];
  //   int less = start, greater = end, i = start + 1;
  //   swap(data, start, index);
  //   while (i <= greater) {
  //     if (data[i] < data[less]) {
  //       swap(data, i, less);
  //       i++;
  //       less++;
  //     } else if (data[i] == data[less]) {
  //       i++;
  //     } else {
  //       swap(data, i, greater);
  //       greater--;
  //     }
  //   }
  //   return less;
  // }


  // public static boolean test() {
  //   boolean result = true;
  //   int size = 1000, number = 0, index = 0, max = 10000, min = -10000, i;
  //   int[] test, sorted;
  //   for (i = 0; i < 100; i++) {
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
  //     if (sorted[index] != test[index]) {
  //       result = false;
  //     }
  //     for (i = 0; i < index; i++) {
  //       if (test[i] > test[index]) {
  //         result = false;
  //       }
  //     }
  //     for (i = index; i < test.length; i++) {
  //       if (test[i] < test[index]) {
  //         result = false;
  //       }
  //     }
  //   }
  //   return result;
  // }




}
