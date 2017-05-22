public class MazeSolver {
  private Maze board;

  public MazeSolver(String filename) {
    board = new Maze(filename);
  }

  public void solve() {
    solve(1);
  }

  public void solve(int style) {
    Location start = board.getStart();
    Location end = board.getEnd();
    if (style == 0) {
      //Depth First Search
      FrontierStack frontierstack = new FrontierStack();
      frontierstack.add(board.getStart());
      Location current = frontierstack.peek();
      int currentRow = current.getRow();
      int currentCol = current.getCol();
      board.set(currentRow, currentCol, ' ');
      while (frontierstack.getSize() > 0 && board.get(currentRow, currentCol) != 'E') {
        board.set(currentRow, currentCol, '.');
        for (int i = 0; i < 4; i++) {
          if (i == 0) {
            Location next = new Location(currentRow - 1, currentCol, current, 0, 0, false);
            if (isEmpty(next)) {
              board.set(currentRow - 1, currentCol, '?');
              frontierstack.add(next);
            } else if (board.get(currentRow - 1, currentCol) == 'E') {
              frontierstack.add(next);
            }
          } else
          if (i == 1) {
            Location next = new Location(currentRow, currentCol - 1, current, 0, 0, false);
            if (isEmpty(next)) {
              board.set(currentRow, currentCol - 1, '?');
              frontierstack.add(next);
            } else if (board.get(currentRow, currentCol - 1) == 'E') {
              frontierstack.add(next);
            }
          } else
          if (i == 2) {
            Location next = new Location(currentRow + 1, currentCol, current, 0, 0, false);
            if (isEmpty(next)) {
              board.set(currentRow + 1, currentCol, '?');
              frontierstack.add(next);
            } else if (board.get(currentRow + 1, currentCol) == 'E') {
              frontierstack.add(next);
            }
          } else
          if (i == 3) {
            Location next = new Location(currentRow, currentCol + 1, current, 0, 0, false);
            if (isEmpty(next)) {
              board.set(currentRow, currentCol + 1, '?');
              frontierstack.add(next);
            } else if (board.get(currentRow, currentCol + 1) == 'E') {
              frontierstack.add(next);
            }
          }
        }
        current = frontierstack.next();
        currentRow = current.getRow();
        currentCol = current.getCol();
        System.out.println(board.toString(25));
      }
      if (board.get(currentRow, currentCol) == 'E') {
        while (current.getPrevious() != null) {
          board.set(currentRow, currentCol, '@');
          current = current.getPrevious();
          currentRow = current.getRow();
          currentCol = current.getCol();
        }
      }
      // System.out.println(answer);
    } else
    if (style == 1) {
      //Breadth First Search
      FrontierQueue frontierqueue = new FrontierQueue();
      frontierqueue.add(board.getStart());
      Location current = frontierqueue.peek();
      int currentRow = current.getRow();
      int currentCol = current.getCol();
      board.set(currentRow, currentCol, ' ');
      while (frontierqueue.getSize() > 0 && board.get(currentRow, currentCol) != 'E') {
        board.set(currentRow, currentCol, '.');
        for (int i = 0; i < 4; i++) {
          if (i == 0) {
            Location next = new Location(currentRow - 1, currentCol, current, 0, 0, false);
            if (isEmpty(next)) {
              board.set(currentRow - 1, currentCol, '?');
              frontierqueue.add(next);
            } else if (board.get(currentRow - 1, currentCol) == 'E') {
              frontierqueue.add(next);
            }
          } else
          if (i == 1) {
            Location next = new Location(currentRow, currentCol - 1, current, 0, 0, false);
            if (isEmpty(next)) {
              board.set(currentRow, currentCol - 1, '?');
              frontierqueue.add(next);
            } else if (board.get(currentRow, currentCol - 1) == 'E') {
              frontierqueue.add(next);
            }
          } else
          if (i == 2) {
            Location next = new Location(currentRow + 1, currentCol, current, 0, 0, false);
            if (isEmpty(next)) {
              board.set(currentRow + 1, currentCol, '?');
              frontierqueue.add(next);
            } else if (board.get(currentRow + 1, currentCol) == 'E') {
              frontierqueue.add(next);
            }
          } else
          if (i == 3) {
            Location next = new Location(currentRow, currentCol + 1, current, 0, 0, false);
            if (isEmpty(next)) {
              board.set(currentRow, currentCol + 1, '?');
              frontierqueue.add(next);
            } else if (board.get(currentRow, currentCol + 1) == 'E') {
              frontierqueue.add(next);
            }
          }
        }
        current = frontierqueue.next();
        currentRow = current.getRow();
        currentCol = current.getCol();
        System.out.println(board.toString(25));
      }
      if (board.get(currentRow, currentCol) == 'E') {
        while (current.getPrevious() != null) {
          board.set(currentRow, currentCol, '@');
          current = current.getPrevious();
          currentRow = current.getRow();
          currentCol = current.getCol();
        }
      }
    } else
    if (style == 2) {
      //BestFirst
      //end
      FrontierPriorityQueue priorityqueue = new FrontierPriorityQueue(true);
      priorityqueue.add(board.getStart());
      Location current = priorityqueue.peek();
      int currentRow = current.getRow();
      int currentCol = current.getCol();
      board.set(currentRow, currentCol, ' ');
      while (priorityqueue.getSize() > 0 && board.get(currentRow, currentCol) != 'E') {
        board.set(currentRow, currentCol, '.');
        for (int i = 0; i < 4; i++) {
          if (i == 0) {
            Location next = new Location(currentRow, currentCol + 1, current, 0, 0, false);
            if (isEmpty(next)) {
              board.set(currentRow, currentCol + 1, '?');
              next.setDistEnd(next.calcDist(end));
              priorityqueue.add(next);
            } else if (board.get(currentRow , currentCol + 1) == 'E') {
              priorityqueue.add(next);
            }
          } else
          if (i == 1) {
            Location next = new Location(currentRow, currentCol - 1, current, 0, 0, false);
            if (isEmpty(next)) {
              board.set(currentRow, currentCol - 1, '?');
              next.setDistEnd(next.calcDist(end));
              priorityqueue.add(next);
            } else if (board.get(currentRow, currentCol - 1) == 'E') {
              priorityqueue.add(next);
            }
          } else
          if (i == 2) {
            Location next = new Location(currentRow + 1, currentCol, current, 0, 0, false);
            if (isEmpty(next)) {
              board.set(currentRow + 1, currentCol, '?');
              next.setDistEnd(next.calcDist(end));
              priorityqueue.add(next);
            } else if (board.get(currentRow + 1, currentCol) == 'E') {
              priorityqueue.add(next);
            }
          } else
          if (i == 3) {
            Location next = new Location(currentRow - 1, currentCol, current, 0, 0, false);
            if (isEmpty(next)) {
              board.set(currentRow - 1, currentCol, '?');
              next.setDistEnd(next.calcDist(end));
              priorityqueue.add(next);
            } else if (board.get(currentRow - 1, currentCol) == 'E') {
              priorityqueue.add(next);
            }
          }
        }
        current = priorityqueue.next();
        currentRow = current.getRow();
        currentCol = current.getCol();
        System.out.println(board.toString(25));
      }
      if (board.get(currentRow, currentCol) == 'E') {
        while (current.getPrevious() != null) {
          board.set(currentRow, currentCol, '@');
          current = current.getPrevious();
          currentRow = current.getRow();
          currentCol = current.getCol();
        }
      }
    } else
    if (style == 3) {
      //A*
      //start + end
      FrontierPriorityQueue priorityqueue = new FrontierPriorityQueue(true);
      start.setAstar(true);
      priorityqueue.add(start);
      Location current = priorityqueue.peek();
      int currentRow = current.getRow();
      int currentCol = current.getCol();
      board.set(currentRow, currentCol, ' ');
      while (priorityqueue.getSize() > 0 && board.get(currentRow, currentCol) != 'E') {
        board.set(currentRow, currentCol, '.');
        for (int i = 0; i < 4; i++) {
          if (i == 0) {
            Location next = new Location(currentRow, currentCol + 1, current, 0, 0, true);
            if (isEmpty(next)) {
              board.set(currentRow, currentCol + 1, '?');
              next.setDistStart(next.calcDist(start));
              next.setDistEnd(next.calcDist(end));
              priorityqueue.add(next);
            } else if (board.get(currentRow, currentCol + 1) == 'E') {
              priorityqueue.add(next);
              break;
            }
          } else
          if (i == 1) {
            Location next = new Location(currentRow, currentCol - 1, current, 0, 0, true);
            if (isEmpty(next)) {
              board.set(currentRow, currentCol - 1, '?');
              next.setDistStart(next.calcDist(start));
              next.setDistEnd(next.calcDist(end));
              priorityqueue.add(next);
            } else if (board.get(currentRow, currentCol - 1) == 'E') {
              priorityqueue.add(next);
              break;
            }
          } else
          if (i == 2) {
            Location next = new Location(currentRow + 1, currentCol, current, 0, 0, true);
            if (isEmpty(next)) {
              board.set(currentRow + 1, currentCol, '?');
              next.setDistStart(next.calcDist(start));
              next.setDistEnd(next.calcDist(end));
              priorityqueue.add(next);
            } else if (board.get(currentRow + 1, currentCol) == 'E') {
              priorityqueue.add(next);
              break;
            }
          } else
          if (i == 3) {
            Location next = new Location(currentRow - 1, currentCol, current, 0, 0, true);
            if (isEmpty(next)) {
              board.set(currentRow - 1, currentCol, '?');
              next.setDistStart(next.calcDist(start));
              next.setDistEnd(next.calcDist(end));
              priorityqueue.add(next);
            } else if (board.get(currentRow - 1, currentCol) == 'E') {
              priorityqueue.add(next);
              break;
            }
          }
        }
        current = priorityqueue.next();
        currentRow = current.getRow();
        currentCol = current.getCol();
        System.out.println(board.toString(50));
      }
      if (board.get(currentRow, currentCol) == 'E') {
        while (current.getPrevious() != null) {
          board.set(currentRow, currentCol, '@');
          current = current.getPrevious();
          currentRow = current.getRow();
          currentCol = current.getCol();
        }
      }
    }
  }

  private boolean isEmpty(Location location) {
    return board.get(location.getRow(), location.getCol()) == ' ' ||
    board.get(location.getRow(), location.getCol()) == '?';
  }

  public String toString() {
    return board + "";
  }

  public String toString(int delay) {
    return board.toString(delay);
  }
}
