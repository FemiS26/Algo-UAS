import java.util.Scanner;

public class Main2{

    public static class King {
        private String name;
        private int hp;
        private int attackPower;

        public King(String name, int hp, int attackPower) {
            this.name = name;
            this.hp = hp;
            this.attackPower = attackPower;
        }

        public String getName() {
            return name;
        }

        public int getHp() {
            return hp;
        }

        public int getAttackPower() {
            return attackPower;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public void takeDamage(int damage) {
            this.hp -= damage;
            if (hp < 0) hp = 0;
        }

        @Override
        public String toString() {
            return name + " (HP: " + hp + ", Attack Power: " + attackPower + ")";
        }
    }

    private static King[] kingsArray = new King[100];
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

        scanner.close();
    }


    public static void createKing() {
        if (kingCount >= kingsArray.length) {
            System.out.println("No space left to create new kings.");
            return;
        }

        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter HP: ");
        int hp = scanner.nextInt();
        System.out.print("Enter Attack Power: ");
        int attackPower = scanner.nextInt();

        kingsArray[kingCount++] = new King(name, hp, attackPower);
        System.out.println("King created successfully.");
    }


    public static void updateKing() {
        System.out.print("Enter the index of the king to update: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < kingCount) {
            King king = kingsArray[index];
            System.out.print("Enter new HP for " + king.getName() + ": ");
            int newHp = scanner.nextInt();
            System.out.print("Enter new Attack Power for " + king.getName() + ": ");
            int newAttackPower = scanner.nextInt();

            king.setHp(newHp);
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
                System.out.println(i + ". " + kingsArray[i]);
            }
        }
    }


    public static void sortKingsByAttackPower() {
        for (int i = 0; i < kingCount - 1; i++) {
            for (int j = 0; j < kingCount - i - 1; j++) {
                if (kingsArray[j].getAttackPower() < kingsArray[j + 1].getAttackPower()) {

                    King temp = kingsArray[j];
                    kingsArray[j] = kingsArray[j + 1];
                    kingsArray[j + 1] = temp;
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
            King king1 = kingsArray[index1];
            King king2 = kingsArray[index2];

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
