package dormitory.servlets.receptionist;

import dormitory.manager.StudentManager;
import dormitory.models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/control")
public class ControlServlet extends HttpServlet {
    StudentManager studentManager = new StudentManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        String archive = req.getParameter("status");
        List<Student> all;
        if (archive == null || archive.equals("null")) {
            if (search == null) {
                all = studentManager.getAllActive();
            } else {
                all = studentManager.getByNameOrSurnameActive(search);
            }
        } else {
            req.setAttribute("inArchive", "archive");
            all = studentManager.getAllArchive();
            if (search !=null){
                all = studentManager.getByNameOrSurnameArchive(search);
            }
        }
        req.setAttribute("students", all);
        req.getRequestDispatcher("WEB-INF/control.jsp").forward(req, resp);

    }

}
