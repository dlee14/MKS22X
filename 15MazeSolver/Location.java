public class Location implements Comparable<Location> {
  private int row, col, distToStart, distToEnd;
  private Location previous;
  private boolean aStar;

  public Location(int row, int col, Location previous, int distToStart, int distToEnd, boolean aStar) {
    this.row = row;
    this.col = col;
    this.previous = previous;
    this.distToStart = distToStart;
    this.distToEnd = distToEnd;
    this.aStar = aStar;
    if (!aStar) {
      distToStart = 0;
    }
  }

  public Location getPrevious() {
    return previous;
  }

  public int calcDist(Location other) {
    return Math.abs(other.getRow() - row) + Math.abs(other.getCol() - col);
  }

  public int getDistStart() {
    return distToStart;
  }

  public int getDistEnd() {
    return distToEnd;
  }

  public void setDistStart(int distToStart) {
    this.distToStart = distToStart;
  }

  public void setDistEnd(int distToEnd) {
    this.distToEnd = distToEnd;
  }

  public void setAstar(boolean b) {
    aStar = b;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public int compareTo(Location other) {
    return (this.getDistEnd() - this.getDistStart()) - (other.getDistEnd() - other.getDistStart());
  }

  public String toString() {
    return "(" + row + ", " + col + ")";

  }
}
