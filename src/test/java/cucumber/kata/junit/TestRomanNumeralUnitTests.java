package cucumber.kata.junit;

import cucumber.kata.RomanNumbers;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by 212314280 on 3/9/14.
 */
public class TestRomanNumeralUnitTests {
    @Test
    public void testRomanToArabic() {
        assertEquals("1 should be the outcome",1, RomanNumbers.toArabic("I"));
        assertEquals("5 should be the outcome",5, RomanNumbers.toArabic("V"));
        assertEquals("256 should be the outcome",256, RomanNumbers.toArabic("CCLVI"));
    }

    @Test
    public void testArabicToRoman () {
        assertEquals("I should be the outcome", "I", RomanNumbers.toRoman(1));
        assertEquals("V should be the outcome", "V", RomanNumbers.toRoman(5));
    }
    @Test(expected=IllegalArgumentException.class)
    public void testInvalidRomanNumeralB() {
        RomanNumbers.toArabic("B");
    }
    @Test(expected=IllegalArgumentException.class)
    public void testInvalidRomanNumeralOne() {
        RomanNumbers.toRoman(0);
    }


}
