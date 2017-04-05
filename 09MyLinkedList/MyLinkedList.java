public class MyLinkedList {
  private int size;
  private LNode head, tail;

  public MyLinkedList() {
    size = 0;
  }

  public boolean add(int value) {
    add(size, value);
    return true;
  }

  public boolean add(int index, int value) {
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

  }

  private void remove(LNode target) {

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

  public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList();

    list.add(0);
    list.add(1);
    list.add(2);
    list.add(3, 10);
    list.add(3);
    list.add(4);
    list.add(5);

    System.out.println(list);
  }
}
