package pig.model;

import java.util.Random;

public class RandomProviderImpl extends Random implements RandomProvider {
    @Override
    public int nextInt(int bound) {
        return super.nextInt(bound);
    }
}
