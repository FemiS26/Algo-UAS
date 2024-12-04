import java.util.Scanner;

public class Main2{
    private static Stats[] statsArray = new Stats[100];
    private static int kingCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        King[] Kings = createKings();
        BattleManager battleManager = new BattleManager(Kings);
        int choice;
        String nameSearch;
        stack KingStack = new stack(10);
        int KingCount = 0;

        do {
            System.out.println("\n===== King Management System =====");
            System.out.println("""
                    1. Create King
                    2. View All Kings
                    3. Update Kings
                    4. Delete Kings
                    5. Battle Kings
                    6. View Defeat / Deleted King
                    7. Exit Game""");
            System.out.print("Choose an Option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                System.out.print("Insert King Name: ");
                String name = scanner.next();
                System.out.print("Insert HP of King: ");
                int hp = scanner.nextInt();
                System.out.print("Insert Attack of King: ");
                int attack = scanner.nextInt();
                King newKing = new King(name, hp, attack);
                Kings = addKing(Kings, newKing);
                KingCount++;
                    break;
                case 2:
                    bubbleSort(Kings);
                    printKings(Kings, KingCount);
                    break;
                case 3:
                    
                    break;
                case 4:
                System.out.print("Enter the Name of King: ");
                nameSearch = scanner.next();
                Kings = deleteKing(Kings, nameSearch, KingStack);
                KingCount--;
                    break;
                case 5:
                System.out.print("Enter the index of the first Kings to battle: ");
                    int index1 = scanner.nextInt();
                    System.out.print("Enter the index of the second Kings to battle: ");
                    int index2 = scanner.nextInt();
                    battleManager.startBattle(index1, index2, KingStack);
                    break;
                case 6:
                KingStack.printStack();

                break;

                case 7:
                    System.exit(0);
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while(choice != 7);
        }


    public static King[] createKings() {
        King[] Kings = new King[30];
        return Kings;
    }

    public static King[] addKing(King[] Kings, King newKing) {
        for (int i=0; i<Kings.length; i++) {
            if (Kings[i] == null) {
                Kings[i] = newKing;
                System.out.println(newKing.name + " has been added.");
                bubbleSort(Kings);
                return Kings;
            }
        }
        System.out.println("Array is full.");
        return Kings;
    }


    // Update King
    public static King[] updateKing(King[] Kings, String nameSearch) {
        for (int i=0; i<Kings.length; i++) {
            if(Kings[i] != null && Kings[i].name.equals(nameSearch)) {
                System.out.print("Enter New HP: ");
                int newHP = scanner.nextInt();
                System.out.print("Enter New Attack: ");
                int newAttack = scanner.nextInt();

                Kings[i].hp = newHP;
                Kings[i].attack = newAttack;
                System.out.println(Kings[i].name + " updated successfully");

                return Kings;
            }
        }
        System.out.println("Not Found.");
        return Kings;
        
    } 
    // End of Update King


   // Print King All
   public static void printKings(King[] Kings, int KingCount) {
        if (KingCount == 0) {
            System.out.println("No King Available!");
        } else {
        for (int i=0; i<Kings.length; i++) {
            if (Kings[i] != null) {
            Kings[i].printKing();
            System.out.println();
            } 
        }
    }
    }

    // View All Sorting
    static void bubbleSort(King[] Kings) {
        int i, j;
        King tempo;
        for(i=0; i < Kings.length - 1; i++) {
            for(j=0; j < Kings.length - i - 1; j++) {
                if( Kings[j] != null && Kings[j + 1] != null && Kings[j].name.compareTo(Kings[j + 1].name) > 0) {
                    tempo = Kings[j];
                    Kings[j] = Kings[j + 1];
                    Kings[j + 1] = tempo;
                
                }
            }
        }
    }
    // End of Print All King

     // Delete King
     public static King[] deleteKing(King[] Kings, String nameSearch, stack KingStack) {
        for (int i=0; i<Kings.length; i++) {
            if(Kings[i].name.equals(nameSearch)) {
                KingStack.push(Kings[i]);
                Kings[i] = null;
                System.out.println(nameSearch + " has been deleted.");
                return Kings;
            }
        }
        System.out.println(nameSearch + " not found.");
        return Kings;
    }
    // End of Delete King
}
