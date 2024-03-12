package dormitory.servlets.student;

import dormitory.manager.DormitoryManager;
import dormitory.manager.StudentManager;
import dormitory.models.Dormitory;
import dormitory.models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/makeActive")
public class makeActiveServlet extends HttpServlet {
    StudentManager studentManager = new StudentManager();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int roomId = Integer.parseInt(req.getParameter("roomId"));
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
        studentManager.statusToActive(id, roomId, sqlDate);
        resp.sendRedirect("/control");
    }
}
