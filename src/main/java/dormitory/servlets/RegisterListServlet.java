package dormitory.servlets;



import dormitory.manager.StudentManager;
import dormitory.models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/regList")
public class RegisterListServlet extends HttpServlet {
   StudentManager studentManager = new StudentManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> all = studentManager.getAll();
        req.setAttribute("rooms",all);
        req.getRequestDispatcher("WEB-INF/studentsList.jsp").forward(req,resp);
    }
}
