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
    private Dormitory dormitory;

    public long getDaysUntil(Date endDate) {
        long millisecondsPerDay = 1000 * 60 * 60 * 24;
        long currentTime = System.currentTimeMillis();
        long endDateTime = endDate.getTime();
        return (endDateTime - currentTime) / millisecondsPerDay;
    }
}