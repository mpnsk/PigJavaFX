package pig;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;


public class View implements PigMvp.View {
    @FXML
    private Label labelStake, labelWhoseTurn, labelRoll, labelPlayer1, labelPlayer2, labelPlayer1Score, labelPlayer2Score;
    private PigMvp.Presenter.forView presenter;

    public View() {
        presenter = new Presenter(this);
    }

    public void injectPresenter(PigMvp.Presenter.forView presenter){
        this.presenter = presenter;
    }

    public View(PigMvp.Presenter.forView presenter) {
        this.presenter = presenter;
    }

    @FXML
    public void roll(ActionEvent event) {
        presenter.viewSaysRoll();
    }

    @FXML
    public void hold(ActionEvent event) {
        presenter.viewSaysHold();
    }

    @Override
    public void displayPlayersTurn(String player) {
        labelWhoseTurn.setText("It's " + player + "'s turn!");
    }

    @Override
    public void displayRollResult(int rolled) {
        labelRoll.setText(Integer.toString(rolled));
    }

    @Override
    public void displayChangedStake(int newStake) {
        labelStake.setText(Integer.toString(newStake));
    }

    //TODO display changed score
}
