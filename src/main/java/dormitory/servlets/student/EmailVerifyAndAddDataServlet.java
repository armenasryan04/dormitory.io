package dormitory.servlets.student;

import dormitory.emailVerifycation.EmailSender;
import dormitory.manager.DormitoryManager;
import dormitory.manager.StudentManager;
import dormitory.models.Dormitory;
import dormitory.models.Student;
import dormitory.models.StudentStatus;
import dormitory.models.StudentValidation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

@WebServlet("/emailVerify")
public class EmailVerifyAndAddDataServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/verifyEmail.jsp").forward(req, resp);
    }


}
