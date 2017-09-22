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
        System.out.print("  ");
        for (int i = 0; i < model.getWidth(); i++) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println();
        for (int j = 0; j < model.getWidth(); j++) {
            System.out.print(j + " ");
            for (int k = 0; k < model.getWidth(); k++) {
                System.out.print(model.getMark(j, k));
            }
            System.out.println();
        }
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