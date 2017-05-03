package pig.model;

import pig.presenter.Presenter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModelImpl implements Model {

    private final Presenter.Model presenter;
    private Iterator<Player> iterator;
    private RandomProvider randomProvider;
    private final List<Player> players;
    private Player curentPlayer;
    private int stake;

    public ModelImpl(Presenter.Model presenter) {
        this(presenter, new RandomProviderImpl());
    }

    public ModelImpl(Presenter.Model presenter, RandomProvider randomProvider) {
        this.presenter = presenter;
        this.randomProvider = randomProvider;
        players = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            players.add(new Player("Player " + i));
        }
        iterator = players.iterator();
        curentPlayer = iterator.next();
    }

    @Override
    public int roll() {
        int i = randomProvider.nextInt(6);
        if (i == 0) {
            stake = 0;
            nextPlayersTurn();
        } else {
            stake += i;
        }
        return i;
    }

    @Override
    public void hold() {
        curentPlayer.incrementScoreBy(stake);
        //TODO call view with new score
        stake = 0;
        nextPlayersTurn();
    }

    private void nextPlayersTurn() {
        if (!iterator.hasNext()) {
            iterator = players.iterator();
        }
        curentPlayer = iterator.next();
        presenter.newTurnFor(curentPlayer.getName());
    }
}
