package pig;

/**
 * Created by mpnsk on 4/17/2017.
 */
public class ModelImpl implements Model {

    private final Presenter.Model presenter;

    public ModelImpl(Presenter.Model presenter) {
        this.presenter = presenter;
    }

    @Override
    public int roll() {
        return 0;
    }

    @Override
    public int hold() {
        return 0;
    }
}
