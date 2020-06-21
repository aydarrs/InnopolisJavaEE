package dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojo.Device;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DeviceDaoImpl.
 * General DAO interface realisation for working with objects od Device.class.
 *
 * @author Aydar_Safiullin
 */
public class DeviceDaoImpl implements MetrologyDao<Device> {
    private static final Logger logger = LogManager.getLogger("MainLogger");
    protected ConnectionManager manager = new ConnectionManager();
    private String selectCommandTemplate = "SELECT * FROM devices WHERE id = ";

    @Override
    public boolean addItem(Device item) {
        String addCommand
                = "INSERT INTO devices " +
                "(name, model, registry_number, serial_number, calibration_date) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = manager.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(addCommand)) {
                statement.setString(1, item.getName());
                statement.setString(2, item.getModel());
                statement.setString(3, item.getRegistryNumber());
                statement.setString(4, item.getSerialNumber());
                statement.setString(5, item.getCalibrationDate());
                statement.executeUpdate();

                logger.info("New device {} added", item);
                return true;
            }
        } catch (SQLException e) {
            logger.error("Error adding new element {} into the \"device\" table", item, e);
        }
        return false;
    }

    @Override
    public Device getItemById(long id) {
        Device device = null;
        try (JdbcRowSet rowSet = manager.getRowSet()) {
            rowSet.setCommand(selectCommandTemplate + id);
            rowSet.execute();

            rowSet.next();
            device = createDeviceByTableData(rowSet);

            return device;

        } catch (SQLException e) {
            logger.error("Error getting the element id {} from the \"device\" table", id, e);
        }
        return null;
    }

    @Override
    public boolean updateItemById(long id, Device item) {
        try (JdbcRowSet rowSet = manager.getRowSet()) {
            rowSet.setCommand(selectCommandTemplate + id);
            rowSet.execute();

            rowSet.next();
            rowSet.updateString("name", item.getName());
            rowSet.updateString("model", item.getModel());
            rowSet.updateString("registry_number", item.getRegistryNumber());
            rowSet.updateString("serial_number", item.getSerialNumber());
            rowSet.updateString("calibration_date", item.getCalibrationDate());
            rowSet.updateRow();

            logger.info("device {} updated", item);
            return true;

        } catch (SQLException e) {
            logger.error("Error updating the element id {} in the \"device\" table", id, e);
        }
        return false;
    }

    @Override
    public boolean deleteItemById(long id) {
        try (JdbcRowSet rowSet = manager.getRowSet()) {
            rowSet.setCommand(selectCommandTemplate + id);
            rowSet.execute();
            rowSet.next();
            rowSet.deleteRow();

            logger.info("Deleted device id {}", id);
            return true;

        } catch (SQLException e) {
            logger.error("Error deleting the element id {} in the \"device\" table", id, e);
        }
        return false;
    }

    @Override
    public List<Device> getAllItems() {
        List<Device> items = new ArrayList<>();
        Device device = null;
        String selectAllCommand = "SELECT * FROM devices";
        try (JdbcRowSet rowSet = manager.getRowSet()) {
            rowSet.setCommand(selectAllCommand);
            rowSet.execute();

            while(rowSet.next()) {
                device = createDeviceByTableData(rowSet);
                items.add(device);
            }

        } catch (SQLException e) {
            logger.error("Error getting all elements from the \"device\" table", e);
        }

        return items;
    }

    /**
     * Create new Device.class object by "device" table data.
     * @param rowSet - using JdbcRowSet.
     * @return Device.class object from database.
     * @throws SQLException
     */
    private Device createDeviceByTableData(JdbcRowSet rowSet) throws SQLException {
        Device device;
        long id = rowSet.getLong("id");
        String name = rowSet.getString("name");
        String model = rowSet.getString("model");
        String registryNumber = rowSet.getString("registry_number");
        String serialNumber = rowSet.getString("serial_number");
        String calibrationDate = rowSet.getString("calibration_date");

        device = new Device(name, model);
        device.setRegistryNumber(registryNumber);
        device.setSerialNumber(serialNumber);
        device.setCalibrationDate(calibrationDate);
        device.setId(id);
        return device;
    }
}
