package pig;

/**
 * Created by mpnsk on 4/17/2017.
 */
public class PresenterImpl implements Presenter.View, Presenter.Model {

    public PresenterImpl(View view) {
        Model model = new ModelImpl(this);
    }

    @Override
    public void playerRolls() {

    }

    @Override
    public void playerHolds() {

    }

    @Override
    public void newTurnFor(String player) {

    }

    @Override
    public void changedStakeTo(int stake) {

    }
}
