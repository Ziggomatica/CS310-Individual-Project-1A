package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        grid = new Mark[width][width];

        /* Initialize grid by filling every square with empty marks */

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < width; j++) {
                grid[i][j] = Mark.EMPTY;
            }
        }
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */

        return ((!isSquareMarked(row,col)) && (isValidSquare(row,col)));
        
    }
	
    private boolean isValidSquare(int row, int col) {
        /* Return true if specified location is within grid bounds */ 
        
        return (row < width) && (row >= 0) && (col < width) && (col >= 0);
    }
    
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        return (grid[row][col] != Mark.EMPTY);
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */

        return grid[row][col];
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        if (isMarkWin(Mark.X)) {
            return Result.X;
        }     
        else if (isMarkWin(Mark.O)) {
            return Result.O;
        }
        else if (isTie()) {
            return Result.TIE;
        }
        else return Result.NONE;
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        //Columns
        if (getMark(0,0) == mark) {
            if ((getMark(0,0).equals(getMark(1,0)))
                && (getMark(1,0).equals(getMark(2,0)))) {
                return true;
            }
        }
        if (getMark(0,1) == mark) {
            if ((getMark(0,1).equals(getMark(1,1)))
                && (getMark(1,1).equals(getMark(2,1)))) {
                return true;
            }
        }
        if (getMark(0,2) == mark) {
            if ((getMark(0,2).equals(getMark(1,2)))
                && (getMark(1,2).equals(getMark(2,2)))) {
                return true;
            }
        }
        
        //Rows
        if (getMark(0,0) == mark) {
            if ((getMark(0,0).equals(getMark(0,1))) 
                && (getMark(0,1).equals(getMark(0,2)))) {
                return true;
            }
        }
        if (getMark(1,0) == mark) {
            if ((getMark(1,0).equals(getMark(1,1))) 
                && (getMark(1,1).equals(getMark(1,2)))) {
                return true;
            }
        }
        if (getMark(2,0) == mark) {
            if ((getMark(2,0).equals(getMark(2,1))) 
                && (getMark(2,1).equals(getMark(2,2)))) {
                return true;
            }
        }
        
        //Diagonals
        if (getMark(0,0) == mark) {
            if ((getMark(0,0).equals(getMark(1,1))) 
                && (getMark(1,1).equals(getMark(2,2)))) {
                return true;
            }
        }
        if (getMark(0,2) == mark) {
            if ((getMark(0,2).equals(getMark(1,1))) 
                && (getMark(1,1).equals(getMark(2,0)))) {
                return true;
            }
        }
        
        return false;
    }
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < width; j++) {
                if ((!isSquareMarked(i,j)) || (isMarkWin(grid[i][j]))) {
                    return false;
                }
            }
        }
        return true;    
    }

    public boolean isGameover(){
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn(){
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth(){
        
        /* Getter for width */
        
        return width;
        
    }
    
}