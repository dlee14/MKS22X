import java.util.*;
import java.util.NoSuchElementException;
import java.io.*;

public class MyHeap {
  private int[] array;
  private int constant, cap, size;

  public MyHeap() {
    cap = 1;
    size = 0;
    array = new int[cap];
    array[0] = -1;
    constant = 1;
  }

  public MyHeap(boolean max) {
    cap = 1;
    size = 0;
    array = new int[cap];
    array[0] = -1;
    if (max) {
      constant = 1;
    } else {
      constant = -1;
    }
  }

  private void resize() {
    int[] newArr = new int[array.length * 2];
    cap = array.length * 2;
    for (int i = 0; i < array.length; i++) {
      newArr[i] = array[i];
    }
    array = newArr;
  }

  public void add(int value) {
    if (size + 1 == cap) {
      resize();
    }
    size++;
    array[size] = value;
    pushUp();
  }

  public int remove() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    int root = array[1];
    array[1] = array[size];
    array[size] = -1;
    size--;
    pushDown();
    return root;
  }

  private void pushDown() {
    int index = 1;
    while (getChild(index) > 0) {
      int child = getChild(index);
      if ((constant * (array[index] - array[index * 2])) < 0) {
        int temp = array[child];
        array[child] = array[index];
        array[index] = temp;
        index = child;
      } else if ((constant * (array[index] - array[index * 2 + 1])) < 0) {
        int temp = array[child];
        array[child] = array[index];
        array[index] = temp;
        index = child;
      }
    }
  }

  public int peek() {
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
      if ((constant * (array[parent] - array[index])) < 0) {
        int temp = array[parent];
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
    boolean left = index * 2 < size && (constant * (array[index] - array[index * 2])) < 0;
    boolean right = index * 2 + 1 < size && (constant * (array[index] - array[index * 2 + 1])) < 0;
    if (left && right) {
      if ((constant * (array[index * 2] - array[index * 2 + 1])) > 0) {
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

  public int[] heapSort(){
    int[] sorted = new int[size];
    for (int i = size - 1; i >= 0; i--) {
      sorted[i] = this.remove();
    }
    return sorted;
  }
}
