package the.game.it;

import gameplay.GameSymulator;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;


public class GameSymulatorTest {

    GameSymulator symulator = new GameSymulator();

    @Test
    public void getAverageForPlentyIterations_returns_expected_value() {
        int avg = symulator.getAverageForPlentyIterations();
        assertThat(avg == 73);
        System.out.println("This is average of 10.000.000 iterations of the game " + avg);
    }
}
