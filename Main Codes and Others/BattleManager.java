import java.util.Random;

public class BattleManager {
    private King[] kings;
    Arena[] Arenas;

    public BattleManager(King[] kings) {
        this.kings = kings;
        this.Arenas = new Arena[5];

        Arenas[0] = new Arena("Castle", +5);
        Arenas[1] = new Arena("Forest", +2);
        Arenas[2] = new Arena("Volcano", -3);
        Arenas[3] = new Arena("Cloud", +5);
        Arenas[4] = new Arena("Ring", +20);
    }

    public void startBattle(int index1, int index2, stack KingStack) {
        if (index1 < 0 || index1 >= kings.length || index2 < 0 || index2 >= kings.length) {
            System.out.println("Invalid indices for battle.");
            return;
        }
        
        Random random = new Random();
        int arenaIndex = random.nextInt(Arenas.length);
        Arena selectedArena = Arenas[arenaIndex];

        System.out.println("Battle in " + selectedArena.name + " Arena! " + selectedArena.attackEffect + " Effects");

        King king1 = kings[index1];
        King king2 = kings[index2];

        int king1Attack = king1.attack + selectedArena.attackEffect;
        int king2Attack = king2.attack + selectedArena.attackEffect;


        if (king1 == null || king2 == null || index1 == index2) {
            System.out.println("Invalid kings for battle.");
            return;
        }

        System.out.println("\nStarting battle between " + king1.getName() + " and " + king2.getName() + "!");
        while (!king1.isDefeated() && !king2.isDefeated()) {
            king1.takeDamage(king2Attack);
            System.out.println(king2.getName() + " attacks " + king1.getName() + "! " + king1.getName() + " HP: " + king1.getHp());

            if (king1.isDefeated()) {
                System.out.println(king1.getName() + " has been defeated! " + king2.getName() + " wins!");
                KingStack.push(king1);
                kings[index1] = null;
                break;
            }

            king2.takeDamage(king1Attack);
            System.out.println(king1.getName() + " attacks " + king2.getName() + "! " + king2.getName() + " HP: " + king2.getHp());

            if (king2.isDefeated()) {
                System.out.println(king2.getName() + " has been defeated! " + king1.getName() + " wins!");
                KingStack.push(king2);
                kings[index2] = null;
                break;
            }
        }
    }
}