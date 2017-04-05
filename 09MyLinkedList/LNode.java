public class LNode {
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
