package dormitory.filter;

import dormitory.emailVerifycation.EmailSender;
import dormitory.manager.RoomManager;
import dormitory.models.Room;
import dormitory.models.Student;
import dormitory.validation.StudentValidation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

@WebFilter(urlPatterns = {"/emailReVerify"})
public class ActivateValidationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        RoomManager roomManager = new RoomManager();
        String id = req.getParameter("roomId");
        Room room = roomManager.getById(Integer.parseInt(id));
        String date = req.getParameter("date");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate;
        java.sql.Date sqlDate = null;
        try {
            utilDate = dateFormat.parse(date);
            sqlDate = new java.sql.Date(utilDate.getTime());
            Random random = new Random();
            int randomNumber = random.nextInt(900000) + 100000;
            Student student = Student.builder()
                    .id(Integer.parseInt(req.getParameter("id").trim()))
                    .email(req.getParameter("email").trim())
                    .date(sqlDate)
                    .room(room)
                    .verifyCode(String.valueOf(randomNumber)).
                    build();
            EmailSender emailSender = new EmailSender();
            if (StudentValidation.isEmailAddressValid(student.getEmail()) && emailSender.sendMail(student.getEmail(), randomNumber) && StudentValidation.dateValid(student.getDate())) {
                req.setAttribute("student", student);
                filterChain.doFilter(req, resp);
            } else {
                req.setAttribute("errMsg", StudentValidation.validation(student));
                req.setAttribute("room", student.getRoom());
                req.getRequestDispatcher("WEB-INF/student/dataFilling.jsp").forward(req, resp);
            }
        } catch (ParseException e) {
            req.setAttribute("errMsg","invalid date");
            req.setAttribute("room", room);
            req.getRequestDispatcher("WEB-INF/student/dataFilling.jsp").forward(req, resp);
        }

    }
}



