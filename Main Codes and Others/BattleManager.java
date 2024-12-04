public class BattleManager {
    private King[] kings;

    public BattleManager(King[] kings) {
        this.kings = kings;
    }

    public void startBattle(int index1, int index2) {
        if (index1 < 0 || index1 >= kings.length || index2 < 0 || index2 >= kings.length) {
            System.out.println("Invalid indices for battle.");
            return;
        }

        King king1 = kings[index1];
        King king2 = kings[index2];

        if (king1 == null || king2 == null || index1 == index2) {
            System.out.println("Invalid kings for battle.");
            return;
        }

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
    }
}