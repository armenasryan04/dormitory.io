package dormitory.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phoneNum;
    private Date date;
    private Room room;
    private Receptionist receptionist;
    private StudentStatus studentStatus;
    private String verifyCode;

    public String getDaysUntil(Date endDate) {
        long millisecondsPerDay = 1000 * 60 * 60 * 24;
        long millisecondsPerHour = 1000 * 60 * 60;
        long currentTime = System.currentTimeMillis();
        long endDateTime = endDate.getTime() + millisecondsPerHour;
        long timeDiff = endDateTime - currentTime;
        long days = timeDiff / millisecondsPerDay;
        long hours = (timeDiff % millisecondsPerDay) / millisecondsPerHour;

        if (days <= 0 && hours <= 0) {

            return 0 + "d " + 0 + "h";
        }

        if (hours >= 12) {
            days++;
            hours = 0;
        }

        return days + "d " + hours + "h";
    }

}