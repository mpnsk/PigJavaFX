package pig;

/**
 * Created by mpnsk on 4/17/2017.
 */
public class Presenter implements PigMvp.Presenter.forView, PigMvp.Presenter.forModel {

    private final PigMvp.View view;
    private final PigMvp.Model model;

    Presenter(PigMvp.View view) {
        this.view = view;
        model = new Model(this);
    }

    @Override
    public void viewSaysRoll() {
        int roll = model.roll();
        view.displayRollResult(roll);
    }

    @Override
    public void viewSaysHold() {
        model.hold();
    }

    @Override
    public void modelSaysNewTurnFor(String player) {
        view.displayPlayersTurn(player);
    }

    @Override
    public void modelSaysStakeChangeTo(int stake) {
        view.displayChangedStake(stake);
    }
}
