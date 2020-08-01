import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BowlingTest {

    // https://codingdojo.org/kata/Bowling/

    /**
     *
     * Create a program, which, given a valid sequence of rolls for one line of American Ten-Pin Bowling, produces the total score for the game. Here are some things that the program will not do:
     *
     * We will not check for valid rolls.
     * We will not check for correct number of rolls and frames.
     * We will not provide scores for intermediate frames.
     * Depending on the application, this might or might not be a valid way to define a complete story,
     * but we do it here for purposes of keeping the kata light. I think you’ll see that improvements
     * like those above would go in readily if they were needed for real.
     *
     * We can briefly summarize the scoring for this form of bowling:
     *
     * Each game, or “line” of bowling, includes ten turns, or “frames” for the bowler.
     * In each frame, the bowler gets up to two tries to knock down all the pins.
     * If in two tries, he fails to knock them all down, his score for that frame is the total number
     * of pins knocked down in his two tries.
     * If in two tries he knocks them all down, this is called a “spare”
     * and his score for the frame is ten plus the number of pins knocked down on his next throw
     * (in his next turn).
     * If on his first try in the frame he knocks down all the pins, this is called a “strike”.
     * His turn is over, and his score for the frame is ten plus the simple total of the pins knocked
     * down in his next two rolls.
     * If he gets a spare or strike in the last (tenth) frame, the bowler gets to throw one or two
     * more bonus balls, respectively. These bonus throws are taken as part of the same turn.
     * If the bonus throws knock down all the pins, the process does not repeat: the bonus throws
     * are only used to calculate the score of the final frame.
     * The game score is the total of all frame scores.
     *
     * 10 Frames
     *   score = total of 2 rolls
     *
     * Spare: 10 pins knocked down on two rolls
     *   score = total of 2 rolls + previous roll
     *
     * Strike: 10 pins knocked down on first roll
     *   score = total of 2 rolls + previous two rolls
     *
     *
     *  SPARE GAME: 150 points
     *   1          2           3           4
     *   5,5        5,5         5,5         5,5
     *   15         30          45          60
     *
     *   Strike Game:
     *   1          2           3           4
     *   10,        10,         10          0
     *   30         50          60          60
     *
     *  GAME:
     *   1          2           3           4           5
     *   10         5,5         X           5,5         0
     *   20         40          60          70
     */

    private Bowling bowling;

    @Before
    public void before() {
        bowling = new Bowling();
    }

    @Test
    public void GutterGame() {
        for(int i = 1; i <= 20; i++)
        bowling.roll(0);

        assertThat(bowling.score()).isEqualTo(0);
    }

    @Test
    public void RollAllOnes() {
        for (int i = 1; i <= 20; i++)
            bowling.roll(1);

        assertThat(bowling.score()).isEqualTo(20);
    }

    @Test
    public void RollAllFives() {
        for (int i = 1; i <= 21; i++)
            bowling.roll(5);

        assertThat(bowling.score()).isEqualTo(150);
    }

    @Test
    public void RollSpareGame() {
        bowling.roll(3);
        bowling.roll(7);
        bowling.roll(3);
        for (int i = 1; i <= 17; i++) {
            bowling.roll(0);
        }

        assertThat(bowling.score()).isEqualTo(16);
    }

    @Test
    public void RollStrikeGame() {
        bowling.roll(10);
        bowling.roll(10);
        bowling.roll(10);
        for (int i = 1; i <= 14; i++) {
            bowling.roll(0);
        }

        assertThat(bowling.score()).isEqualTo(60);
    }

    /*
     *  GAME:
     *   1          2           3           4           5
     *   10         5,5         X           5,5         0
     *   20         40          60          70
     */
    @Test
    public void strikesAndSpares() {
        bowling.roll(10);
        bowling.roll(5);
        bowling.roll(5);
        bowling.roll(10);
        bowling.roll(5);
        bowling.roll(5);
        for (int i = 1; i <= 12; i++) {
            bowling.roll(0);
        }

        assertThat(bowling.score()).isEqualTo(70);
    }

    /*
     *  GAME:
     *   1          2           3           4           5
     *   0,10       4,5         X           0,10        5,0
     *   14         23          43          58          63
     */

    @Test
    public void roll10PointSpare() {
        bowling.roll(0);
        bowling.roll(10);
        bowling.roll(4);
        bowling.roll(5);
        bowling.roll(10);
        bowling.roll(0);
        bowling.roll(10);
        bowling.roll(5);
        bowling.roll(0);
        for (int i = 1; i <= 10; i++) {
            bowling.roll(0);
        }

        assertThat(bowling.score()).isEqualTo(63);
    }

    @Test
    public void perfectGame() {
        for (int i = 1; i <= 12; i++) {
            bowling.roll(10);
        }

        assertThat(bowling.score()).isEqualTo(300);
    }
}
