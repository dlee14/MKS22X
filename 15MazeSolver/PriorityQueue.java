import java.util.*;
import java.util.NoSuchElementException;
import java.io.*;

public class PriorityQueue {
  private Location[] array;
  private int cap, size;

  public PriorityQueue() {
    cap = 1;
    size = 0;
    array = new Location[cap];
    array[0] = null;
  }

  private void resize() {
    Location[] newArr = new Location[array.length * 2];
    cap = array.length * 2;
    for (int i = 0; i < array.length; i++) {
      newArr[i] = array[i];
    }
    array = newArr;
  }

  public void add(Location newLocation) {
    if (size + 1 == cap) {
      resize();
    }
    size++;
    array[size] = newLocation;
    pushUp();
  }

  public Location remove() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    Location root = array[1];
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
      if (array[index].compareTo(array[index * 2]) < 0) {
        Location temp = array[child];
        array[child] = array[index];
        array[index] = temp;
        index = child;
      } else if (array[index].compareTo(array[index * 2 + 1]) < 0) {
        Location temp = array[child];
        array[child] = array[index];
        array[index] = temp;
        index = child;
      }
    }
  }

  public Location peek() {
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
      if ((array[parent].compareTo(array[index])) < 0) {
        Location temp = array[parent];
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
    boolean left = index * 2 < size && array[index].compareTo(array[index * 2]) < 0;
    boolean right = index * 2 + 1 < size && array[index].compareTo(array[index * 2 + 1]) < 0;
    if (left && right) {
      if (array[index * 2].compareTo(array[index * 2 + 1]) > 0) {
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
}
