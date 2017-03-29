import java.util.*;

public class Merge {

  public static void mergeSort(int[] data) {
    int[] data1 = new int[data.length];
    int[] data2 = new int[data.length - data1.length];
    for (int i = 0; i < data.length; i++) {
      if (i < data.length) {
        data1[i] = data[i];
      } else {
        data2[i - data1.length] = data[i];
      }
    }
    if (data.length > 1) {
      mergeSort(data1);
      mergeSort(data2);
      merge(data1, data2);
    }
  }

  public static int[] merge(int[] list1, int[] list2) {
    int[] result = new int[list1.length + list2.length];
    int i = 0, j = 0;
    while (i < list1.length && j < list2.length) {
      if (list1[i] <= list2[j]) {
        result[i+j] = list1[i];
        i++;
      } else {
        result[i+j] = list2[j];
        j++;
      }
    }
    for (int a = i; a < list1.length; a++) {
      result[a + j] = list1[a];
    }
    for (int a = j; a < list2.length; a++) {
      result[a + i] = list2[a];
    }
    return result;
  }

  public static void main(String[] args) {
    int[] data1 = {1,3,5,7,9,10,15,16,19,25,28,34,37};
    int[] data2 = {2,4,6,8,10,17,19,21,25,28};
    mergeSort(data1);
    System.out.println(Arrays.toString(data1));
  }
}
