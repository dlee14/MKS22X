import java.util.*;

public class Merge {
  public static int[] merge(int[] list1, int[] list2) {
    int[] result = new int[list1.length + list2.length];
    int i = 0, j = 0;
    while (i < (list1.length) || j < (list2.length)) {
      if (i < list1.length && j < list2.length) {
        if (list1[i] <= list2[j]) {
          result[i+j] = list1[i];
          i++;
        }
        if (list1[i] > list2[j]) {
          result[i+j] = list2[j];
          j++;
        }
      }
      System.out.println("i: " + i);
      System.out.println("j: " + j);
      System.out.println(Arrays.toString(result));
    }
    return result;
  }

  public static void main(String[] args) {
    int[] data1 = {1,3,5,7,9};
    int[] data2 = {0,2,4,6,8};
    //{0,1,}
    System.out.println(Arrays.toString(Merge.merge(data1,data2)));
  }
}
