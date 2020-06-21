package servlets;

import dao.DeviceDaoImpl;
import dao.MetrologyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * DeleteDeviceServlet.
 *
 * @author Aydar_Safiullin
 */
@WebServlet("/deletedevice")
public class DeleteDeviceServlet extends HttpServlet {
    private MetrologyDao metrologyDao = new DeviceDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        metrologyDao.deleteItemById(id);


        response.sendRedirect(request.getContextPath() + "/showdevice");
    }
}
