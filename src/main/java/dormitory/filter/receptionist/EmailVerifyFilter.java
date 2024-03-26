package dormitory.filter.receptionist;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/addReceptionist","/changeEmail"})
public class EmailVerifyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("checkCode").trim().equals(req.getParameter("code").trim())) {
           filterChain.doFilter(req,resp);
        }else {
            req.setAttribute("errMsg","not variable code try again!");
            req.getRequestDispatcher("WEB-INF/receptionist/admin/verifyEmail.jsp").forward(req, resp);
        }
    }
}



