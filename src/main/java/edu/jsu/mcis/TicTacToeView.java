package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        System.out.println();
        System.out.println("  012");
        System.out.println();
        System.out.println("0 " + model.getMark(0,0)
                + model.getMark(0,1) + model.getMark(0,2));
        System.out.println("1 " + model.getMark(1,0)
                + model.getMark(1,1) + model.getMark(1,2));
        System.out.println("2 " + model.getMark(2,0)
                + model.getMark(2,1) + model.getMark(2,2));
        System.out.println();

    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        if (model.isXTurn()) {
            System.out.println("Player 1 (X) Move: ");
        }
        else if (!model.isXTurn()) {
            System.out.println("Player 2 (O) Move: ");
        }
        
        System.out.print("Enter the row and column numbers, separated by a space: ");

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        System.out.println("Invalid input. Either that square is taken or "
                + "you didn't enter the correct numbers.");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}