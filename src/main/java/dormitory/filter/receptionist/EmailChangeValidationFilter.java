package dormitory.filter.receptionist;

import dormitory.emailVerifycation.EmailSender;
import dormitory.manager.ReceptionistManager;
import dormitory.models.Receptionist;
import dormitory.validation.Validation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebFilter(urlPatterns = {"/emailChangingVerify"})
public class EmailChangeValidationFilter implements Filter {
    ReceptionistManager receptionistManager = new ReceptionistManager();
    EmailSender emailSender = new EmailSender();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String newEmail = req.getParameter("newEmail").trim();
        if (Validation.isEmailAddressValid(newEmail)) {
            HttpSession session = req.getSession();
            Receptionist sessionReceptionist = (Receptionist) session.getAttribute("receptionist");
            Receptionist receptionist = receptionistManager.getById(sessionReceptionist.getId());
            Random random = new Random();
            String email = req.getParameter("email").trim();
            String password = req.getParameter("password").trim();
            int randomNumber = random.nextInt(900000) + 100000;
            session.setAttribute("newEmail",newEmail);
            session.setAttribute("email",email);
            session.setAttribute("password",password);
            if (receptionistManager.getByEmail(newEmail).getId() == 0) {
                if (email.equals(receptionist.getEmail()) && password.equals(receptionist.getPassword()) && emailSender.sendMail(newEmail,randomNumber)) {
                    receptionist.setEmail(newEmail);
                    receptionist.setVerifyCode(String.valueOf(randomNumber));
                    session.setAttribute("receptionist", receptionist);
                    filterChain.doFilter(req, resp);
                }else {
                    req.setAttribute("errMsg","invalid Email or Password");
                    req.getRequestDispatcher("WEB-INF/receptionist/admin/changeEmail.jsp").forward(req,resp);
                }
            }else {
                req.setAttribute("errMsg","We already have staff with this email!");
                req.getRequestDispatcher("WEB-INF/receptionist/admin/changeEmail.jsp").forward(req,resp);
            }
        } else {
            req.setAttribute("errMsg","invalid Email :-(");
            req.getRequestDispatcher("WEB-INF/receptionist/admin/changeEmail.jsp").forward(req,resp);
        }
        }
    }
