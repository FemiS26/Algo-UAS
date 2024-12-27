public class Enemy {
    public String name;
    public int hp;
    public int attack;
    public int shield;

    public Enemy(String name,int health,int attack,int shield){
        this.name = name;
        this.hp = health;
        this.attack = attack;
        this.shield = shield;

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
    
    public void printEnemy(Enemy[] Enemys) {
        System.out.printf("- %s (Health: %d, Attack: %d, Shield: %d)", name, hp, attack, shield);
    }
}