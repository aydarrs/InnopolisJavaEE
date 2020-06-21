package servlets;

import dao.DeviceDaoImpl;
import dao.MetrologyDao;

/**
 * Test.
 *
 * @author Aydar_Safiullin
 */
public class Test {
    public static void main(String[] args) {
        MetrologyDao metrologyDao = new DeviceDaoImpl();
        System.out.println(metrologyDao.getAllItems());
    }
}
