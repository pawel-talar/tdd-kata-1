package calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
    @Test
    public void testEmptyString() {
        StringCalculator t = new StringCalculator();
        Assert.assertEquals(0, t.Add(""));
    }
    @Test
    public void testStringWithOneNumber() {
        StringCalculator t = new StringCalculator();
        Assert.assertEquals(10, t.Add("10"));
    }
    @Test
    public void testStringWithTwoNumbers() {
        StringCalculator t = new StringCalculator();
        Assert.assertEquals(42, t.Add("40,2"));
    }
}