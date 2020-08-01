import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FizzBuzzTest {

    @Test
    public void retrunZero() {
        String result = Fizzbuzz.parse(0);
       assertThat(result).isEqualTo("0");
    }

    @Test
    public void retrunOne() {
        String result = Fizzbuzz.parse(1);
        assertThat(result).isEqualTo("1");
    }

    @Test
    public void retrunThree(){
        String result = Fizzbuzz.parse(3);
        assertThat(result).isEqualTo("Fizz");
    }

    @Test
    public void retrunFive(){
        String result = Fizzbuzz.parse(5);
        assertThat(result).isEqualTo("Buzz");
    }

    @Test
    public void returnDivisibleByThree(){
        String result = Fizzbuzz.parse(6);
        assertThat(result).isEqualTo("Fizz");
    }
    @Test
    public void returnDivisibleByFive(){
        String result = Fizzbuzz.parse(10);
        assertThat(result).isEqualTo("Buzz");
    }
    @Test
    public void returnDivisibleByThreeAndFive(){
        String result = Fizzbuzz.parse(15);
        assertThat(result).isEqualTo("FizzBuzz");
    }

}
