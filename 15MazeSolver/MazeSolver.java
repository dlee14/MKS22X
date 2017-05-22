public class MazeSolver {
  private Maze board, answer;

  public MazeSolver(String filename) {
    board = new Maze(filename);
    answer = new Maze(filename);
  }

  public MazeSolver(String filename, boolean animate) {
    board = new Maze(filename);
    answer = new Maze(filename);
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
              frontierstack.add(next);
            }
          } else
          if (i == 1) {
            Location next = new Location(currentRow, currentCol - 1, current, 0, 0, false);
            if (isEmpty(next)) {
              frontierstack.add(next);
            }
          } else
          if (i == 2) {
            Location next = new Location(currentRow + 1, currentCol, current, 0, 0, false);
            if (isEmpty(next)) {
              frontierstack.add(next);
            }
          } else
          if (i == 3) {
            Location next = new Location(currentRow, currentCol + 1, current, 0, 0, false);
            if (isEmpty(next)) {
              frontierstack.add(next);
            }
          }
        }
        current = frontierstack.next();
        currentRow = current.getRow();
        currentCol = current.getCol();
      }
      if (board.get(currentRow, currentCol) == 'E') {
        while (current.getPrevious() != null) {
          answer.set(currentRow, currentCol, '@');
          current = current.getPrevious();
          currentRow = current.getRow();
          currentCol = current.getCol();
        }
      }
      System.out.println(answer);
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
              frontierqueue.add(next);
            }
          } else
          if (i == 1) {
            Location next = new Location(currentRow, currentCol - 1, current, 0, 0, false);
            if (isEmpty(next)) {
              frontierqueue.add(next);
            }
          } else
          if (i == 2) {
            Location next = new Location(currentRow + 1, currentCol, current, 0, 0, false);
            if (isEmpty(next)) {
              frontierqueue.add(next);
            }
          } else
          if (i == 3) {
            Location next = new Location(currentRow, currentCol + 1, current, 0, 0, false);
            if (isEmpty(next)) {
              frontierqueue.add(next);
            }
          }
        }
        current = frontierqueue.next();
        currentRow = current.getRow();
        currentCol = current.getCol();
      }
      if (board.get(currentRow, currentCol) == 'E') {
        while (current.getPrevious() != null) {
          answer.set(currentRow, currentCol, '@');
          current = current.getPrevious();
          currentRow = current.getRow();
          currentCol = current.getCol();
        }
      }
      System.out.println(answer);
    } else
    if (style == 2) {
      //BestFirst
      //end
      FrontierPriorityQueue priorityqueue = new FrontierPriorityQueue();
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
              next.setDistStart(next.calcDist(start));
              priorityqueue.add(next);
            }
          } else
          if (i == 1) {
            Location next = new Location(currentRow, currentCol - 1, current, 0, 0, false);
            if (isEmpty(next)) {
              next.setDistStart(next.calcDist(start));
              priorityqueue.add(next);
            }
          } else
          if (i == 2) {
            Location next = new Location(currentRow + 1, currentCol, current, 0, 0, false);
            if (isEmpty(next)) {
              next.setDistStart(next.calcDist(start));
              priorityqueue.add(next);
            }
          } else
          if (i == 3) {
            Location next = new Location(currentRow - 1, currentCol, current, 0, 0, false);
            if (isEmpty(next)) {
              next.setDistStart(next.calcDist(start));
              priorityqueue.add(next);
            }
          }
        }
        current = priorityqueue.next();
        currentRow = current.getRow();
        currentCol = current.getCol();
      }
      if (board.get(currentRow, currentCol) == 'E') {
        while (current.getPrevious() != null) {
          answer.set(currentRow, currentCol, '@');
          current = current.getPrevious();
          currentRow = current.getRow();
          currentCol = current.getCol();
        }
      }
      System.out.println(answer);
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
              next.setDistStart(next.calcDist(start));
              next.setDistEnd(next.calcDist(end));
              priorityqueue.add(next);
            }
          } else
          if (i == 1) {
            Location next = new Location(currentRow, currentCol - 1, current, 0, 0, true);
            if (isEmpty(next)) {
              next.setDistStart(next.calcDist(start));
              next.setDistEnd(next.calcDist(end));
              priorityqueue.add(next);
            }
          } else
          if (i == 2) {
            Location next = new Location(currentRow + 1, currentCol, current, 0, 0, true);
            if (isEmpty(next)) {
              next.setDistStart(next.calcDist(start));
              next.setDistEnd(next.calcDist(end));
              priorityqueue.add(next);
            }
          } else
          if (i == 3) {
            Location next = new Location(currentRow - 1, currentCol, current, 0, 0, true);
            if (isEmpty(next)) {
              next.setDistStart(next.calcDist(start));
              next.setDistEnd(next.calcDist(end));
              priorityqueue.add(next);
            }
          }
        }
        current = priorityqueue.next();
        currentRow = current.getRow();
        currentCol = current.getCol();
      }
      if (board.get(currentRow, currentCol) == 'E') {
        while (current.getPrevious() != null) {
          answer.set(currentRow, currentCol, '@');
          current = current.getPrevious();
          currentRow = current.getRow();
          currentCol = current.getCol();
        }
      }
      System.out.println(answer);
    }
  }

  private boolean isEmpty(Location location) {
    return board.get(location.getRow(), location.getCol()) == ' ' || board.get(location.getRow(), location.getCol()) == 'E';
  }

  public String toString() {
    return board + "";
  }

  public String toString(int delay) {
    return board.toString(delay);
  }
}
