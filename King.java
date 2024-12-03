import java.util.*;
public class King {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<King> kingsList = new ArrayList<>();
    private String name;
        private int hp;
        private int attackPower;
        private String skills;

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

        public void setAttackPower(int attackPower) {
            this.attackPower = attackPower;
        }

        public void takeDamage(int damage) {
            hp -= damage;
            if (hp < 0) hp = 0;
        }

        public boolean isDefeated() {
            return hp <= 0;
        }

        @Override
        public String toString() {
            return name + " (HP: " + hp + ", Attack Power: " + attackPower + ")";
        }

        

        public static void createKings() {
            System.out.print("Enter name: ");
            String name = scan.next();
            System.out.print("Enter HP: ");
            int hp = scan.nextInt();
            System.out.print("Enter Attack Power: ");
            int attackPower = scan.nextInt();
    
            King newKings = new King(name, hp, attackPower);
            kingsList.add(newKings);
            System.out.println("Kings created successfully.");
        }


        public static void updateKings() {
            System.out.print("Enter the index of the Kings to update: ");
            int index = scan.nextInt();
    
            if (index >= 0 && index < kingsList.size()) {
                King King = kingsList.get(index);
                System.out.print("Enter new HP for " + King.getName() + ": ");
                int newHp = scan.nextInt();
                System.out.print("Enter new Attack Power for " + King.getName() + ": ");
                int newAttackPower = scan.nextInt();
    
                King.setHp(newHp);
                King.setAttackPower(newAttackPower);
                System.out.println("Kings updated successfully.");
            } else {
                System.out.println("Invalid index.");
            }
        }

        public static void deleteKings() {
            System.out.print("Enter the index of the Kings to delete: ");
            int index = scan.nextInt();
    
            if (index >= 0 && index < kingsList.size()) {
                kingsList.remove(index);
                System.out.println("Kings deleted successfully.");
            } else {
                System.out.println("Invalid index.");
            }
        }
    
        public static void viewAllKings() {
            if (kingsList.isEmpty()) {
                System.out.println("No Kings available.");
            } else {
                System.out.println("\n--- List of Kings ---");
                for (int i = 0; i < kingsList.size(); i++) {
                    System.out.println(i + ". " + kingsList.get(i));
                }
            }
        }

        public static void startBattle() {
            if (kingsList.size() < 2) {
                System.out.println("Need at least 2 kings to start a battle.");
                return;
            }
    
            System.out.print("Enter the index of the first kings to battle: ");
            int index1 = scan.nextInt();
            System.out.print("Enter the index of the second kings to battle: ");
            int index2 = scan.nextInt();
    
            if (index1 >= 0 && index1 < kingsList.size() && index2 >= 0 && index2 < kingsList.size() && index1 != index2) {
                King king1 = kingsList.get(index1);
                King king2 = kingsList.get(index2);
    
                System.out.println("\nStarting battle between " + king1.getName() + " and " + king2.getName() + "!");
                while (!king1.isDefeated() && !king2.isDefeated()) {
                    king1.takeDamage(king2.getAttackPower());
                    System.out.println(king2.getName() + " attacks " + king1.getName() + "! " + king1.getName() + " HP: " + king1.getHp());
    
                    if (king1.isDefeated()) {
                        System.out.println(king1.getName() + " has been defeated! " + king2.getName() + " wins!");
                        break;
                    }
    
                    king2.takeDamage(king1.getAttackPower());
                    System.out.println(king1.getName() + " attacks " + king2.getName() + "! " + king2.getName() + " HP: " + king2.getHp());
    
                    if (king2.isDefeated()) {
                        System.out.println(king2.getName() + " has been defeated! " + king1.getName() + " wins!");
                        break;
                    }
                }
            } else {
                System.out.println("Invalid indices for battle.");
            }
        }
    

}
