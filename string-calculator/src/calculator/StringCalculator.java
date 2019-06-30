package calculator;

import java.util.ArrayList;

public class StringCalculator {
    public int Add(String input) throws NegativeNumberException {
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
        ArrayList<Integer> negatives = new ArrayList<Integer>();
        if(input.contains(",") || input.contains("\n") || input.contains(additionalDelimiter)) {
            String[] nums = input.split(",|\\n|"+additionalDelimiter);
            int sum = 0;
            for(String num : nums) {
                Integer x = Integer.parseInt(num);
                if(x < 0)
                    negatives.add(x);
                if(x < 100)
                    sum += x;
            }
            if (negatives.size() > 0)
                throw new NegativeNumberException(negatives);
            return sum;
        }
        else
            return Integer.parseInt(input);
    }
}