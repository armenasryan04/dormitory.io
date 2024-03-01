package dormitory.servlets.dormitory;

import dormitory.manager.DormitoryManager;
import dormitory.models.Dormitory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/freeRooms")
public class FreeRoomsServlet extends HttpServlet {
    DormitoryManager dormitoryManager = new DormitoryManager();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dormitory> all = dormitoryManager.getOnlyFreeRooms();
        req.setAttribute("room",all);
        req.getRequestDispatcher("WEB-INF/freeRoms.jsp").forward(req,resp);
    }

}
