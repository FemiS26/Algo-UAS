public class Arena {
    private String name;
    private int arenaEffect;

    Arena(String name, int arenaEffect) {
        this.name = name;
        this.arenaEffect = arenaEffect;
    }

    public String getName() {
        return name;
    }

    public int getEffect() {
        return arenaEffect;
    }
}
