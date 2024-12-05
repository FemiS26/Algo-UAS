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

    public int getAttackPower() {
        return attack;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttackPower(int attackPower) {
        this.attack = attackPower;
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
        return name + " (HP: " + hp + ", Attack Power: " + attack + ")";
    }
    
    public void printKing(King[] Kings) {
        
        for (int i=0; i<Kings.length; i++) {
        if (Kings[i] != null) {
        System.out.printf("- %s (Health: %d, Attack: %d)", name, hp, attack);
        }
        }
    }
}