public class Stats {
    private String name;
    private int hp;
    private int attackPower;

    public Stats(String name, int hp, int attackPower){
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHp(){
        return hp;
    }

    public int getAttackPower(){
        return attackPower;
    }

    public void setHP(int hp){
        this.hp = hp;
    }

    public void setAttackPower(int attackPower){
        this.attackPower = attackPower;
    }

    public void takeDamage(int damage){
        hp -= damage;
        if(hp < 0) hp = 0;
    }

    public boolean isDefeated(){
        return hp <= 0;
    }

    @Override
    public String toString(){
        return name + "(HP: " + hp + ", Attack Power: " + attackPower + ")";
    }
}
