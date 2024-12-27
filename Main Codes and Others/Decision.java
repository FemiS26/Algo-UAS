import java.util.Scanner;

public class Decision {

    public static void main(String[] args) {
        // Initialize variables
        int userHP = 600;
        int enemyHP = 1000;
        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (userHP > 0 && enemyHP > 0) {
            // Display current health status
            System.out.println("\nYour HP: " + userHP + " | Enemy HP: " + enemyHP);
            System.out.println("Choose an action: ");
            System.out.println("1. Heal (+500 HP)");
            System.out.println("2. Attack (-200 Enemy HP, -400 Your HP)");

            // Get user input
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Heal: +500 HP, no attack from enemy
                userHP += 500;
                System.out.println("You healed yourself. Your HP is now: " + userHP);
            } else if (choice == 2) {
                // Attack: -200 enemy HP, -400 user HP
                enemyHP -= 200;
                userHP -= 400;
                System.out.println("You attacked the enemy. Enemy HP is now: " + enemyHP);
                System.out.println("The enemy counter-attacks! Your HP is now: " + userHP);
            } else {
                // Invalid input handling
                System.out.println("Invalid choice. Please choose again.");
                continue;
            }

            // Check if the user or enemy has won
            if (userHP <= 0) {
                System.out.println("\nYou have been defeated! Game Over.");
            } else if (enemyHP <= 0) {
                System.out.println("\nCongratulations! You defeated the enemy!");
            }
        }

        // Close scanner resource
        scanner.close();
    }
}

    

