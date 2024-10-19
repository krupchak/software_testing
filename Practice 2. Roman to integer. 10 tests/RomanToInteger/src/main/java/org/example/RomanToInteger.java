package org.example;
/*
@author   $Krupcak_Anastasiia
@project   $Roman_To_Integer
@class  $444A
@version  1.0.0
@since 19.10.2024 - 19.00
*/
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RomanToInteger {

    // Мапа для зберігання римських символів та їхніх відповідних значень
    private static final Map<Character, Integer> romanValues = new HashMap<>();
    static {
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
    }

    // Шаблон для перевірки коректності римського числа
    private static final String ROMAN_VALIDATION_PATTERN = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

    // Метод для перевірки коректності римського числа
    public static boolean isRomanValid(String roman) {
        if (roman == null || roman.trim().isEmpty()) {
            return false;
        }

        // Перевірка на неправильні символи
        if (!Pattern.matches("[IVXLCDM]+", roman)) {
            return false;
        }

        // Перевірка на заборонені повторення
        if (roman.contains("IIII") || roman.contains("VV") || roman.contains("XXXX") ||
                roman.contains("LL") || roman.contains("CCCC") || roman.contains("DD") ||
                roman.contains("MMMM")) {
            return false;
        }

        // Перевірка на некоректні комбінації
        if (roman.contains("IL") || roman.contains("IC") || roman.contains("VX") ||
                roman.contains("XD") || roman.contains("LC") || roman.contains("DM")) {
            return false;
        }

        // Перевірка на некоректний порядок символів
        if (roman.contains("IVI") || roman.contains("XCX") || roman.contains("IXI")) {
            return false;
        }

        return Pattern.matches(ROMAN_VALIDATION_PATTERN, roman);
    }

    // Метод для конвертації римського числа у звичайне ціле
    public static int convertToInteger(String roman) {
        if (!isRomanValid(roman)) {
            throw new IllegalArgumentException("Неправильний формат римського числа: " + roman);
        }

        int sum = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char currentChar = roman.charAt(i);
            int currentValue = romanValues.get(currentChar);

            if (currentValue < prevValue) {
                sum -= currentValue;
            } else {
                sum += currentValue;
            }

            prevValue = currentValue;
        }

        return sum;
    }

    public static void main(String[] args) {
        String[] testCases = {"XII", "IX", "LVIII", "MCMXCIV", "IIII",
                "IC", "VX", "MMMDCCCLXXXVIII", "xii", "X5V", "V#L"};

        for (String roman : testCases) {
            try {
                int integer = convertToInteger(roman);
                System.out.println(roman + " -> " + integer);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
