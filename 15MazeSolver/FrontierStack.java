import java.util.*;

public class FrontierStack implements Frontier {
  private Stack<Location> locations;
  private int size;

  public FrontierStack() {
    locations = new Stack<Location>();
  }

  public void add(Location location) {
    locations.push(location);
    size++;
  }

  public Location next() {
    size--;
    return locations.pop();
  }

  public Location peek() {
    return locations.peek();
  }

  public int getSize() {
    return size;
  }
}
