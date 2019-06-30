package calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
    @Test
    public void testEmptyString() {
        StringCalculator t = new StringCalculator();
        try {
            Assert.assertEquals(0, t.Add(""));
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testStringWithOneNumber() {
        StringCalculator t = new StringCalculator();
        try {
            Assert.assertEquals(10, t.Add("10"));
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testStringWithTwoNumbers() {
        StringCalculator t = new StringCalculator();
        try {
            Assert.assertEquals(42, t.Add("40,2"));
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testStringWithMoreThanTwoNumbers() {
        StringCalculator t = new StringCalculator();
        try {
            Assert.assertEquals(55, t.Add("40,2,1,2,10"));
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testStringWithTwoDiffrentDelimiters() {
        StringCalculator t = new StringCalculator();
        try {
            Assert.assertEquals(55, t.Add("40,2\n1,2\n10"));
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testStringWithNewlineAsDelimiter() {
        StringCalculator t = new StringCalculator();
        try {
            Assert.assertEquals(55, t.Add("40\n2\n1\n2\n10"));
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testStringWithAdditionalDelimiter() {
        StringCalculator t = new StringCalculator();
        String test = "\\x\n40x2x3";
        try {
            Assert.assertEquals(45, t.Add(test));
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testThrowingNegativeNumbersException() {
        StringCalculator t = new StringCalculator();
        String test = "\\x\n-1x2x-3";
        try {
            t.Add(test);
        } catch (NegativeNumberException e) {
            Assert.assertEquals("NegativeNumberException[-1-3]", e.toString());
        }
    }
    @Test
    public void testStringWithGreaterOrEqualNumbersThanThousand() {
        StringCalculator t = new StringCalculator();
        try {
            Assert.assertEquals(3, t.Add("1,2,1000"));
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testStringWithNewMulticharDelimeter() {
        StringCalculator t = new StringCalculator();
        String test = "\\[xx]\n40xx2xx3";
        try {
            Assert.assertEquals(45, t.Add(test));
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testStringWithMultipleNewDelimeters() {
        StringCalculator t = new StringCalculator();
        String test = "\\[x][y]\n40x2y3";
        try {
            Assert.assertEquals(45, t.Add(test));
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }
}