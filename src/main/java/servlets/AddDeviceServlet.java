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
 * AddDeviceServlet.
 *
 * @author Aydar_Safiullin
 */
@WebServlet("/deviceadd")
public class AddDeviceServlet extends HttpServlet {
    private MetrologyDao metrologyDao = new DeviceDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String model = request.getParameter("model");
        String registryNumber = request.getParameter("registry");
        String serialNumber = request.getParameter("serial");
        String calibrationDate = request.getParameter("calibration");
        Device device = new Device(name, model);
        device.setRegistryNumber(registryNumber);
        device.setSerialNumber(serialNumber);
        device.setCalibrationDate(calibrationDate);

        metrologyDao.addItem(device);

        response.sendRedirect(request.getContextPath() + "/showdevice");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/addDevice.jsp")
                .forward(request, response);
    }
}
