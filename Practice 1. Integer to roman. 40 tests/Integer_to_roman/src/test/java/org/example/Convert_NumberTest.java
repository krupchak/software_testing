package org.example;

import static org.junit.Assert.*;
import org.junit.Test;

/*
@author   $Krupchak_Anastasia
@project   $Integer_To_Roman
@class  $444A
@version  1.0.0
@since 19.10.2024 - 19.00
*/

public class Convert_NumberTest {

    @Test
    public void testIntToRoman_1() {
        assertEquals("I", Convert_Number.intToRoman(1));
    }

    @Test
    public void testIntToRoman_2() {
        assertEquals("II", Convert_Number.intToRoman(2));
    }

    @Test
    public void testIntToRoman_3() {
        assertEquals("III", Convert_Number.intToRoman(3));
    }

    @Test
    public void testIntToRoman_4() {
        assertEquals("IV", Convert_Number.intToRoman(4));
    }

    @Test
    public void testIntToRoman_5() {
        assertEquals("V", Convert_Number.intToRoman(5));
    }

    @Test
    public void testIntToRoman_6() {
        assertEquals("VI", Convert_Number.intToRoman(6));
    }

    @Test
    public void testIntToRoman_7() {
        assertEquals("VII", Convert_Number.intToRoman(7));
    }

    @Test
    public void testIntToRoman_8() {
        assertEquals("VIII", Convert_Number.intToRoman(8));
    }

    @Test
    public void testIntToRoman_9() {
        assertEquals("IX", Convert_Number.intToRoman(9));
    }

    @Test
    public void testIntToRoman_10() {
        assertEquals("X", Convert_Number.intToRoman(10));
    }

    @Test
    public void testIntToRoman_11() {
        assertEquals("XI", Convert_Number.intToRoman(11));
    }

    @Test
    public void testIntToRoman_20() {
        assertEquals("XX", Convert_Number.intToRoman(20));
    }

    @Test
    public void testIntToRoman_50() {
        assertEquals("L", Convert_Number.intToRoman(50));
    }

    @Test
    public void testIntToRoman_90() {
        assertEquals("XC", Convert_Number.intToRoman(90));
    }

    @Test
    public void testIntToRoman_100() {
        assertEquals("C", Convert_Number.intToRoman(100));
    }

    @Test
    public void testIntToRoman_400() {
        assertEquals("CD", Convert_Number.intToRoman(400));
    }

    @Test
    public void testIntToRoman_500() {
        assertEquals("D", Convert_Number.intToRoman(500));
    }

    @Test
    public void testIntToRoman_900() {
        assertEquals("CM", Convert_Number.intToRoman(900));
    }

    @Test
    public void testIntToRoman_1000() {
        assertEquals("M", Convert_Number.intToRoman(1000));
    }

    @Test
    public void testIntToRoman_1987() {
        assertEquals("MCMLXXXVII", Convert_Number.intToRoman(1987));
    }

    @Test
    public void testIntToRoman_3999() {
        assertEquals("MMMCMXCIX", Convert_Number.intToRoman(3999));
    }

    @Test
    public void testIntToRoman_0() {
        assertNull(Convert_Number.intToRoman(0));
    }

    @Test
    public void testIntToRoman_4000() {
        assertNull(Convert_Number.intToRoman(4000));
    }

    @Test
    public void testIntToRoman_negative1() {
        assertNull(Convert_Number.intToRoman(-1));
    }

    @Test
    public void testIntToRoman_999() {
        assertEquals("CMXCIX", Convert_Number.intToRoman(999));
    }

    @Test
    public void testIntToRoman_2024() {
        assertEquals("MMXXIV", Convert_Number.intToRoman(2024));
    }

    @Test
    public void testIntToRoman_44() {
        assertEquals("XLIV", Convert_Number.intToRoman(44));
    }

    @Test
    public void testIntToRoman_78() {
        assertEquals("LXXVIII", Convert_Number.intToRoman(78));
    }

    @Test
    public void testIntToRoman_3000() {
        assertEquals("MMM", Convert_Number.intToRoman(3000));
    }

    @Test
    public void testIntToRoman_2444() {
        assertEquals("MMCDXLIV", Convert_Number.intToRoman(2444));
    }

    @Test
    public void testIntToRoman_49() {
        assertEquals("XLIX", Convert_Number.intToRoman(49));
    }

    @Test
    public void testIntToRoman_3888() {
        assertEquals("MMMDCCCLXXXVIII", Convert_Number.intToRoman(3888));
    }

    @Test
    public void testIntToRoman_75() {
        assertEquals("LXXV", Convert_Number.intToRoman(75));
    }

    @Test
    public void testIntToRoman_8_ExactRoman() {
        assertEquals("VIII", Convert_Number.intToRoman(8));
    }

    @Test
    public void testIntToRoman_333() {
        assertEquals("CCCXXXIII", Convert_Number.intToRoman(333));
    }

    @Test
    public void testIntToRoman_666() {
        assertEquals("DCLXVI", Convert_Number.intToRoman(666));
    }

    @Test
    public void testIntToRoman_1776() {
        assertEquals("MDCCLXXVI", Convert_Number.intToRoman(1776));
    }

    @Test
    public void testIntToRoman_1004() {
        assertEquals("MIV", Convert_Number.intToRoman(1004));
    }

    @Test
    public void testIntToRoman_1400() {
        assertEquals("MCD", Convert_Number.intToRoman(1400));
    }
}