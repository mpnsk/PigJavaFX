import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.testfx.api.FxAssert;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import pig.Presenter;
import pig.PresenterImpl;
import pig.View;
import pig.ViewImpl;


import static org.junit.Assert.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasText;

/**
 * Created by mpnsk on 4/17/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainTest extends ApplicationTest {
    @Mock
    private PresenterImpl mockPresenter;
    private View controller;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        controller = new ViewImpl(mockPresenter);
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();

        stage.setScene(new Scene(root, 300, 275));
        stage.setTitle("Hello World Test");
        stage.show();
    }

    @Test
    public void displayPlayersTurnTest() {
        String label = "#whoseTurn";
        verifyThat(label, hasText("Label"));
        String player = "Player 1";
        interact(() -> controller.displayPlayersTurn(player));
        verifyThat(label, hasText("It's " + player + "'s turn!"));
    }

    @Test
    public void displayRollResultTest() {
        String label = "#rollLabel";
        int rolled = 3;
        verifyThat(label, hasText("0"));
        interact(() -> controller.displayRollResult(rolled));
        verifyThat(label, hasText(String.valueOf(rolled)));
    }

    @Test
    public void displayChangedStakeTest() {
        String label = "#stakeLabel";
        int newStake = 42;
        verifyThat(label, hasText("not set yet"));
        interact(() -> controller.displayChangedStake(newStake));
        verifyThat(label, hasText(String.valueOf(newStake)));
    }
}