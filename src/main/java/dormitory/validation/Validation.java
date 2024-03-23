package dormitory.validation;

import dormitory.manager.RoomManager;
import dormitory.manager.StudentManager;
import dormitory.models.Student;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static String validation(Student student) {
        RoomManager roomManager = new RoomManager();
        StudentManager studentManager = new StudentManager();
        String validation = null;

        if (!isEmailAddressValid(student.getEmail()) || student.getEmail().isEmpty() || student.getEmail() == null) {
            validation = "Incorrect Email try again!";
            return validation;
        }
        if (!isValidId(student.getId())) {
            validation = "Incorrect Inspection Booklet Num try again!";
            return validation;
        }
        if (studentManager.getByEmailOrId(student.getEmail(), student.getId()).getId() != 0) {
            student = studentManager.getByEmailOrId(student.getEmail(), student.getId());
            switch (student.getStudentStatus()) {
                case BAN:
                    validation = "We already have this student! \n he (she) is in Ban!";
                    return validation;
                case ARCHIVE:
                    validation = "We already have this student! \n " +
                            "he (she) is in Archive! \n " +
                            "but you can change status on Active";
                    return validation;
                case ACTIVE:
                    validation = "We already have this student!";
                    return validation;
                default:
                    return null;
            }
        }
        if (!roomManager.isFree(student.getRoom().getId())){
            validation = "We already have student in this room!";
            return validation;
        }
        if (!isNameValid(student.getName())) {
            validation = "Incorrect Name try again!";
            return validation;
        }
        if (!isSurnameValid(student.getSurname())) {
            validation = "Incorrect Surname try again!";
            return validation;
        }

        if (isValidatePhoneNumber(student.getPhoneNum()) || student.getPhoneNum() == null || student.getPhoneNum().isEmpty()) {
            validation = "Incorrect Phone try again!";
            return validation;
        }
        if (!isDateValid(student.getDate())){
            validation = "incorrect Date try again!";
        }
        return validation;
    }

     public static boolean isValidId(int id) {
        return String.valueOf(id).length() >= 3 && String.valueOf(id).length() <= 4;
    }


      static boolean isValidatePhoneNumber(String phoneNumber) {
        String phonePattern = "^\\+374\\d{6}$";
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean isEmailAddressValid(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException e) {
            result = false;
        }
        return result;
    }


    public static boolean isNameValid(String name) {
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

    public static boolean isSurnameValid(String surname) {
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
    public static boolean isDateValid(Date date){
        Date today = new Date();
        long tomorrowMillis = today.getTime() + (24 * 60 * 60 * 1000);
        Date tomorrow = new Date(tomorrowMillis);
        return !date.before(tomorrow);
    }
}
