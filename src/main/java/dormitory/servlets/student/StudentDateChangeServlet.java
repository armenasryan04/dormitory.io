package dormitory.servlets.student;

import dormitory.emailVerifycation.EmailSender;
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

@WebServlet("/studentDateChange")
public class StudentDateChangeServlet extends HttpServlet {
    StudentManager studentManager = new StudentManager();
    DormitoryManager dormitoryManager = new DormitoryManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,RuntimeException {
        Student student = studentManager.getById(Integer.parseInt(req.getParameter("id")));
        Dormitory dormitory = dormitoryManager.getById(Integer.parseInt(req.getParameter("roomId")));
        student.setDormitory(dormitory);
        req.setAttribute("student", student);
        req.getRequestDispatcher("WEB-INF/setDate.jsp").forward(req, resp);

    }
}
