package net.java.naved;

public class SudokuSolver {

    private static final int SIZE = 9;

    public static int[][] solveSudoku(int[][] puzzle) {
        int[][] solvedMatrix = new int[SIZE][SIZE];

        // Copy the original puzzle to avoid modifying it
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(puzzle[i], 0, solvedMatrix[i], 0, SIZE);
        }

        if (solveSudokuHelper(solvedMatrix)) {
            return solvedMatrix;
        } else {
            // If no solution is found, return the original matrix
            return puzzle;
        }
    }

    private static boolean solveSudokuHelper(int[][] puzzle) {
        int[] nextBlank = findBlank(puzzle);

        if (nextBlank == null) {
            // No more blanks, puzzle is solved
            return true;
        }

        int row = nextBlank[0];
        int col = nextBlank[1];

        for (int num = 1; num <= SIZE; num++) {
            if (isValidMove(puzzle, row, col, num)) {
                puzzle[row][col] = num;

                if (solveSudokuHelper(puzzle)) {
                    return true;
                }

                puzzle[row][col] = 0; // Backtrack
            }
        }

        return false; // No valid number found for this blank
    }

    private static int[] findBlank(int[][] puzzle) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (puzzle[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // No blanks found
    }

    private static boolean isValidMove(int[][] puzzle, int row, int col, int num) {
        // Check if the number is not present in the row and column
        for (int i = 0; i < SIZE; i++) {
            if (puzzle[row][i] == num || puzzle[i][col] == num) {
                return false;
            }
        }

        // Check if the number is not present in the 3x3 grid
        int boxStartRow = row - row % 3;
        int boxStartCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (puzzle[boxStartRow + i][boxStartCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printSudoku(int[][] puzzle) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
