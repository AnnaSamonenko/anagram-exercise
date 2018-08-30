package as2;

import java.util.*;
import java.util.stream.Collectors;

public class Anagram {

    private Anagram() {
    }

    public static Map<Character, Integer> verifyOnAnagrams(String str1, String str2)
            throws IllegalLengthOfAnagramException {
        if (str1.length() != str2.length())
            throw new IllegalLengthOfAnagramException("Length of the strings is not equal!");
        Map<Character, Integer> mapOfCharacters1 = new HashMap<>();
        Map<Character, Integer> mapOfCharacters2 = new HashMap<>();

        createCharMap(mapOfCharacters1, str1);
        createCharMap(mapOfCharacters2, str2);

        Set<Character> setOfKeys = mapOfCharacters1.keySet();
        for (Character ch : setOfKeys) {
            Integer amountOfCharIn1 = mapOfCharacters1.get(ch);
            Integer amountOfCharIn2 = mapOfCharacters2.get(ch);
            if (amountOfCharIn2 != null)
                mapOfCharacters1.put(ch, amountOfCharIn1 - amountOfCharIn2);
        }

        Map<Character, Integer> result = mapOfCharacters1.entrySet().stream()
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
