package net.java.naved;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SudokuController {

    // Dummy Sudoku matrix for demonstration
   /* private int[][] sudokuMatrix = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 00, 7, 9}
    };*/

    /*@GetMapping("/sudoku/getMatrix")
    @ResponseBody
    public int[][] getMatrix() {
        return sudokuMatrix;
    }
    */
    private List<int[][]> sudokuMatrix = new ArrayList<>();

    // Initialize the list with 10 Sudoku matrices
    {
    	sudokuMatrix.add(new int[][] {
        	{5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 00, 7, 9}
        });
    	sudokuMatrix.add(new int[][] {
        	{0, 2, 0, 0, 7, 0, 0, 0, 0},
        		 {9, 0, 0, 5, 0, 0, 0, 0, 8},
        		 {0, 0, 5, 0, 6, 0, 0, 1, 0},
        		 {0, 8, 0, 0, 0, 2, 0, 7, 0},
        		 {0, 0, 4, 8, 0, 7, 2, 0, 0},
        		 {0, 3, 0, 6, 0, 0, 0, 4, 0},
        		 {0, 1, 0, 0, 9, 0, 7, 0, 0},
        		 {3, 0, 0, 0, 0, 5, 0, 0, 2},
        		 {0, 0, 0, 0, 2, 0, 0, 9, 0}

        });
        // Add 8 more matrices similarly...
    	sudokuMatrix.add(new int[][] {
    		{0, 0, 0, 0, 5, 4, 8, 0, 0},
    			 {0, 0, 0, 0, 0, 0, 0, 1, 6},
    			 {2, 0, 6, 0, 0, 0, 4, 0, 0},
    			 {0, 9, 0, 0, 0, 0, 0, 0, 0},
    			 {0, 0, 1, 9, 7, 2, 5, 0, 0},
    			 {0, 0, 0, 0, 0, 0, 0, 3, 0},
    			 {0, 0, 7, 0, 0, 0, 9, 0, 8},
    			 {8, 5, 0, 0, 0, 0, 0, 0, 0},
    			 {0, 0, 4, 3, 6, 0, 0, 0, 0}

        });
    	sudokuMatrix.add(new int[][] {
        	{3, 0, 6, 0, 0, 0, 8, 0, 4},
        		 {5, 0, 0, 0, 0, 0, 0, 3, 0},
        		 {0, 0, 0, 0, 0, 7, 0, 0, 0},
        		 {2, 0, 0, 0, 0, 0, 0, 0, 5},
        		 {0, 0, 5, 0, 0, 0, 9, 0, 0},
        		 {7, 0, 0, 0, 0, 0, 0, 0, 8},
        		 {0, 0, 0, 2, 0, 0, 0, 0, 0},
        		 {0, 6, 0, 0, 0, 0, 0, 0, 7},
        		 {9, 0, 3, 0, 0, 0, 4, 0, 1}


        });
    	sudokuMatrix.add(new int[][] {
        	{0, 0, 0, 6, 0, 0, 0, 3, 0},
        		 {0, 0, 0, 0, 8, 5, 0, 0, 1},
        		 {0, 0, 0, 0, 0, 2, 0, 9, 8},
        		 {0, 0, 0, 0, 0, 0, 0, 0, 0},
        		 {6, 0, 2, 0, 0, 0, 8, 0, 0},
        		 {0, 0, 0, 4, 0, 9, 0, 0, 0},
        		 {3, 0, 0, 0, 0, 0, 0, 0, 0},
        		 {0, 0, 1, 0, 7, 6, 0, 0, 0},
        		 {0, 2, 0, 0, 0, 0, 0, 8, 0}



        });
        
    	sudokuMatrix.add(new int[][] {
        	{4, 0, 0, 8, 3, 0, 0, 0, 0},
        		 {5, 0, 0, 0, 0, 0, 0, 2, 0},
        		 {8, 0, 0, 0, 0, 4, 7, 0, 0},
        		 {0, 6, 2, 1, 0, 5, 0, 0, 0},
        		 {0, 0, 0, 0, 0, 0, 0, 0, 7},
        		 {0, 4, 0, 0, 0, 0, 8, 0, 0},
        		 {0, 0, 0, 0, 9, 0, 0, 0, 4},
        		 {0, 5, 0, 0, 0, 0, 0, 0, 0},
        		 {0, 0, 0, 6, 0, 7, 0, 0, 0}

        });
        
    	sudokuMatrix.add(new int[][] {
        	{0, 8, 0, 0, 0, 0, 0, 0, 0},
        		 {0, 0, 7, 0, 0, 0, 0, 0, 0},
        		 {0, 0, 0, 3, 0, 0, 0, 0, 0},
        		 {0, 0, 0, 6, 0, 8, 4, 0, 7},
        		 {0, 0, 0, 0, 0, 0, 0, 3, 0},
        		 {0, 0, 0, 0, 0, 0, 0, 2, 0},
        		 {0, 0, 0, 0, 0, 0, 9, 0, 0},
        		 {0, 0, 0, 0, 0, 0, 0, 0, 0},
        		 {0, 0, 0, 0, 0, 0, 0, 0, 1}


        });
        
        
    }
    private int[][] randomSudokuMatrix;
    @GetMapping("/sudoku/getMatrix")
    @ResponseBody
    public int[][] getMatrix() {
        // Randomly select a matrix from the list
    	Random random = new Random();
        int randomIndex = random.nextInt(sudokuMatrix.size());
        randomSudokuMatrix = sudokuMatrix.get(randomIndex);

        return randomSudokuMatrix;
    }
    
    @PostMapping("/submit")
    @ResponseBody
    public String submitMatrix(@RequestBody SudokuSubmission submission) {
        int[] submittedMatrix = submission.getMatrix();

        // Convert the flat array into a 9x9 matrix
        int[][] sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = submittedMatrix[i * 9 + j];
            }
        }

        // Get the specific matrix from the List
        int[][] sudokuMatrixToCompare = randomSudokuMatrix;; // Change here

        int[][] sudokusolution = SudokuSolver.solveSudoku(sudokuMatrixToCompare);

        // Handle the submitted matrix on the server side
        if (areMatricesEqual(sudokusolution, sudoku)) {
            return "bingo";
        } else {
            return "tryy";
        }
    }




    public static boolean areMatricesEqual(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            // Matrices have different dimensions
            return false;
        }

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    // Found a difference in corresponding elements
                    return false;
                }
            }
        }

        // Matrices are equal
        return true;
    }
    public static int countDifferences(int[][] solutionMatrix, int[][] submittedMatrix) {
        if (solutionMatrix.length != submittedMatrix.length || solutionMatrix[0].length != submittedMatrix[0].length) {
            // Matrices have different dimensions
            throw new IllegalArgumentException("Matrices have different dimensions");
        }

        int differences = 0;

        for (int i = 0; i < solutionMatrix.length; i++) {
            for (int j = 0; j < solutionMatrix[0].length; j++) {
                if (solutionMatrix[i][j] != submittedMatrix[i][j]) {
                    // Found a difference in corresponding elements
                    differences++;
                }
            }
        }

        return differences;
    }

    
    @GetMapping("/solution")
    public String solution(Model model) {
        int[][] sudokuSolution = SudokuSolver.solveSudoku(randomSudokuMatrix);
        model.addAttribute("sudokuSolution", sudokuSolution);
        return "solution";
    }

    
    
   /* @ResponseBody
    public String progress(@RequestBody SudokuSubmission submission) {
        int[] submittedMatrix = submission.getMatrix();

        // Convert the flat array into a 9x9 matrix
        int[][] sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = submittedMatrix[i * 9 + j];
            }
        }

        int[][] sudokusolution = SudokuSolver.solveSudoku(randomSudokuMatrix);
        int mis = countDifferences(sudokusolution, sudoku);
        System.out.println(mis);

        // Return the mis value as a response
        return String.valueOf(mis);
    }*/





    @GetMapping("/sudoku")
    public String homecontroller() {
        return "index";
    }
    
    @GetMapping("/bingo")
    public String bingo() {
        return "bingo";
    }
    
    @GetMapping("/try")
    public String tryagain() {
        return "try";
    }
    
    /*@GetMapping("/progress")
    @ResponseBody
    public int checkProgress(@RequestBody SudokuSubmission submission) {
        int[] submittedMatrix = submission.getMatrix();

        // Convert the flat array into a 9x9 matrix
        int[][] submittedSudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                submittedSudoku[i][j] = submittedMatrix[i * 9 + j];
            }
        }

        // Get the specific matrix from the List
        int[][] sudokuMatrixToCompare = randomSudokuMatrix; // Change here

        int differences = countDifferences(sudokuMatrixToCompare, submittedSudoku);

        return differences;
    }*/
    private int differences;
    
    @GetMapping("/progress")
    @ResponseBody
    public int checkProgress(@RequestParam(value = "matrix[]") int[] submittedMatrix,Model model) {
        // Print the received matrix to the console
        System.out.println("Received Matrix:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(submittedMatrix[i * 9 + j] + " ");
            }
            System.out.println();
        }

        // Convert the flat array into a 9x9 matrix
        int[][] submittedSudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                submittedSudoku[i][j] = submittedMatrix[i * 9 + j];
            }
        }

        // Print the submittedSudoku to the console
        System.out.println("Submitted Sudoku:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(submittedSudoku[i][j] + " ");
            }
            System.out.println();
        }

        // Get the specific matrix from the List
        int[][] sudokuSolution = SudokuSolver.solveSudoku(randomSudokuMatrix);
        

        // Print the sudokuMatrixToCompare to the console
        System.out.println("Sudoku Matrix to Compare:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudokuSolution[i][j] + " ");
            }
            System.out.println();
        }

        int differences = countDifferences(sudokuSolution, submittedSudoku);
        differences = countDifferences(sudokuSolution, submittedSudoku);
        System.out.println("Differences: " + differences);
        model.addAttribute("differences", differences);
        return differences;
    }
    
    @GetMapping("/pp")
    public String pp(Model model) {
        // Access the differences field
    	int differences = (int) model.getAttribute("differences");
        System.out.println("THIS IS SEXY BRO"+differences);
        return "ppp";
    }
    
    @GetMapping("/about")
    public String about() {
        return "about";
    }


}
