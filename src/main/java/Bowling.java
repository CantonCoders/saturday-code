import java.util.ArrayList;
import java.util.List;

public class Bowling {

    private List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);

    }

    public int score() {
        int score = 0;
        int rollIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            int roll1 = rolls.get(rollIndex);
            if(roll1 == 10)
            {
                score += (rolls.get(rollIndex));
                score += (rolls.get(rollIndex + 1));
                score += (rolls.get(rollIndex + 2));
            }
            else
            {
                int roll2 = rolls.get(++rollIndex);

                score += roll1 + roll2;
                if (roll1 + roll2 == 10){
                    score += rolls.get(rollIndex + 1);
                }
            }
            rollIndex++;
        }

        return score;
    }
}
