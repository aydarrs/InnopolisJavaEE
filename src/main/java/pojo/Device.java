package pojo;

/**
 * Device.
 * Description of the monitored device.
 * @author Aydar_Safiullin
 */
public class Device {
    private String name;
    private String model;
    private String registryNumber;
    private String serialNumber;
    private String calibrationDate;
    private long id;

    public Device(String name, String model) {
        this.name = name;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCalibrationDate() {
        return calibrationDate;
    }

    public void setCalibrationDate(String calibrationDate) {
        this.calibrationDate = calibrationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", registryNumber='" + registryNumber + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", calibrationDate='" + calibrationDate + '\'' +
                '}';
    }
}
