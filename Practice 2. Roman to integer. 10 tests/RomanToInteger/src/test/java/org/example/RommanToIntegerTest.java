package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {

    @Test
    void testEmptyStringThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RomanToInteger.convertToInteger("");
        });
        assertEquals("Неправильний формат римського числа: ", exception.getMessage());
    }

    @Test
    void testNullInputThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RomanToInteger.convertToInteger(null);
        });
        assertEquals("Неправильний формат римського числа: null", exception.getMessage());
    }

    @Test
    void testInvalidRomanNumeralThrowsException1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RomanToInteger.convertToInteger("IIII");
        });
        assertEquals("Неправильний формат римського числа: IIII", exception.getMessage());
    }

    @Test
    void testInvalidRomanNumeralThrowsException2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RomanToInteger.convertToInteger("IC");
        });
        assertEquals("Неправильний формат римського числа: IC", exception.getMessage());
    }

    @Test
    void testLowerCaseRomanNumeralThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RomanToInteger.convertToInteger("xii");
        });
        assertEquals("Неправильний формат римського числа: xii", exception.getMessage());
    }

    @Test
    void testSpecialCharacterInRomanThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RomanToInteger.convertToInteger("X#V");
        });
        assertEquals("Неправильний формат римського числа: X#V", exception.getMessage());
    }

    @Test
    void testNumberInRomanThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RomanToInteger.convertToInteger("X5V");
        });
        assertEquals("Неправильний формат римського числа: X5V", exception.getMessage());
    }

    @Test
    void testInvalidRomanNumeralThrowsException3() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RomanToInteger.convertToInteger("VV");
        });
        assertEquals("Неправильний формат римського числа: VV", exception.getMessage());
    }

    @Test
    void testInvalidRomanNumeralThrowsException4() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RomanToInteger.convertToInteger("XD");
        });
        assertEquals("Неправильний формат римського числа: XD", exception.getMessage());
    }

    @Test
    void testInvalidCombinationThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RomanToInteger.convertToInteger("IL");
        });
        assertEquals("Неправильний формат римського числа: IL", exception.getMessage());
    }
}

