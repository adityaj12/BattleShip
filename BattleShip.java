import java.util.Scanner;

class Main {
  
  public static void main(String[] args) {
    System.out.println("Welcome to Battleship! Let's start by setting up the game.");
    
    Scanner s = new Scanner(System.in);
    System.out.println("How tall should the board be?");
    int height = s.nextInt();
    System.out.println("How wide should the board be?");
    int width = s.nextInt();
    System.out.println("How many two-unit ships should each player have?");
    int twoCount = s.nextInt();
    System.out.println("How many three-unit ships should each player have?");
    int threeCount = s.nextInt();
    System.out.println("How many four-unit ships should each player have?");
    int fourCount = s.nextInt();

    int[] maxes = new int[3];
    maxes[0] = twoCount;
    maxes[1] = threeCount;
    maxes[2] = fourCount;

    int [][] grid = new int[width][height];
    int [][] grid2 = new int[width][height];

    int [][] ships = new int[width][height];
    int [][] ships2 = new int[width][height];

    for (int i = 1; i < 3; ++i) {
      System.out.println("Okay, it's time for Player " + Integer.toString(i) + " to set up their ships! You will be asked to type in coordinates for each of your ships.");
      
      if (i == 1) {
      
      for (int j = 2; j < 5; ++j) {
        
        if (j == 2) {
          System.out.println("Now entering coordinates for your " + Integer.toString(twoCount) + " " + Integer.toString(j) + "-unit ships.");
          for (int k = twoCount-2; k < twoCount; ++k) {
              System.out.print("\nPick a row: ");
              int row = s.nextInt()-1;
              System.out.print("\nPick a column: ");
              int col = s.nextInt()-1;
              ships[row][col] = 1;
          }
        }

        if (j == 3) {
          System.out.println("Now entering coordinates for your " + Integer.toString(threeCount) + " " + Integer.toString(j) + "-unit ships.");
          for (int k = threeCount-3; k < threeCount; ++k) {
              System.out.print("\nPick a row: ");
              int row = s.nextInt()-1;
              System.out.print("\nPick a column: ");
              int col = s.nextInt()-1;
              ships[row][col] = 1;
          }
        }
      
        if (j == 4) {
          System.out.println("Now entering coordinates for your " + Integer.toString(fourCount) + " " + Integer.toString(j) + "-unit ships.");
          for (int k = fourCount-4; k < fourCount; ++k) {
              System.out.print("\nPick a row: ");
              int row = s.nextInt()-1;
              System.out.print("\nPick a column: ");
              int col = s.nextInt()-1;
              ships[row][col] = 1;
          }
        }
      }
    }
  
      if (i == 2) {
      
      for (int j = 2; j < 5; ++j) {
        
        if (j == 2) {
          System.out.println("Now entering coordinates for your " + Integer.toString(twoCount) + " " + Integer.toString(j) + "-unit ships.");
          for (int k = twoCount-2; k < twoCount; ++k) {
              System.out.print("\nPick a row: ");
              int row = s.nextInt()-1;
              System.out.print("\nPick a column: ");
              int col = s.nextInt()-1;
              ships2[row][col] = 1;
          }
        }

        if (j == 3) {
          System.out.println("Now entering coordinates for your " + Integer.toString(threeCount) + " " + Integer.toString(j) + "-unit ships.");
          for (int k = threeCount-3; k < threeCount; ++k) {
              System.out.print("\nPick a row: ");
              int row = s.nextInt()-1;
              System.out.print("\nPick a column: ");
              int col = s.nextInt()-1;
              ships2[row][col] = 1;
          }
        }
      
        if (j == 4) {
          System.out.println("Now entering coordinates for your " + Integer.toString(fourCount) + " " + Integer.toString(j) + "-unit ships.");
          for (int k = fourCount-4; k < fourCount; ++k) {
              System.out.print("\nPick a row: ");
              int row = s.nextInt()-1;
              System.out.print("\nPick a column: ");
              int col = s.nextInt()-1;
              ships2[row][col] = 1;
          }
        }
      }
    }
    }
    int hits = 0;
    int ship_count = (2 * twoCount + 3 * threeCount + 4 * fourCount);

    int turns = 0;
    while(true) {
      
      if (turns % 2 == 0) {
      drawGrid(grid);
      
      Scanner in = new Scanner(System.in);
      System.out.print("\nPick a row: ");
      int row = in.nextInt();
      System.out.print("\nPick a column: ");
      int col = in.nextInt();
      
      if (ships[row-1][col-1] == 1) {
        System.out.println("It\'s a hit!");
        ships[row-1][col-1] = 2;
        grid[row-1][col-1] = 2;
        hits++;
      } 
      else if (ships[row-1][col-1] == 2) {
        System.out.println("You already found a ship here!");
      } 
      else {
        System.out.println("It\'s a miss!");
      }

      if (hits == ship_count) {
        System.out.println("You sank all the ships!");
        drawGrid(grid);
        break;
        }
      
    }

    turns += 1;
      if (turns % 2 == 1) {
      drawGrid(grid2);
      
      Scanner in2 = new Scanner(System.in);
      System.out.print("\nPick a row: ");
      int row2 = in2.nextInt();
      System.out.print("\nPick a column: ");
      int col2 = in2.nextInt();
      
      if (ships2[row2-1][col2-1] == 1) {
        System.out.println("It\'s a hit!");
        ships2[row2-1][col2-1] = 2;
        grid2[row2-1][col2-1] = 2;
        hits++;
      } 
      else if (ships2[row2-1][col2-1] == 2) {
        System.out.println("You already found a ship here!");
      } 
      else {
        System.out.println("It\'s a miss!");
      }

      if (hits == ship_count) {
        System.out.println("You sank all the ships!");
        drawGrid(grid2);
        break;
        }
      }
    }
}

  public static void drawGrid(int [][] grid) {
    System.out.print("  ");
    for (int i = 0; i < grid[0].length; ++i) {
      System.out.print(i+1 + " ");
    }
    int a = 0;
    for (int[] row : grid) {
      System.out.println("");
      System.out.print(a+1+" ");
      a++;
      for (int i = -1; i < grid.length-1; ++i) {
          if (row[i+1] == 2) {
            System.out.print("x ");
          }
          else if (row[i+1] == 0) {
            System.out.print("- ");
          }
        }
    }
  }
}