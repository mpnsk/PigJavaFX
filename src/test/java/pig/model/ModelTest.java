package pig.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pig.presenter.Presenter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@RunWith(MockitoJUnitRunner.class)
public class ModelTest {
    @Mock
    Presenter.Model presenter;
    @Mock
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
        Mockito.when(randomProvider.nextInt(6)).thenReturn(6);
        assertThat(model.roll(), is(6));
    }

    @Test
    public void hold() throws Exception {
    }

}