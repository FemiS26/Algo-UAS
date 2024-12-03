class Character {
    private String name;
    private int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void displayStatus() {
        System.out.println(name + " has " + health + " health remaining.");
    }
}

class Attack {
    private String attackName;
    private int damage;

    public Attack(String attackName, int damage) {
        this.attackName = attackName;
        this.damage = damage;
    }

    public String getAttackName() {
        return attackName;
    }

    public int getDamage() {
        return damage;
    }

    public void executeAttack(Character target) {
        System.out.println("Using " + attackName + " for " + damage + " damage!");
        int newHealth = target.getHealth() - damage;
        target.setHealth(Math.max(newHealth, 0)); // Ensure health doesn't go below 0
    }
}

public class Stats {
    public static void main(String[] args) {
        Character hero = new Character("Hero", 100);
        Character monster = new Character("Monster", 80);

        Attack fireball = new Attack("Fireball", 30);

        System.out.println("Battle Start!");
        hero.displayStatus();
        monster.displayStatus();

        System.out.println("\nHero attacks Monster!");
        fireball.executeAttack(monster);

        monster.displayStatus();
    }
}
