package pig.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pig.presenter.Presenter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ModelImplTest {
    @Mock
    private
    Presenter.Model presenter;
    @Mock
    private
    RandomProvider randomProvider;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void rollRandomRangeTest() throws Exception {
        Model model = new ModelImpl(presenter);
        for (int i = 0; i < 500; i++) {
            assertThat(model.roll(), is(greaterThanOrEqualTo(0)));
            assertThat(model.roll(), is(lessThan(7)));
        }
    }

    @Test
    public void rollMockedTest() throws Exception {
        Model model = new ModelImpl(presenter);
        ((ModelImpl) model).setRandomProvider(randomProvider);
        when(randomProvider.nextInt(6)).thenReturn(6);
        assertThat(model.roll(), is(6));
    }

    @Test
    public void rollZeroCallsChangePlayerHookTest() throws Exception {
        Model model = new ModelImpl(presenter);
        ((ModelImpl) model).setRandomProvider(randomProvider);
        when(randomProvider.nextInt(6)).thenReturn(0);
        model.roll();
        verify(presenter).newTurnFor("Player 2");
    }

    @Test
    public void rollZeroCallsChangePlayerHookMultipleTimesTest() throws Exception {
        Model model = new ModelImpl(presenter);
        ((ModelImpl) model).setRandomProvider(randomProvider);
        when(randomProvider.nextInt(6)).thenReturn(0);
        model.roll();
        verify(presenter, times(1)).newTurnFor("Player 2");
        model.roll();
        verify(presenter, times(1)).newTurnFor("Player 1");
        model.roll();
        verify(presenter, times(2)).newTurnFor("Player 2");
        model.roll();
        verify(presenter, times(2)).newTurnFor("Player 1");
    }

    @Test
    public void hold() throws Exception {
    }

}