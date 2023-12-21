package ait.validator.test;
import static ait.validator.utils.Validator.*;
import static org.junit.jupiter.api.Assertions.*;


class ValidatorTest {

    

    @org.junit.jupiter.api.Test
    void testCheckCreditCardNumber() {
        assertTrue(checkCreditCardNumber("12345678"));
        assertTrue(checkCreditCardNumber("1234567887654321"));
        assertTrue(checkCreditCardNumber("1234567890"));
        assertFalse(checkCreditCardNumber("1234567"));
        assertFalse(checkCreditCardNumber("12345678876543210"));
        assertFalse(checkCreditCardNumber("12345678A"));
    }

    @org.junit.jupiter.api.Test
    void testCheckDateFormatEU() {
        assertTrue(checkDateFormatEU("26.10.2023"));
        assertTrue(checkDateFormatEU("05.02.2023"));
        assertTrue(checkDateFormatEU("31.02.2023"));
        assertFalse(checkDateFormatEU("32.02.2023"));
        assertFalse(checkDateFormatEU("15.13.2023"));
        assertFalse(checkDateFormatEU("26/02/2023"));
    }

    @org.junit.jupiter.api.Test
    void testCheckDateFormatUS() {
        assertTrue(checkDateFormatUS("2018-12-08"));
        assertTrue(checkDateFormatUS("2018-11-31"));
        assertTrue(checkDateFormatUS("2018-02-30"));
        assertFalse(checkDateFormatUS("2018-11-32"));
        assertFalse(checkDateFormatUS("2018-15-32"));
        assertFalse(checkDateFormatUS("20181-11-32"));
        assertFalse(checkDateFormatUS("2018-11-32"));
        assertFalse(checkDateFormatUS("08/12/2018"));
    }

    @org.junit.jupiter.api.Test
    void testCheckPhoneNumber() {
        assertTrue(checkPhoneNumber("+99(01)1234-5678"));
        assertFalse(checkPhoneNumber("99(01)1234-5678"));
        assertFalse(checkPhoneNumber("+099(01)1234-5678"));
        assertFalse(checkPhoneNumber("+99(1)1234-5678"));
        assertFalse(checkPhoneNumber("+99(01)123-5678"));
        assertFalse(checkPhoneNumber("+99(01)1234-56789"));
    }

    @org.junit.jupiter.api.Test
    void testCheckLessEquals255() {
        assertTrue(checkLessEquals255("0"));
        assertTrue(checkLessEquals255("5"));
        assertTrue(checkLessEquals255("58"));
        assertTrue(checkLessEquals255("199"));
        assertTrue(checkLessEquals255("255"));
        assertFalse(checkLessEquals255("256"));
        assertFalse(checkLessEquals255("1000"));
        assertFalse(checkLessEquals255("-2"));
        assertFalse(checkLessEquals255("25b"));
    }
}