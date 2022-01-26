import java.util.Random;
import java.util.Scanner;
public class rockpapersissors {
    static Scanner keyboard = new Scanner(System.in);

    public static void selection_printer(int player, int computer) {
        System.out.println("\n\nSelections");
        switch (player) {
            case 1:
                System.out.println("You: ROCK");
                break;
            case 2:
                System.out.println("You: PAPER");
                break;
            case 3:
                System.out.println("You: SCISSORS");
                break;
        }
        switch (computer) {
            case 1:
                System.out.println("Comp: ROCK");
                break;
            case 2:
                System.out.println("Comp: PAPER");
                break;
            case 3:
                System.out.println("Comp: SCISSORS");
                break;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        
        int wins = 0;
        int losses = 0;
        int ties = 0;

        System.out.println("Enter number of rounds: ");
        int rounds = keyboard.nextInt();
        System.out.printf("Game will play for %d round(s).", rounds);
        int counter = 0;
        while (counter < rounds) {
            counter++;
            int selection = 0;
            System.out.printf("\n------------Round %d------------", counter);
            System.out.println("\nType: \n1 for ROCK\n2 for PAPER\n3 for Scissors");
            selection = keyboard.nextInt();
            int computer_move = random.nextInt(3 - 1 + 1) + 1;

            selection_printer(selection, computer_move);
            if (selection == 1 && computer_move == 2 || selection == 2 && computer_move == 3 || selection == 3 && computer_move == 1){
                losses++;
                System.out.println("Computer wins");
            } else if (selection == 2 && computer_move == 1 || selection == 3 && computer_move == 2 || selection == 1 && computer_move == 3) {
                wins++;
                System.out.println("You win");
            } else {
                ties++;
                System.out.println("Tie");
            }

            System.out.println("\n****STATISTICS****");
            System.out.printf("WINS: %d", wins);
            System.out.printf("\nLOSSES: %d", losses);
            System.out.printf("\nTIES: %d", ties);
            System.out.println("\n\n");
        }

        if (wins > losses) {
            System.out.println("\n\nYOU WIN CONGRATULATIONS");
        } else if (losses > wins) {
            System.out.println("\n\nYou LOSE, better luck next time!");
        } else {
            System.out.println("\n\nTie, better luck next time!");
        }
        keyboard.close();
    }
}