package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

final class ListUtil {

    /**
     * Create and return a List with the following Strings: "This", "will", "be", "tested", "with", "JUnit".
     */
    static List<String> createLinkedList() {
        return new LinkedList<>(List.of("This", "will", "be", "tested", "with", "JUnit"));
    }

    /**
     * Returns the most-often-occurring item in the given list.
     * If there is more than one most-often element, the lowest one is returned.
     * Tip: Ignore the actual implementation of this method. Instead, focus on the input parameter and the return value for your unit test.
     * Example: input [4, 4, 3, 2, 1] returns 4
     * Example: input [4, 3, 3, 2, 2, 1] returns 2
     * Example: input [4, 3, 2, 1] returns 1
     */
    static Integer getMostFrequentElement(List<Integer> integerList) {
        Map<Integer, Long> elementToFrequency = integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return new TreeMap<>(elementToFrequency).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new NoSuchElementException("Provided List was empty!"))
                .getKey();
    }
}
