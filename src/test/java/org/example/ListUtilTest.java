package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ListUtilTest {

    @Test
    void shouldCreateLinkedList_whenCalled() {
        //given
        List<String> expectedResult = List.of("This", "will", "be", "tested", "with", "JUnit");
        //when
        List<String> actualResult = ListUtil.createLinkedList();
        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldThrowException_whenListIsEmpty() {
        //given
        List<Integer> input = List.of();
        Class<NoSuchElementException> expectedResult = NoSuchElementException.class;
        //when & then
        assertThrows(expectedResult, () -> ListUtil.getMostFrequentElement(input));
    }

    @Test
    void shouldReturnLowestElement_whenNoElementIsMoreFrequent() {
        //given
        List<Integer> input = List.of(1, 2, 3, 4);
        Integer expectedResult = 1;
        //when
        Integer actualResult = ListUtil.getMostFrequentElement(input);
        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnLowestMostFrequentElement_whenMultipleElementsHaveEqualFrequency() {
        //given
        List<Integer> input = List.of(1, 1, 2, 3, 3, 4);
        Integer expectedResult = 1;
        //when
        Integer actualResult = ListUtil.getMostFrequentElement(input);
        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnMostFrequentElement_whenOneElementIsMostFrequent() {
        //given
        List<Integer> input = List.of(1, 2, 3, 3, 4);
        Integer expectedResult = 3;
        //when
        Integer actualResult = ListUtil.getMostFrequentElement(input);
        //then
        assertEquals(expectedResult, actualResult);
    }

}