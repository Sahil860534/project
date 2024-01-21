import java.util.Scanner;

public class TextAdventureGame {

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        System.out.println("Welcome to the Mysterious Forest Adventure!");
        System.out.println("You find yourself at the entrance of a dark forest.");
        System.out.println("Your objective is to reach the end safely.");

        play();
    }

    public static void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nYou have two paths ahead. Will you go 'left' or 'right'?");
        String choice1 = scanner.nextLine().toLowerCase();

        switch (choice1) {
            case "left":
                leftPath();
                break;
            case "right":
                rightPath();
                break;
            default:
                handleInvalidInput();
                play();
        }
    }

    public static void leftPath() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nYou encounter a river. Do you 'swim' across or 'find a bridge'?");
        String choice2 = scanner.nextLine().toLowerCase();

        switch (choice2) {
            case "swim":
                System.out.println("\nYou bravely swim across the river and continue your journey.");
                System.out.println("You reach the end of the forest. Congratulations, you win!");
                break;
            case "find a bridge":
                System.out.println("\nYou search for a bridge and find one. You cross it safely.");
                System.out.println("You reach the end of the forest. Congratulations, you win!");
                break;
            default:
                handleInvalidInput();
                leftPath();
        }
    }

    public static void rightPath() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nYou find a cave. Do you 'enter' the cave or 'walk around'?");
        String choice3 = scanner.nextLine().toLowerCase();

        switch (choice3) {
            case "enter":
                System.out.println("\nYou enter the cave and find a treasure chest. Congratulations, you win!");
                break;
            case "walk around":
                System.out.println("\nYou decide to walk around the cave. Nothing interesting happens.");
                playAgain();
                break;
            default:
                handleInvalidInput();
                rightPath();
        }
    }

    public static void handleInvalidInput() {
        System.out.println("Invalid input. Please enter a valid choice.");
    }

    public static void playAgain() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDo you want to play again? ('yes' or 'no')");
        String playAgainChoice = scanner.nextLine().toLowerCase();

        if (playAgainChoice.equals("yes")) {
            startGame();
        } else if (playAgainChoice.equals("no")) {
            System.out.println("Thanks for playing! Goodbye.");
            System.exit(0);
        } else {
            handleInvalidInput();
            playAgain();
        }
    }
}
