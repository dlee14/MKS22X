import java.util.*;

public class MyLinkedList implements Iterable<Integer> {
  private int size;
  private LNode head, tail;

  private class LNode {
    private int value;
    private LNode next, prev;

    public LNode(int value) {
      this.value = value;
      next = null;
      prev = null;
    }

    public void setNext(LNode next) {
      this.next = next;
    }

    public void setPrev(LNode prev) {
      this.prev = prev;
    }

    public void setValue(int newValue) {
      value = newValue;
    }

    public LNode getNext() {
      return next;
    }

    public LNode getPrev() {
      return prev;
    }

    public int getValue() {
      return value;
    }

    public String toString() {
      String result = "";
      if (prev == null) {
        result += "(null)";
      } else {
        result += "(" + prev.getValue() + ")";
      }
      result += value;
      if (next == null) {
        result += "(null)";
      } else {
        result += "(" + next.getValue() + ")";
      }
      return result;
    }

  }


  public MyLinkedList() {
    size = 0;
  }

  public boolean add(int value) {
    add(size, value);
    return true;
  }

  public boolean add(int index, int value) {
    if (index < 0) {
      throw new IndexOutOfBoundsException("Invalid index for add: " + index);
    }
    if (index == 0) {
      if (size == 0) {
        head = new LNode(value);
        tail = head;
        size++;
      } else {
        LNode newHead = new LNode(value);
        newHead.setNext(head);
        head.setPrev(newHead);
        head = newHead;
        size++;
      }
    } else if (index == size) {
      LNode newEnd = new LNode(value);
      tail.setNext(newEnd);
      newEnd.setPrev(tail);
      tail = newEnd;
      size++;
    } else {
      LNode newNode = new LNode(value);
      LNode indexNode = getNthNode(index);
      newNode.setNext(indexNode);
      newNode.setPrev(indexNode.getPrev());
      indexNode.setPrev(newNode);
      newNode.getPrev().setNext(newNode);
      size++;
    }
    return true;
  }

  public int get(int index) {
    return getNthNode(index).getValue();
  }

  public int set(int index, int newValue) {
    if (index < 0) {
      throw new IndexOutOfBoundsException("Invalid index for add: " + index);
    }
    LNode current = head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    int oldValue = 0;
    oldValue = current.getValue();
    current.setValue(newValue);
    return oldValue;
  }

  private LNode getNthNode(int n) {
    if (n < 0 || n >= size) {
      throw new IndexOutOfBoundsException("Invalid index for getNthNode: " + n);
    }
    LNode current = head;
    for (int i = 0; i < n; i++) {
      current = current.getNext();
    }
    return current;
  }

  private void addAfter(LNode location, LNode toBeAdded) {
    if (location == null) {
      throw new NullPointerException("location is null");
    }
    if (toBeAdded == null) {
      throw new NullPointerException("toBeAdded is null");
    }
    toBeAdded.setNext(location.getNext());
    toBeAdded.setPrev(location);
    location.getNext().setPrev(toBeAdded);
    location.setNext(toBeAdded);
    size++;
  }

  private void remove(LNode target) {
    target.getPrev().setNext(target.getNext());
    target.getNext().setPrev(target.getPrev());
    size--;
  }

  public int remove(int index) {
    if (index < 0) {
      throw new IndexOutOfBoundsException("Invalid index for add: " + index);
    }
    remove(getNthNode(index));
    return getNthNode(index).getValue();
  }

  public int size() {
    return size;
  }

  public String toString() {
    String result = "[";
    for (int i = 0; i < size; i++) {
      if (i == 0) {
        result += getNthNode(i);
      } else {
        result += ", " + getNthNode(i);
      }
    }
    result += "]";
    return result;
  }

  public Iterator<Integer> iterator() {
    return new MyLinkedListIterator(this);
  }

  private class MyLinkedListIterator implements Iterator<Integer> {
    private MyLinkedList linkedList;
    private LNode current = head;

    public MyLinkedListIterator(MyLinkedList linkedList) {
      this.linkedList = linkedList;
    }

    public boolean hasNext() {
      return current != null;
    }

    public Integer next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      else {
        int value  = current.value;
        current = current.next;
        return value;
      }
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
