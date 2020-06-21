package servlets;

import dao.DeviceDaoImpl;
import dao.MetrologyDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojo.Device;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ${NAME}.
 *
 * @author Aydar_Safiullin
 */
@WebServlet("/showdevice")
public class ShowDeviceServlet extends HttpServlet {
    private MetrologyDao metrologyDao = new DeviceDaoImpl();
    private static final Logger logger = LogManager.getLogger("MainLogger");

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Device> devices = metrologyDao.getAllItems();
        request.setAttribute("devices", devices);

        request.getRequestDispatcher("jsp/showDevices.jsp")
                .forward(request, response);
    }
}
