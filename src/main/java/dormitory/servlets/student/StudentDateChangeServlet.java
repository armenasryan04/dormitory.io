package dormitory.servlets.student;

import dormitory.manager.RoomManager;
import dormitory.manager.StudentManager;
import dormitory.models.Room;
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
    RoomManager roomManager = new RoomManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,RuntimeException {
        Student student = studentManager.getById(Integer.parseInt(req.getParameter("id")));
        Room room = roomManager.getById(Integer.parseInt(req.getParameter("roomId")));
        student.setRoom(room);
        req.setAttribute("student", student);
        req.getRequestDispatcher("WEB-INF/student/setDate.jsp").forward(req, resp);

    }
}
