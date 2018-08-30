package as2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String string1 = GenerateString.randomString(100000);
        String string2 = GenerateString.randomString(100000);

        try {
            verifyOnAnagrams(string1, string2);
        } catch (IllegalLengthOfAnagramException ex) {
            System.out.println("Length of the strings need to be equal");
        }

        System.out.println((System.nanoTime() - startTime) / 1000000000);
    }

    public static void verifyOnAnagrams(String str1, String str2) throws IllegalLengthOfAnagramException {
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
            if (amountOfCharIn1 != null && amountOfCharIn2 != null)
                mapOfCharacters1.put(ch, amountOfCharIn1 - amountOfCharIn2);
        }

        Map<Character, Integer> collect = mapOfCharacters1.entrySet().stream()
                .filter(x -> x.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if (collect.isEmpty())
            System.out.println("Strings are anagrams");
        else {
            System.out.println(collect);
        }
    }

    public static void createCharMap(Map<Character, Integer> map, String str) {
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
