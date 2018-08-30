package anagram;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestAnagramClass {

    @Test
    public void testVerifyAnagramMethodPositive() {

        String string1 = "abcdef";
        String string2 = "aacdfg";

        Map<Character, Integer> expectedResult = new HashMap<>();
        Map<Character, Integer> actualResult;
        expectedResult.put('b', 1);
        expectedResult.put('e', 1);

        try {
            actualResult = Anagram.verifyOnAnagrams(string1, string2);
            Assert.assertEquals(expectedResult, actualResult);
        } catch (IllegalLengthOfAnagramException ex) {
            System.out.println("Length of the strings need to be equal");
        }
    }

    @Test(expected = IllegalLengthOfAnagramException.class)
    public void testVerifyAnagramMethodNegative() throws IllegalLengthOfAnagramException {

        String string1 = "abcdef1";
        String string2 = "aacdfg";

        Anagram.verifyOnAnagrams(string1, string2);
    }

}
