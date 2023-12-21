package ait.validator.test;

import org.junit.jupiter.api.Test;

import static ait.validator.utils.Validator.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTestMyOwn {

    

    @Test
    void testCheckCreditCardNumber() {
        assertTrue(checkCreditCardNumber("12345678"));
        assertTrue(checkCreditCardNumber("1122334455667789"));
        assertTrue(checkCreditCardNumber("1234567890123456"));
        assertFalse(checkCreditCardNumber("12345"));
        assertFalse(checkCreditCardNumber("12345678A"));
        assertFalse(checkCreditCardNumber("asd12312345"));
        assertFalse(checkCreditCardNumber("12345678!"));
    }

    @Test
    void testCheckDateFormatEU() {
        assertTrue(checkDateFormatEU("01.12.1992"));
        assertTrue(checkDateFormatEU("30.01.1992"));
        assertFalse(checkDateFormatEU("32.01.1992"));
        assertFalse(checkDateFormatEU("55.01.1992"));
        assertFalse(checkDateFormatEU("01.13.1992"));
        assertFalse(checkDateFormatEU("01.12.19921"));
        assertFalse(checkDateFormatEU("99.99.1992"));
        assertFalse(checkDateFormatEU("01/02/1992"));
        assertFalse(checkDateFormatEU("01-02-1992"));
        assertFalse(checkDateFormatEU("1.2.1992"));
        assertFalse(checkDateFormatEU("01.2.1992"));
        assertFalse(checkDateFormatEU("1.02.1992"));
    }

    @Test
    void testCheckDateFormatUS() {
        assertTrue(checkDateFormatUS("1992-12-01"));
        assertTrue(checkDateFormatUS("1992-01-30"));
        assertFalse(checkDateFormatUS("1992-01-32"));
        assertFalse(checkDateFormatUS("1992-05-55"));
        assertFalse(checkDateFormatUS("1992-13-01"));
        assertFalse(checkDateFormatUS("19921-12-01"));
        assertFalse(checkDateFormatUS("1992-99-99"));
        assertFalse(checkDateFormatUS("1992/01/02"));
        assertFalse(checkDateFormatUS("1992/01/02"));

    }

    @Test
    void testCheckPhoneNumber() {
        assertTrue(checkPhoneNumber("+99(01)1234-5678"));
        assertFalse(checkPhoneNumber("99(01)1234-5678"));
        assertFalse(checkPhoneNumber("+099(01)1234-5678"));
        assertFalse(checkPhoneNumber("+99(1)1234-5678"));
        assertFalse(checkPhoneNumber("+99(01)123-5678"));
        assertFalse(checkPhoneNumber("+99(01)1234-56789"));

    }

    @Test
    void testCheckNumberLessEquals255() {
        assertTrue(checkLessEquals255("255"));
        assertTrue(checkLessEquals255("1"));
        assertTrue(checkLessEquals255("0"));
        assertTrue(checkLessEquals255("150"));
        assertFalse(checkLessEquals255("256"));
        assertFalse(checkLessEquals255("-10"));
        assertFalse(checkLessEquals255("A"));
        assertFalse(checkLessEquals255("!"));
        assertFalse(checkLessEquals255("00"));
    }
}