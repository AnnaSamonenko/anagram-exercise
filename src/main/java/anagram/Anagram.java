package anagram;

import java.util.*;
import java.util.stream.Collectors;

public class Anagram {

    private Anagram() {
    }

    public static Map<Character, Integer> verifyOnAnagrams(String str1, String str2)
            throws IllegalLengthOfAnagramException {
        if (str1.length() != str2.length())
            throw new IllegalLengthOfAnagramException("Length of the strings is not equal!");
        Map<Character, Integer> mapOfCharactersFromString1 = new HashMap<>();
        Map<Character, Integer> mapOfCharactersFromString2 = new HashMap<>();

        createCharMap(mapOfCharactersFromString1, str1);
        createCharMap(mapOfCharactersFromString2, str2);

        Set<Character> setOfKeys = mapOfCharactersFromString1.keySet();
        for (Character ch : setOfKeys) {
            Integer amountOfCharsInString1 = mapOfCharactersFromString1.get(ch);
            Integer amountOfCharsInString2 = mapOfCharactersFromString2.get(ch);
            if (amountOfCharsInString2 != null)
                mapOfCharactersFromString1.put(ch, amountOfCharsInString1 - amountOfCharsInString2);
        }

        Map<Character, Integer> result = mapOfCharactersFromString1.entrySet().stream()
                .filter(x -> x.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if (result.isEmpty())
            System.out.println("Strings are anagrams");
        else {
            System.out.println(result);
        }
        return result;
    }

    private static void createCharMap(Map<Character, Integer> map, String str) {
        for (int i = 0; i < str.length(); i++) {
            Integer value = map.get(str.charAt(i));
            if (value == null) {
                map.put(str.charAt(i), 1);
            } else {
                value++;
                map.put(str.charAt(i), value);
            }
        }
    }
}
