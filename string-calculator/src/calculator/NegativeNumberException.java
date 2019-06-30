package calculator;

import java.util.ArrayList;

public class NegativeNumberException extends Exception {
    ArrayList<Integer> invalidNumbers;
    public NegativeNumberException(ArrayList<Integer> i){
        this.invalidNumbers = i;
    }

    public String toString() {
        String message = "NegativeNumberException[";
        for(Integer each : invalidNumbers){
            message += each.toString();
        }
        message += "]";
        return message;
    }
}
