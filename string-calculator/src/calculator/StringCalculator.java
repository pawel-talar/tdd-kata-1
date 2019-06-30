package calculator;

public class StringCalculator {
    public int Add(String input) {
        if(input == "")
            return 0;
        String additionalDelimiter = ",";
        if(input.charAt(0) == '\\')
        {
            int i;
            additionalDelimiter = "";
            for(i = 1; i < input.length(); i++) {
                if (input.charAt(i) != '\n') {
                    additionalDelimiter += input.charAt(i);
                }
                else
                    break;
            }
            input = input.substring(i+1);
        }
        if(input.contains(",") || input.contains("\n") || input.contains(additionalDelimiter)) {
            String[] nums = input.split(",|\\n|"+additionalDelimiter);
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