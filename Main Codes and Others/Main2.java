import java.util.Scanner;

public class Main2{
    private static Stats[] statsArray = new Stats[100];
    private static int kingCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Kings Management System Menu ---");
            System.out.println("1. Create King");
            System.out.println("2. Update King");
            System.out.println("3. View All Kings");
            System.out.println("4. Sort Kings by Attack Power");
            System.out.println("5. Battle Simulation");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createKing();
                    break;
                case 2:
                    updateKing();
                    break;
                case 3:
                    viewAllKings();
                    break;
                case 4:
                    sortKingsByAttackPower();
                    break;
                case 5:
                    battleSimulation();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }


    public static void createKing() {
        if (kingCount >= statsArray.length) {
            System.out.println("No space left to create new kings.");
            return;
        }

        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter HP: ");
        int hp = scanner.nextInt();
        System.out.print("Enter Attack Power: ");
        int attackPower = scanner.nextInt();

        statsArray[kingCount++] = new Stats(name, hp, attackPower);
        System.out.println("King created successfully.");
    }


    public static void updateKing() {
        System.out.print("Enter the index of the king to update: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < kingCount) {
            Stats king = statsArray[index];
            System.out.print("Enter new HP for " + king.getName() + ": ");
            int newHp = scanner.nextInt();
            System.out.print("Enter new Attack Power for " + king.getName() + ": ");
            int newAttackPower = scanner.nextInt();

            king.setHP(newHp);
            king.attackPower = newAttackPower;
            System.out.println("King updated successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }


    public static void viewAllKings() {
        if (kingCount == 0) {
            System.out.println("No kings available.");
        } else {
            System.out.println("\n--- List of Kings ---");
            for (int i = 0; i < kingCount; i++) {
                System.out.println(i + ". " + statsArray[i]);
            }
        }
    }


    public static void sortKingsByAttackPower() {
        for (int i = 0; i < kingCount - 1; i++) {
            for (int j = 0; j < kingCount - i - 1; j++) {
                if (statsArray[j].getAttackPower() < statsArray[j + 1].getAttackPower()) {
                    Stats temp = statsArray[j];
                    statsArray[j] = statsArray[j + 1];
                    statsArray[j + 1] = temp;
                }
            }
        }
        System.out.println("Kings sorted by Attack Power.");
    }


    public static void battleSimulation() {
        if (kingCount < 2) {
            System.out.println("At least two kings are required for a battle.");
            return;
        }

        System.out.print("Enter the index of the first king: ");
        int index1 = scanner.nextInt();
        System.out.print("Enter the index of the second king: ");
        int index2 = scanner.nextInt();

        if (index1 >= 0 && index1 < kingCount && index2 >= 0 && index2 < kingCount && index1 != index2) {
            Stats king1 = statsArray[index1];
            Stats king2 = statsArray[index2];

            System.out.println("\nStarting battle between " + king1.getName() + " and " + king2.getName() + "!");
            while (king1.getHp() > 0 && king2.getHp() > 0) {
                king2.takeDamage(king1.getAttackPower());
                System.out.println(king1.getName() + " attacks " + king2.getName() + "! " + king2.getName() + " HP: " + king2.getHp());

                if (king2.getHp() <= 0) {
                    System.out.println(king2.getName() + " has been defeated! " + king1.getName() + " wins!");
                    break;
                }

                king1.takeDamage(king2.getAttackPower());
                System.out.println(king2.getName() + " attacks " + king1.getName() + "! " + king1.getName() + " HP: " + king1.getHp());

                if (king1.getHp() <= 0) {
                    System.out.println(king1.getName() + " has been defeated! " + king2.getName() + " wins!");
                    break;
                }
            }
        } else {
            System.out.println("Invalid indices for battle.");
        }
    }
}
