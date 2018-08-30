package as2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String string1 = "abcdef";
        String string2 = "aacdfg";

        try {
            verifyOnAnagrams(string1, string2);
        } catch (IllegalLengthOfAnagramException ex) {
            System.out.println("Length of the strings need to be equal");
        }

    }

    public static List<Character> verifyOnAnagrams(String str1, String str2) throws IllegalLengthOfAnagramException {
        if (str1.length() != str2.length())
            throw new IllegalLengthOfAnagramException("Length of the strings is not equal!");
        List<Character> listOfCharacters1 = new ArrayList<>();
        List<Character> listOfCharacters2 = new ArrayList<>();

        createCharList(listOfCharacters1, str1);
        createCharList(listOfCharacters2, str2);

        for (int i = 0; i < listOfCharacters2.size(); i++) {
            listOfCharacters1.remove(listOfCharacters2.get(i));
        }

        if (listOfCharacters1.isEmpty()) {
            System.out.println("Strings are anagrams");
        } else {
            System.out.println(listOfCharacters1);
        }

        return listOfCharacters1;
    }

    public static void createCharList(List<Character> list, String str) {
        for (int i = 0; i < str.length(); i++)
            list.add(str.charAt(i));
    }

}
