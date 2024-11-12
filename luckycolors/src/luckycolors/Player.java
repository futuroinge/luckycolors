package luckycolors;

public class Player {

    private String name;
    private int level;
    private int score;

    public Player(int level, String name, int score) {
        this.name = name;
        this.score = score;
        this.level = level;
    }
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + "," + score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    
     public int getLevel() {
        return level;
    }
}
