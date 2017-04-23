package pig.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import pig.presenter.Presenter;
import pig.presenter.PresenterImpl;


public class ViewImpl implements View {
    @FXML
    private Button rollBtn;
    @FXML
     Button holdBtn;
    @FXML
    private Label stakeLabel, whoseTurn, rollLabel;
    private final Presenter.View presenter;

    public ViewImpl() {
        presenter = new PresenterImpl(this);
    }

    public ViewImpl(Presenter.View presenter) {
        this.presenter = presenter;
    }

    @FXML
    public void roll(ActionEvent event) {
        presenter.playerRolls();
    }

    @FXML
    public void hold(ActionEvent event) {
        presenter.playerHolds();
    }

    @Override
    public void displayPlayersTurn(String player) {
        whoseTurn.setText("It's " + player + "'s turn!");
    }

    @Override
    public void displayRollResult(int rolled) {
        rollLabel.setText(Integer.toString(rolled));
    }

    @Override
    public void displayChangedStake(int newStake) {
        stakeLabel.setText(Integer.toString(newStake));
    }
}
