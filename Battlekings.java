public class BattleKings {
    public void startBattle(KingsManagementSystem king1, KingsManagementSystem king2) {
        System.out.println("\nStarting battle between " + king1.getName() + " and " + king2.getName() + "!");

        while (!king1.isDefeated() && !king2.isDefeated()) {
            king1.takeDamage(king2.getAttackPower());
            System.out.println(king2.getName() + " attacks " + king1.getName() + "! " + king1.getName() + " HP: " + king1.getHp());

            if (king1.isDefeated()) {
                System.out.println(king1.getName() + " has been defeated! " + king2.getName() + " wins!");
                return;
            }
            king2.takeDamage(king1.getAttackPower());
            System.out.println(king1.getName() + " attacks " + king2.getName() + "! " + king2.getName() + " HP: " + king2.getHp());

            if (king2.isDefeated()) {
                System.out.println(king2.getName() + " has been defeated! " + king1.getName() + " wins!");
                return;
            }
        }
    }
}
