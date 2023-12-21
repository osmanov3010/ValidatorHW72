package ait.validator.utils;

public class Validator {
    public static boolean checkCreditCardNumber(String str) {
        return str.matches("\\d{8,16}");
    }
    public static boolean checkDateFormatEU(String str) {
        return str.matches("((0[1-9])|(2[0-9]|(3[0-1])))[.]((0[1-9])|(1[0-2]))[.]([1-2][0-9]{3})");
    }
    public static boolean checkDateFormatUS(String str) {
        return str.matches("([1-2][0-9]{3})-((0[1-9])|(1[0-2]))-((0[1-9])|(2[0-9]|(3[0-1])))");
    }
    public static boolean checkPhoneNumber(String str) {
        //+99(01)1234-5678
        return str.matches("[+]99\\(01\\)[0-9]{4}-[0-9]{4}");
    }
    public static boolean checkLessEquals255(String str) {
        return str.matches("([0-9])|([1-9][0-9])|(1[0-9][0-9])|(2[0-5][0-5])");
    }
}
