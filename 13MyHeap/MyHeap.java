import java.util.*;
import java.util.NoSuchElementException;
import java.io.*;

public class MyHeap {
  private String[] array;
  private int constant, cap, size;

  public MyHeap() {
    cap = 1;
    size = 0;
    array = new String[cap];
    array[0] = null;
    constant = 1;
  }

  public MyHeap(boolean max) {
    cap = 1;
    size = 0;
    array = new String[cap];
    array[0] = null;
    if (max) {
      constant = 1;
    } else {
      constant = -1;
    }
  }

  private void resize() {
    String[] newArr = new String[array.length * 2];
    cap = array.length * 2;
    for (int i = 0; i < array.length; i++) {
      newArr[i] = array[i];
    }
    array = newArr;
  }

  public void add(String s) {
    if (size + 1 == cap) {
      resize();
    }
    size++;
    array[size] = s;
    pushUp();
  }

  public String remove() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    String root = array[1];
    array[1] = array[size];
    array[size] = null;
    size--;
    pushDown();
    return root;
  }

  private void pushDown() {
    int index = 1;
    while (getChild(index) > 0) {
      int child = getChild(index);
      if ((constant * array[index].compareTo(array[index * 2])) < 0) {
        String temp = array[child];
        array[child] = array[index];
        array[index] = temp;
        index = child;
      } else if ((constant * array[index].compareTo(array[index * 2 + 1])) < 0) {
        String temp = array[child];
        array[child] = array[index];
        array[index] = temp;
        index = child;
      }
    }
  }

  public String peek() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return array[1];
  }

  private void pushUp() {
    int parent = getParent(size);
    int index = size;
    boolean stop = false;
    while (getParent(index) > 0 && stop != true) {
      parent = getParent(index);
      if ((constant * (array[parent].compareTo(array[index]))) < 0) {
        String temp = array[parent];
        array[parent] = array[index];
        array[index] = temp;
        index = parent;
      } else {
        stop = true;
      }
    }
  }

  private int getParent(int index) {
    if (index == 1) {
      return -1;
    }
    if (index % 2 == 0) {
      return index / 2;
    } else {
      return (index - 1) / 2;
    }
  }

  public int getChild(int index) {
    boolean left = index * 2 < size && (constant * array[index].compareTo(array[index * 2])) < 0;
    boolean right = index * 2 + 1 < size && (constant * array[index].compareTo(array[index * 2 + 1])) < 0;
    if (left && right) {
      if ((constant * array[index * 2].compareTo(array[index * 2 + 1])) > 0) {
        return index * 2;
      } else {
        return index * 2 + 1;
      }
    } else if (left) {
      return index * 2;
    } else if (right) {
      return index * 2 + 1;
    }
    return -1;
  }

  public int getSize() {
    return size;
  }

  public String toString() {
    String result = "[ ";
    for (int i = 0; i < size + 1; i++) {
      result += array[i] + " ";
    }
    result += "]";
    return result;
  }

  public String[] heapSort(){
    String[] sorted = new String[size];
    for (int i = size - 1; i >= 0; i--) {
      sorted[i] = this.remove();
    }
    return sorted;
  }

  public static void main(String[] args) {
    int size = 100, max = size, min = size * -1;
    String[] test = new String[size];
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    for (int i = 0; i < size; i++) {
      Random rand = new Random();
      test[i] = "" + alphabet.charAt(rand.nextInt(alphabet.length()));
    }

    MyHeap heap = new MyHeap(true);
    for (int i = 0; i < size; i++) {
      heap.add(test[i]);
    }

    System.out.println(heap + "\n");

    System.out.println(Arrays.toString(heap.heapSort()));
  }
}
