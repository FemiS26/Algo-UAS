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
    

    

}
