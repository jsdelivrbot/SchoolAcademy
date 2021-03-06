public class PathsInLabirinth {
  static char[][] lab = {
      {' ', ' ', ' ', '*', ' ', ' ', ' '},
      {'*', '*', ' ', '*', ' ', '*', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', '*', '*', '*', '*', '*', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', '?'},
  };

  static void findExit(int row, int col) {
    if (row < 0 || row >= lab.length ||
        col < 0 || col >= lab[0].length) {
      // We are out of the labyrinth -> can't find a path
      return;
    }

    // Check if we have found the exit
    if (lab[row][col] == '?') {
      System.out.println("Found the exit!");
    }

    if (lab[row][col] != ' ') {
      // The current cell is not free -> can't find a path
      return;
    }

    // Temporary mark the current cell as visited
    lab[row][col] = 's';

    // Invoke recursion to explore all possible directions
    findExit(row, col - 1); // left
    findExit(row - 1, col); // up
    findExit(row, col + 1); // right
    findExit(row + 1, col); // down

    // Mark back the current cell as free
    lab[row][col] = ' ';
  }

  public static void main(String[] args) {
    findExit(0, 0);
  }
}