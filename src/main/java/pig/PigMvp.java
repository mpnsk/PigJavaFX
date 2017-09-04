package pig;

public interface PigMvp {
    interface Model {
        int roll();
        void hold();
    }

    interface View {
        void displayPlayersTurn(String player);
        void displayRollResult(int rolled);
        void displayChangedStake(int newStake);
    }

    interface Presenter {
        interface forView {
            void viewSaysRoll();
            void viewSaysHold();
        }
        interface forModel {
            void modelSaysNewTurnFor(String player);
            void modelSaysStakeChangeTo(int stake);
        }
    }
}
