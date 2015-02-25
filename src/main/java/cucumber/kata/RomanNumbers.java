package cucumber.kata;

/**
 * Created by Shane Hayes on 12/01/14.
 */
public class RomanNumbers {
    private static final int LOWER_NUMERAL_LIMIT = 1;
    private static final int UPPER_NUMERAL_LIMIT = 3999;

    public static long toArabic(String aRomanNumber)throws IllegalArgumentException {
        int arabic = 0;
        String romanName;
        for (RomanNumeral currentRomanNumber : RomanNumeral.values()) {
            romanName = currentRomanNumber.getName();
            while (aRomanNumber.startsWith(romanName)) {
                arabic += currentRomanNumber.getArabic();
                aRomanNumber = aRomanNumber.substring(romanName.length());
            }
        }
        if (aRomanNumber.length() > 0) {
            throw new IllegalArgumentException("Invalid Digit " + aRomanNumber);
        }
        return arabic;
    }
    public static String toRoman(int arabic) {
        if (arabic < LOWER_NUMERAL_LIMIT || arabic > UPPER_NUMERAL_LIMIT) {
            throw new IllegalArgumentException(String.format("Only numbers between %s and %s is supported.", LOWER_NUMERAL_LIMIT, UPPER_NUMERAL_LIMIT));
        }
        StringBuilder result = new StringBuilder();
        for (RomanNumeral numeral : RomanNumeral.values()) {
            while (arabic >= numeral.getArabic()) {
                arabic -= numeral.getArabic();
                result.append(numeral.name());
            }
        }

        return result.toString();
    }


}
