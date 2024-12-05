import java.util.Scanner;

public class Main2 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        King[] Kings = createKings();
        BattleManager battleManager = new BattleManager(Kings);
        int choice;
        String nameSearch;
        stack KingStack = new stack(10);
        
        do {
            System.out.println("\n===== King Management System =====");
            System.out.println("""
                    1. Create King
                    2. View All Kings
                    3. Update Kings
                    4. Delete Kings
                    5. Battle Kings (PVP)
                    6. Battle with Monsters
                    7. View Defeat / Deleted King
                    0. Exit Game""");
            System.out.print("Choose an Option: ");
            choice = scan.nextInt();

            switch(choice) {
                case 1:
                System.out.print("Insert King Name: ");
                String name = scan.next();
                
                System.out.print("Insert HP of King: ");
                int hp = scan.nextInt();
                
                if (hp > 100) {
                    System.out.println("Max HP is 100");
                } else {
                System.out.print("Insert Attack of King: ");
                int attack = scan.nextInt();
                if (attack > 20) {
                    System.out.println("Max Attack is 20");
                } else {
                King newKing = new King(name, hp, attack);
                Kings = addKing(Kings, newKing);
                }
                }
                break;

                case 2:
                System.out.println("===== List of Kings =====");
                bubbleSort(Kings);
                printKings(Kings);
                break;

                case 3:
                System.out.println("Enter the Name Of King: ");
                nameSearch = scan.next();
                Kings = updateKing(Kings, nameSearch);
                break;

                case 4:
                System.out.print("Enter the Name of King: ");
                nameSearch = scan.next();
                Kings = deleteKing(Kings, nameSearch, KingStack);
                break;

                case 5:
                System.out.print("Enter the index of the first Kings to battle: ");
                    int index1 = scan.nextInt();
                    System.out.print("Enter the index of the second Kings to battle: ");
                    int index2 = scan.nextInt();
                    battleManager.startBattle(index1, index2, KingStack);
                break;
                

                case 6:
                KingStack.printStack(Kings);

                break;

                case 0:
                System.out.println("Exiting the program...");
                System.exit(0);
                break;

                default:
                System.out.println("Choose an Option from Above!");
                break;
            }
        } while(choice != 7);
    }

    // Create King
    public static King[] createKings() {
        King[] Kings = new King[30];

        for (int i=0; i < Kings.length; i++) {
            Kings[i] = null;
        }
        

        Kings[0] = new King("Boss", 1000, 20);

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
    // End of Create King


    // Print King All
    public static void printKings(King[] Kings) {
        for (int i=0; i<Kings.length; i++) {
        if (Kings[i] == null) {
            System.out.println("No King Available!");
        } else {
        for (i=0; i<Kings.length; i++) {
            if (Kings[i] != null) {
            Kings[i].printKing(Kings);
            System.out.println();
            } 
        }
    }
        }
    }
    // End of Print All King
    
    
    // Update King
    public static King[] updateKing(King[] Kings, String nameSearch) {
        for (int i=0; i<Kings.length; i++) {
            if(Kings[i] != null && Kings[i].name.equals(nameSearch)) {
                System.out.print("Enter New HP: ");
                int newHP = scan.nextInt();
                System.out.print("Enter New Attack: ");
                int newAttack = scan.nextInt();

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


    // Delete King
    public static King[] deleteKing(King[] Kings, String nameSearch, stack KingStack) {
        for (int i=0; i<Kings.length; i++) {
            if(Kings[i] != null && Kings[i].name.equals(nameSearch)) {
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

    

}
