package org.usfirst.frc.team2557.sensors;

import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;

import java.util.ArrayList;
import java.util.List;

public class LidarRangeFinder extends SensorBase implements LiveWindowSendable {

    private SerialPort _serial;

    private List<Byte> _byteBuilder;

    private LidarData[] _data;
    private String _currentErrorMsg = "";

    private float _currentMotorRPM;

    private ITable _table;

    public LidarRangeFinder() {
        this._serial = new SerialPort(115200, SerialPort.Port.kMXP);
        this._serial.reset();

        this._byteBuilder = new ArrayList<Byte>();

        this._data = new LidarData[360];
        for (int i = 0; i < this._data.length; i++) {
            this._data[i] = new LidarData();
        }

        LiveWindow.addSensor("Lidar", 0, this);
    }

    /**
     * Serial deconstructor.
     */
    public void free() {
        this._serial.free();
    }

    /**
     * Gets the current revolutions per minute
     * the head is spinning.
     *
     * @return RPM of Lidar head
     */
    public float getCurrentRPM() {
        this.selfUpdate();

        return this._currentMotorRPM;
    }

    /**
     * Gets the current recorded data from the sensor.
     *
     * @param angle Angle of Lidar head
     * @return LidarData at specified angle
     */
    public LidarData getData(int angle) {
        this.selfUpdate();

        while (angle > 360) angle -= 360;
        while (angle <= 0) angle += 360;

        return this._data[angle - 1];
    }

    private void selfUpdate() {
        try {
            // See if there are any bytes to read
            byte[] inBytes = this._serial.read(this._serial.getBytesReceived());
            for (byte currByte : inBytes) {

                if (currByte == (byte) 0xFA) {
                    if (this._byteBuilder.size() == 22) {
                        this.readData(this.getByteArrayFromBuilder(22));
                        this._byteBuilder.clear();
                    }
                    this._byteBuilder.clear();
                    this._byteBuilder.add(currByte);
                } else {
                    this._byteBuilder.add(currByte);
                }

            }
        } catch (RuntimeException ex) {
            System.out.println("-- Something went wrong! --");
            ex.printStackTrace();

            this._serial.reset();
        }
    }

    private byte[] getByteArrayFromBuilder(int count) {
        byte[] bytes = new byte[22];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = this._byteBuilder.get(i);
        }
        return bytes;
    }

    public void updateNetworkTables() {
        ITable lidarTable = NetworkTable.getTable("Lidar");

        double[] distances = new double[360];
        double[] qualities = new double[360];
        for (int i = 0; i < 359; i++) {
            distances[i] = this.getData(i).getDistance();
            qualities[i] = this.getData(i).getQuality();
        }

        lidarTable.putNumberArray("Distances", distances);
        lidarTable.putNumberArray("Qualities", qualities);
        lidarTable.putString("ErrorMsg", this._currentErrorMsg);
        lidarTable.putNumber("RPM", this.getCurrentRPM());
    }

    private void readData(byte[] inBytes) {
        this._currentErrorMsg = "";

        // Skip 0: always 0xFA

        int index = inBytes[1] & 0xFF; // 0xA0 (160) - 0xF9 (249)
        // Turn the index into 0-89
        index -= 160;

        // Get checksum from packet
        int cs_L = inBytes[20] & 0xFF;
        int cs_H = inBytes[21] & 0xFF;
        int pChecksum = (cs_H << 8) | cs_L;

        // Validate checksum
        if (getChecksum(inBytes) == pChecksum) {

            int speed_L = inBytes[2] & 0xFF;
            int speed_H = inBytes[3] & 0xFF;
            float motor_rpm = (float) ((speed_H << 8) | speed_L) / 64.0f;
            this._currentMotorRPM = motor_rpm;

            for (int i = 0; i < 4; i++) {
                int angle = index * 4 + i;

                int d1 = inBytes[4 + 4 * i] & 0xFF; // First half of distance data
                int d2 = inBytes[5 + 4 * i] & 0xFF; // Invalid flag or second half of distance data
                int d3 = inBytes[6 + 4 * i] & 0xFF; // First half of quality data
                int d4 = inBytes[7 + 4 * i] & 0xFF; // Second half of quality data

                boolean updateNetworkTables = false;

                // Check for valid distance
                int distance = 0;
                if ((d2 & 0x80) == 0) { // Valid data
                    distance = ((d2 & 0x3F) << 8) | d1; // Strips out last two bits of higher value; distance = 14 bits
                    updateNetworkTables = true;
                } else { // Invalid data!
                    this._currentErrorMsg = "Invalid data! (error 0x" + String.format("%02X", d1);
                }

                int quality = (d4 << 8) | d3;

                this.getData(angle).angle = angle;
                this.getData(angle).distance = distance;
                this.getData(angle).quality = quality;
            }
        } else {
            // Checksum failed!
            this._currentErrorMsg = "Checksum failed!";
        }
    }

    private int getChecksum(byte[] inBytes) {
        int[] data_list = new int[10];
        // Group the data by word, little-endian
        for (int i = 0; i < data_list.length; i++) {
            int d1 = inBytes[2 * i] & 0xFF;
            int d2 = inBytes[2 * i + 1] & 0xFF;

            data_list[i] = (d2 << 8) | d1;
        }

        // Compute the checksum on 32 bits
        int chk32 = 0;
        for (int d : data_list) {
            chk32 = (chk32 << 1) + d;
        }

        // Return a value wrapped around on 15 bits, and truncated to still fit into 15 bits
        int checksum = 0;
        checksum = (chk32 & 0x7FFF) + (chk32 >> 15); // Wrap around to fit into 15 bits
        checksum &= 0x7FFF; // Truncate to 15 bits

        return checksum;
    }

    public class LidarData {
        protected int angle;
        protected int distance;
        protected int quality;

        /**
         * Returns the angle in degrees.
         *
         * @return Angle in degrees
         */
        public int getAngle() {
            return this.angle;
        }

        /**
         * Returns the distance in mm.
         *
         * @return Distance in mm
         */
        public int getDistance() {
            return this.distance;
        }

        /**
         * Returns the quality.
         *
         * @return Quality
         */
        public int getQuality() {
            return this.quality;
        }
    }

    @Override
    public void initTable(ITable subtable) {
        this._table = subtable;
        this.updateTable();
    }

    @Override
    public ITable getTable() {
        return this._table;
    }

    @Override
    public String getSmartDashboardType() {
        return "Lidar Range Finder";
    }

    @Override
    public void updateTable() {
        if (this._table != null) {
            double angle = this._table.getNumber("Angle", 0.0);
            this._table.putNumber("Distance (" + Math.floor(angle) + " degrees)", this.getData((int) Math.floor(angle)).getDistance());
            this._table.putNumber("Quality (" + Math.floor(angle) + " degrees)", this.getData((int) Math.floor(angle)).getQuality());

            this._table.putString("Current Error Message", this._currentErrorMsg);
        }
    }

    @Override
    public void startLiveWindowMode() {

    }

    @Override
    public void stopLiveWindowMode() {

    }

}
