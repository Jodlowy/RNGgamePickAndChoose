package the.game.it;

import gameplay.GameSymulator;
import mathmodel.GamePredictions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GamePredictionsTest {

    GameSymulator symulator = new GameSymulator();
    GamePredictions predict = new GamePredictions();

    @Test
    public void getAveragePrize_returns_expected_value() {
        double[] predictions = predict.getAveragePrize();
        assertThat(predictions[0] == 72.87500000000091);
        assertThat(predictions[1] == 3.000000000000036);
        System.out.println("This is average gamer's prize for this game " + predictions[0]);
        System.out.println("This is average gamer's prize amount for one game " + predictions[1]);
    }

    @Test
    public void symulation_returns_the_same_value_as_math() {
        double[] predictions = predict.getAveragePrize();
        long predictedAVG = Math.round(predictions[0]);
        int symulatedAVG = symulator.getAverageForPlentyIterations();
        assertThat(predictedAVG == symulatedAVG).isTrue();
    }
}
