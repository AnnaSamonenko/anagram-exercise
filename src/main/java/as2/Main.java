package as2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String string1 = "elvis";
        String string2 = "lives";

        try {
            verifyOnAnagrams(string1, string2);
        } catch (IllegalLengthOfAnagramException ex) {
            System.out.println("Length of the strings need to be equal");
        }
    }

    public static void verifyOnAnagrams(String str1, String str2) throws IllegalLengthOfAnagramException {
        if (str1.length() != str2.length())
            throw new IllegalLengthOfAnagramException("Length of the strings is not equal!");
        List<Character> listOfCharacters1 = new ArrayList<>();
        List<Character> listOfCharacters2 = new ArrayList<>();

        createCharList(listOfCharacters1, str1);
        createCharList(listOfCharacters2, str2);

        listOfCharacters1.removeAll(listOfCharacters2);

        if (listOfCharacters1.isEmpty())
            System.out.println("Strings are anagrams");
        else
            System.out.println(listOfCharacters1);
    }

    public static void createCharList(List<Character> list, String str) {
        for (int i = 0; i < str.length(); i++)
            list.add(str.charAt(i));
    }

}
