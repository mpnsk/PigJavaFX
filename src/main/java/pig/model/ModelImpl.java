package pig.model;

import pig.presenter.Presenter;

public class ModelImpl implements Model {

    private final Presenter.Model presenter;
    private RandomProvider randomProvider;

    public ModelImpl(Presenter.Model presenter) {
        this.presenter = presenter;
        randomProvider = new RandomProviderImpl();
    }

    public void setRandomProvider(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    @Override
    public int roll() {
        return randomProvider.nextInt(6);
    }

    @Override
    public int hold() {
        return 0;
    }
}
