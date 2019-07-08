package calculator;

import java.util.ArrayList;

public class StringCalculator {
    public ArrayList<Integer> Parse(String input) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        if(input == "") {
            l.add(0);
            return l;
        }
        String DelimetersRegex = ",|\\n";
        if(input.substring(0, 2).equals("//")) {
            if(input.charAt(2) != '[') {
                DelimetersRegex = DelimetersRegex + '|' + input.charAt(2);
                input = input.substring(4);
            }
            else {
                input = input.substring(2);
                int k = 0;
                while(input.charAt(0) == '[') {
                    k++;
                    int i;
                    String additionalDelimiter = "";
                    for (i = 1; i < input.length(); i++) {
                        if (input.charAt(i) != ']') {
                            additionalDelimiter += input.charAt(i);
                        }
                        else
                            break;
                    }
                    DelimetersRegex = DelimetersRegex + '|' + additionalDelimiter;
                    input = input.substring(i + 1);
                }
                input = input.substring(1);
            }
        }
        String[] nums = input.split(DelimetersRegex);
        for(String num : nums) {
            Integer x = Integer.parseInt(num);
            l.add(x);
        }
        return l;
    }

    public int Add(String input) throws NegativeNumberException {
        ArrayList<Integer> allNumbers = Parse(input);
        ArrayList<Integer> negatives = new ArrayList<Integer>();
        int sum = 0;
        for(Integer num : allNumbers) {
            if(num < 0)
                negatives.add(num);
            if(num < 1000)
                sum += num;
        }
        if(negatives.size() > 0)
            throw new NegativeNumberException(negatives);
        return sum;
    }
}