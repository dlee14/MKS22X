public class FrontierPriorityQueue implements Frontier {
  PriorityQueue locations;

  public FrontierPriorityQueue() {
    locations = new PriorityQueue();
  }

  public void add(Location location) {
    locations.add(location);
  }

  public Location next() {
    return locations.remove();
  }

  public Location peek() {
    return locations.peek();
  }

  public int getSize() {
    return locations.getSize();
  }
}
