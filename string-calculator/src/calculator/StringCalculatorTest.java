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
    @Test
    public void testStringWithMoreThanTwoNumbers() {
        StringCalculator t = new StringCalculator();
        Assert.assertEquals(55, t.Add("40,2,1,2,10"));
    }
    @Test
    public void testStringWithTwoDiffrentDelimiters() {
        StringCalculator t = new StringCalculator();
        Assert.assertEquals(55, t.Add("40,2\n1,2\n10"));
    }
    @Test
    public void testStringWithNewlineAsDelimiter() {
        StringCalculator t = new StringCalculator();
        Assert.assertEquals(55, t.Add("40\n2\n1\n2\n10"));
    }
    @Test
    public void testStringWithAdditionalDelimiter() {
        StringCalculator t = new StringCalculator();
        String test = "\\xx\n40xx2xx3";
        System.out.println(test.length());
        Assert.assertEquals(45, t.Add(test));
    }
}