package pig.model;

import pig.presenter.Presenter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModelImpl implements Model {

    private final Presenter.Model presenter;
    private Iterator<String> iterator;
    private RandomProvider randomProvider;
    private final List<String> players;

    public ModelImpl(Presenter.Model presenter) {
        this.presenter = presenter;
        randomProvider = new RandomProviderImpl();
        players = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            players.add("Player " + i);
        }
        iterator = players.iterator();
        iterator.next();
    }

    void setRandomProvider(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    @Override
    public int roll() {
        int i = randomProvider.nextInt(6);
        if (i == 0){
            if (!iterator.hasNext()){
                iterator = players.iterator();
            }
            String player = iterator.next();
            presenter.newTurnFor(player);
        }
        return i;
    }

    @Override
    public int hold() {
        return 0;
    }
}
