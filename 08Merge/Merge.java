import java.util.*;

public class Merge {

  public static void mergeSort(int[] data) {
    int[] data1 = new int[data.length / 2];
    int[] data2 = new int[data.length - data1.length];
    if (data.length > 1) {
      for (int i = 0; i < data.length; i++) {
        if (i < data1.length) {
          data1[i] = data[i];
        } else {
          data2[i - data1.length] = data[i];
        }
      }
      mergeSort(data1);
      mergeSort(data2);
      merge(data1, data2, data);
    }
  }

  public static void merge(int[] list1, int[] list2, int[] destination) {
    int i = 0, j = 0;
    while (i < list1.length && j < list2.length) {
      if (list1[i] <= list2[j]) {
        destination[i+j] = list1[i];
        i++;
      } else {
        destination[i+j] = list2[j];
        j++;
      }
    }
    for (int a = i; a < list1.length; a++) {
      destination[a + j] = list1[a];
    }
    for (int a = j; a < list2.length; a++) {
      destination[a + i] = list2[a];
    }
  }

  /*public static void main(String[] args) {
    int[] data1 = {1,3,5,7,9,10,15,16,19,25,28,34,37};
    int[] data2 = {2,4,6,8,10,17,19,21,25,28};
    int size = 100, max = size, min = -1 * size, number = 0;
    int[] test = new int[size];

    for (int j = 0; j < size; j++) {
      Random rand = new Random();
      number = rand.nextInt(max + 1 - min) + min;
      test[j] = number;
    }

    mergeSort(test);
    System.out.println(Arrays.toString(test));
  }*/
}
