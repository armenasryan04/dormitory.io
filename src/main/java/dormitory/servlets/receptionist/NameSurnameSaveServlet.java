package dormitory.servlets.receptionist;

import dormitory.manager.ReceptionistManager;
import dormitory.models.Receptionist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/saveNameSurname")
public class NameSurnameSaveServlet extends HttpServlet {
    ReceptionistManager receptionistManager = new ReceptionistManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Receptionist receptionist = (Receptionist) session.getAttribute("receptionist");
        String name;
        String surname;
        if (req.getParameter("name").trim().isEmpty() || req.getParameter("name") == null) {
            name = receptionist.getName();
        } else {
            name = req.getParameter("name");
            receptionist.setName(name);
        }
        if (req.getParameter("surname").trim().isEmpty() || req.getParameter("surname") == null) {
            surname = receptionist.getSurname();
        } else {
            surname = req.getParameter("surname");
            receptionist.setSurname(surname);
        }
        receptionistManager.changeNameSurnameById(receptionist.getId(),name,surname);
        session.setAttribute("receptionist",receptionist);
        resp.sendRedirect("/control");
    }
}
