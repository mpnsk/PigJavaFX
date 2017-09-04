package pig.logic;

import java.util.Random;

public interface RandomProvider {
    int nextInt(int bound);

    class InjectableRandomProvider extends Random implements RandomProvider {
        @Override
        public int nextInt(int bound) {
            return super.nextInt(bound);
        }
    }
}
