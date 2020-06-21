package servlets;

import dao.DeviceDaoImpl;
import dao.MetrologyDao;
import pojo.Device;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * UpdateDeviceServlet.
 *
 * @author Aydar_Safiullin
 */
@WebServlet("/updatedevice")
public class UpdateDeviceServlet extends HttpServlet {
    private MetrologyDao<Device> metrologyDao = new DeviceDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        long id = Long.parseLong(request.getParameter("id"));
        Device device = metrologyDao.getItemById(id);

        String name = request.getParameter("name");
        String model = request.getParameter("model");
        String registryNumber = request.getParameter("registry");
        String serialNumber = request.getParameter("serial");
        String calibrationDate = request.getParameter("calibration");

        device.setName(name);
        device.setModel(model);
        device.setRegistryNumber(registryNumber);
        device.setSerialNumber(serialNumber);
        device.setCalibrationDate(calibrationDate);

        metrologyDao.updateItemById(id, device);

        response.sendRedirect(request.getContextPath() + "/showdevice");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Device device = metrologyDao.getItemById(id);
        request.setAttribute("device", device);
        request.getRequestDispatcher("jsp/updateDevice.jsp")
                .forward(request, response);
    }
}
