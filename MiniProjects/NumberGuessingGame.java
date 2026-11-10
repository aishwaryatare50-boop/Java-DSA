package MiniProjects;

// We will create a game that creates a random number and asks user to guess it until user is correct or wants to quit game.

import java.util.*;

public class NumberGuessingGame {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.println("!================*****GUESS NUMBER*****================!\n\n\n");

        
        System.out.println("Level-1 : Easy  \nSingle digit number \n\nLevel-2 : Medium \nTwo digit number \n\nLevel-3 : Hard \nThree digit number \n\nLevel-4 : Impossible \nFour digit number\n\n");

        int random = 0, level = 0, guess = 0;
        while(level != 1 && level != 2 && level !=3 && level !=4) {
            System.out.print("Enter Level : ");
            level = sc.nextInt();
            switch(level) {
            case 1:
            random = (int)(Math.random()*10);
            System.out.println("\nLEVEL-1 \nSTART : \n");
            break;
            case 2: 
            random = 10 + (int)(Math.random()*90);
            System.out.println("\nLEVEL-2 \nSTART : \n");
            break;
            case 3: 
            random = 100 + (int)(Math.random()*900);
            System.out.println("\nLEVEL-3 \nSTART : \n");
            break;
            case 4: 
            random = 1000 + (int)(Math.random()*9000);
            System.out.println("\nLEVEL-4 \nSTART : \n");
            break;
            default:
            System.out.println("Enter valid level !");   
            }
        }

        System.out.println("**********RULES**********\n\nRule - 1 : Entered number should be a positive integer.\nRule - 2 : Fractions should be avoided.\nRule - 3 : Guess should be entered according to level.\n");

        
        do {
            while(true) {
                System.out.print("Enter your guess : ");
                guess = sc.nextInt();
                if(guess >= Math.pow(10, level) || guess < Math.pow(10, level-1)) {
                System.out.println("Enter guess according to your level !");
                } else {
                    break;
                }
            }

            if(guess == random) {
                System.out.println("Congratulations ! \nYOU WIN");
                break;
            } else {
                System.out.println("SORRY YOU LOSE ! Better luck next time");
                if(guess > random) {
                    System.out.println("Too high ! Try again\n");
                } else {
                    System.out.println("Too low. Try again.\n");
                }
            }

            System.out.println("Do you want to Quit ?\nYes - 1\nNo - 0");
            int ch = sc.nextInt();

            if(ch == 1) {
                break;
            } else if(ch == 0) {
                continue;
            } else {
                System.out.println("Enter valid choice.");
            }

        } while(true);
        
        System.out.println("==================Thanks for playing==================");
        
    }
}
