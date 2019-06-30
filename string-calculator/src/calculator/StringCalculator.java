package calculator;

public class StringCalculator {
    public int Add(String input) {
        if(input == "")
            return 0;
        else if(input.contains(",")) {
            String[] nums = input.split(",");
            int sum = 0;
            for(String num : nums) {
                sum += Integer.parseInt(num);
            }
            return sum;
        }
        else
            return Integer.parseInt(input);
    }
}