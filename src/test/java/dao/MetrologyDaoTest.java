package dao;

import org.junit.Test;
import pojo.Device;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * DaoTest.
 * Testing general DAO interface realisations.
 * @author Aydar_Safiullin
 */
public class MetrologyDaoTest {
    DeviceDaoImpl deviceDao = spy(DeviceDaoImpl.class);
    ConnectionManager manager = mock(ConnectionManager.class);
    Connection connection = mock(Connection.class);
    PreparedStatement statement = mock(PreparedStatement.class);
    JdbcRowSet rowSet = mock(JdbcRowSet.class);

    @Test
    public void isAddingDeviceIntoTheTableIsWork() throws SQLException {
        deviceDao.manager = manager;
        Device device = new Device("Flow computer", "Floboss S600+");
        device.setRegistryNumber("56788-20");
        device.setSerialNumber("12345677");
        device.setCalibrationDate("2019-12-01");
        when(deviceDao.manager.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(statement);

        boolean result = deviceDao.addItem(device);

        assertTrue(result);
    }

    @Test
    public void isGettingDeviceFromTableWork() throws SQLException {
        deviceDao.manager = manager;
        when(manager.getRowSet()).thenReturn(rowSet);

        Device device = deviceDao.getItemById(1);

        assertNotNull(device);
    }

    @Test
    public void isUpdatingDeviceInTableWork() {
        deviceDao.manager = manager;
        Device device = new Device("Stub", "Stub");
        device.setRegistryNumber("Stub");
        device.setSerialNumber("Stub");
        device.setCalibrationDate("Stub");
        when(manager.getRowSet()).thenReturn(rowSet);

        boolean result = deviceDao.updateItemById(12, device);

        assertTrue(result);
    }

    @Test
    public void isDeletingDeviceFromTableWork() {
        deviceDao.manager = manager;
        when(manager.getRowSet()).thenReturn(rowSet);

        boolean result = deviceDao.deleteItemById(1);

        assertTrue(result);
    }

    @Test
    public void isGettingAllDevicesFromTableWork() {
        deviceDao.manager = manager;
        when(manager.getRowSet()).thenReturn(rowSet);

        List<Device> result = deviceDao.getAllItems();

        assertNotNull(result);
    }
}
