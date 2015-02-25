package cucumber.kata;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by Shane Hayes on 12/01/14.
 */
public class TestRomanNumeralFeature {
    private ConversionEntry aRomanConversion;
    private ConversionEntry aComplexConversion;
    private ConversionEntry anArabicConversion;

    @When("^I ask for a translation of a \"([^\"]*)\"$")
    public void I_ask_for_a_translation_of_a(String romanNumeral) throws Throwable {
        aRomanConversion = new ConversionEntry();
        aRomanConversion.romanNumeral = romanNumeral;
        //no test done, this is setup for the next step
    }

    @Then("^I get the correct \"([^\"]*)\"$")
    public void I_get_the_correct(int anArabicNumber) throws Throwable {
        assertEquals(anArabicNumber, RomanNumbers.toArabic(aRomanConversion.romanNumeral));
    }

    @When("^I ask for a translation of a combination \"([^\"]*)\"$")
    public void I_ask_for_a_translation_of_a_combination(String romanNumeral) throws Throwable {
        aComplexConversion = new ConversionEntry();
        aComplexConversion.setRomanNumeral(romanNumeral);
        //no test done, this is setup for the next step
    }

    @Then("^I get the correct combination translation \"([^\"]*)\"$")
    public void I_get_the_correct_combination_translation(int anArabicNumber) throws Throwable {
        assertEquals(anArabicNumber, RomanNumbers.toArabic(aComplexConversion.romanNumeral));
    }

    @When("^I ask for a Roman translation of a \"([^\"]*)\"$")
    public void I_ask_for_a_Roman_translation_of_a(int anArabicNumber) throws Throwable {
        anArabicConversion = new ConversionEntry();
        anArabicConversion.setArabicNumber(anArabicNumber);
    }

    @Then("^I get the correct Roman Numeral \"([^\"]*)\"$")
    public void I_get_the_correct_Roman_Numeral(String aRomanNumber) throws Throwable {
        assertEquals(aRomanNumber, RomanNumbers.toRoman(anArabicConversion.getArabicNumber()));
    }

    @Then("^I get the invalid numeral error$")
    public void I_get_the_invalid_numeral_error() throws Throwable {
        try {
            RomanNumbers.toArabic(aRomanConversion.romanNumeral);
            fail("Invalid RomanNumeral");
        }
        catch (IllegalArgumentException e) {
            //do nothing here as the exception was expected
        }

    }

    @Then("^I get the invalid arabic error$")
    public void I_get_the_invalid_arabic_error() throws Throwable {
        try {
            RomanNumbers.toRoman(anArabicConversion.getArabicNumber());
            fail("Invalid ArabicNumeral");
        }
        catch (IllegalArgumentException e) {
            //do nothing here as the exception was expected
        }

    }


    public class ConversionEntry {
        String romanNumeral;
        Integer arabicNumber;
        public void setRomanNumeral(String romanNumeral) {
            this.romanNumeral = romanNumeral;
        }
        public void setArabicNumber(int anArabicNumber) {this.arabicNumber = anArabicNumber;}
        public String getRomanNumeral() {
            return romanNumeral;
        }
        public int getArabicNumber() {
            return arabicNumber;
        }

    }

}
