import java.util.Scanner;

public class MainMenu {
    private static KingsManager kingsManagers = new KingsManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- King Management System Game Menu ---");
            System.out.println("1. Create Kings");
            System.out.println("2. Update Kings Stats");
            System.out.println("3. Delete Kings Stats");
            System.out.println("4. View All Kings");
            System.out.println("5. Start Battle");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createKings();
                    break;
                case 2:
                    updateKings();
                    break;
                case 3:
                    deleteKings();
                    break;
                case 4:
                    viewAllKings();
                    break;
                case 5:
                    startBattle();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the game.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }

    private static void createKings() {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter HP: ");
        int hp = scanner.nextInt();
        System.out.print("Enter Attack Power: ");
        int attackPower = scanner.nextInt();

        Stats newKing = new Stats(name, hp, attackPower);
        kingsManager.addKing(newKing);
        System.out.println("King created successfully.");
    }

    private static void updateKings() {
        kingsManager.displayKings();
        System.out.print("Enter the index of the king to update: ");
        int index = scanner.nextInt();

        System.out.print("Enter new HP: ");
        int newHp = scanner.nextInt();
        System.out.print("Enter new Attack Power: ");
        int newAttackPower = scanner.nextInt();

        try {
            kingsManager.updateKing(index, newHp, newAttackPower);
            System.out.println("King updated successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteKings() {
        kingsManager.displayKings();
        System.out.print("Enter the index of the king to delete: ");
        int index = scanner.nextInt();

        try {
            kingsManager.deleteKing(index);
            System.out.println("King deleted successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewAllKings() {
        kingsManager.displayKings();
    }

    private static void startBattle() {
        kingsManager.displayKings();
        if (kingsManager.getKingsList().size() < 2) {
            System.out.println("Need at least 2 kings to start a battle.");
            return;
        }

        System.out.print("Enter the index of the first king to battle: ");
        int index1 = scanner.nextInt();
        System.out.print("Enter the index of the second king to battle: ");
        int index2 = scanner.nextInt();

        if (index1 != index2 && index1 >= 0 && index1 < kingsManager.getKingsList().size() && index2 >= 0 && index2 < kingsManager.getKingsList().size()) {
            Battlekings battleManager = new Battlekings();
            battleManager.startBattle(kingsManager.getKingsList().get(index1), kingsManager.getKingsList().get(index2));
        } else {
            System.out.println("Invalid indices for battle.");
        }
    }
}
