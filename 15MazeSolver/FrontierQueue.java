import java.util.*;

public class FrontierQueue implements Frontier {
  private LinkedList<Location> locations;
  private int size;

  public FrontierQueue() {
    locations = new LinkedList<Location>();
    size = 0;
  }

  public void add(Location location) {
    locations.add(location);
    size++;
  }

  public Location next() {
    size--;
    return locations.remove();
  }

  public Location peek() {
    return locations.peek();
  }

  public int getSize() {
    return size;
  }
}
