package pig.model;

class Player {
    private final String name;
    private int score;

    Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void incrementScoreBy(int value) {
        score += value;
    }
}
