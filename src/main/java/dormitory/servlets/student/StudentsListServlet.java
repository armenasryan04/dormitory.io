package dormitory.servlets.student;



import dormitory.manager.StudentManager;
import dormitory.models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentList")
public class StudentsListServlet extends HttpServlet {
   StudentManager studentManager = new StudentManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String search = req.getParameter("search");
        List<Student> all;
        if (search == null){
            all = studentManager.getAll();
        }else{
            all = studentManager.getByNameOrSurname(search);
        }
        req.setAttribute("students",all);
        req.getRequestDispatcher("WEB-INF/studentsList.jsp").forward(req,resp);

    }
}
