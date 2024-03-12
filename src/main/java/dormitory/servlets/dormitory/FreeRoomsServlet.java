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
        String search = req.getParameter("search");
        String id = req.getParameter("id");
        List<Dormitory> all;
        if (id == null || id.equals("null")){
            if (search != null && search != "") {
                String[] room = search.split("-");
                all = dormitoryManager.getOnlyFreeRoomsByFloorOrRoom(Integer.parseInt(room[0]), Integer.parseInt(room[1]));
            }else {
                all = dormitoryManager.getOnlyFreeRooms();

            }
        }else {
            req.setAttribute("id",id);
            all = dormitoryManager.getOnlyFreeRooms();
            if (search != null && search != "") {
                String[] room = search.split("-");
                all = dormitoryManager.getOnlyFreeRoomsByFloorOrRoom(Integer.parseInt(room[0]), Integer.parseInt(room[1]));
            }
        }
        req.setAttribute("room", all);
        req.getRequestDispatcher("WEB-INF/freeRoms.jsp").forward(req, resp);

    }

}
