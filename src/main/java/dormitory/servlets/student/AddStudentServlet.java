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
import java.util.Date;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    StudentManager studentManager = new StudentManager();
    DormitoryManager dormitoryManager = new DormitoryManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("roomId");
        Dormitory room = dormitoryManager.getById(Integer.parseInt(id));
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
                .name(req.getParameter("name"))
                .surname(req.getParameter("surname"))
                .id(Integer.parseInt(req.getParameter("id")))
                .phoneNum(req.getParameter("phone"))
                .email(req.getParameter("email"))
                .date(sqlDate)
                .dormitory(room).
                build();
        studentManager.addToDB(student);
        req.getRequestDispatcher("WEB-INF/control.jsp").forward(req,resp);
    }


}