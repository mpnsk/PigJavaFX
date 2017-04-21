package pig;

public interface View {
    void displayPlayersTurn(String player);
    void displayRollResult(int rolled);
    void displayChangedStake(int newStake);
}