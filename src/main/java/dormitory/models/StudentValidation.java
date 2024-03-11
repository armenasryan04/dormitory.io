package dormitory.models;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentValidation {
    public static String validation(Student student) {
        String validation = null;
        if (!isNameValid(student.getName())) {
            validation = "Incorrect Name try again!";
            return validation;
        }
        if (!isSurnameValid(student.getSurname())) {
            validation = "Incorrect Surname try again!";
            return validation;
        }
        if (!isEmailAddressValid(student.getEmail()) || student.getEmail().isEmpty() || student.getEmail() == null) {
            validation = "Incorrect Email try again!";
            return validation;
        }
        if (validatePhoneNumber(student.getPhoneNum()) || student.getPhoneNum() == null || student.getPhoneNum().isEmpty()) {
            validation = "Incorrect Phone try again!";
            return validation;
        }
        return validation;
    }



    private static boolean validatePhoneNumber(String phoneNumber) {
        String phonePattern = "^\\+374\\d{6}$";
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    private static boolean isEmailAddressValid(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException e) {
            result = false;
        }
        return result;
    }


    private static boolean isNameValid(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }

        name = name.trim();

        if (name.length() < 3 || name.length() > 10) {
            return false;
        }

        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        if (!Character.isUpperCase(name.charAt(0))) {
            return false;
        }
        for (int i = 1; i < name.length(); i++) {
            if (!Character.isLowerCase(name.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSurnameValid(String surname) {
        if (surname == null || surname.isEmpty()) {
            return false;
        }

        surname = surname.trim();
        if (surname.length() < 6 || surname.length() > 15) {
            return false;
        }

        for (char c : surname.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        if (!Character.isUpperCase(surname.charAt(0))) {
            return false;
        }
        for (int i = 1; i < surname.length(); i++) {
            if (!Character.isLowerCase(surname.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
