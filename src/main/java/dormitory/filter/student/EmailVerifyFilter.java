package dormitory.filter.student;

import dormitory.manager.RoomManager;
import dormitory.models.Room;
import dormitory.models.Student;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebFilter(urlPatterns = {"/addStudent","/makeActive"})
public class EmailVerifyFilter implements Filter {
    RoomManager roomManager = new RoomManager();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("roomId");
        Room room = roomManager.getById(Integer.parseInt(id));
        String date = req.getParameter("date");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate;
        java.sql.Date sqlDate = null;
        try {
            utilDate = dateFormat.parse(date);
            sqlDate = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Student student = Student.builder()
                .name(req.getParameter("name").trim())
                .surname(req.getParameter("surname").trim())
                .id(Integer.parseInt(req.getParameter("id").trim()))
                .phoneNum(req.getParameter("phoneNum").trim())
                .email(req.getParameter("email").trim())
                .verifyCode(req.getParameter("checkCode").trim())
                .date(sqlDate)
                .room(room)
                .build();
        if (student.getVerifyCode().equals(req.getParameter("code").trim())) {
           req.setAttribute("student",student);
           filterChain.doFilter(req,resp);
        }else {
            req.setAttribute("errMsg","not variable code try again!");
            req.setAttribute("room",room);
            req.getRequestDispatcher("WEB-INF/student/dataFilling.jsp").forward(req, resp);
        }
    }
}



