package pig.presenter;

import pig.model.Model;
import pig.model.ModelImpl;
import pig.view.View;

/**
 * Created by mpnsk on 4/17/2017.
 */
public class PresenterImpl implements Presenter.View, Presenter.Model {

    private final View view;
    private final Model model;

    public PresenterImpl(View view) {
        this.view = view;
        model = new ModelImpl(this);
    }

    @Override
    public void playerRolls() {
        int roll = model.roll();
        view.displayRollResult(roll);
    }

    @Override
    public void playerHolds() {
        model.hold();
    }

    @Override
    public void newTurnFor(String player) {
        view.displayPlayersTurn(player);
    }

    @Override
    public void changedStakeTo(int stake) {
        view.displayChangedStake(stake);
    }
}
