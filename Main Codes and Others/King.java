public class King {
    public String name;
    public int hp;
    public int attack;

    public King(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public void KingsManagementSystem(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void printKing() {
        System.out.printf("%s (Health: %d, Attack: %d)", name, hp, attack);
    }
}
