package pig.presenter;

public interface Presenter {
    public interface View {
        void playerRolls();
        void playerHolds();
    }
    public interface Model {
        void newTurnFor(String player);
        void changedStakeTo(int stake);
    }
}
