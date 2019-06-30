package calculator;

public class StringCalculator {
    public int Add(String input) {
        if(input == "")
            return 0;
        else
            return Integer.parseInt(input);
    }
}