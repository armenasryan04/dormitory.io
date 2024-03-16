package dormitory.servlets.student;

import dormitory.manager.DormitoryManager;
import dormitory.models.Dormitory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentDataFilling")
public class StudentAddFormServlet extends HttpServlet {
    DormitoryManager dormitoryManager = new DormitoryManager();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,NullPointerException,NumberFormatException {
        int id = Integer.parseInt(req.getParameter("roomId"));
        Dormitory dormitory = dormitoryManager.getById(id);
        req.setAttribute("room",dormitory);
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("WEB-INF/dataFilling.jsp").forward(req,resp);
    }
}
