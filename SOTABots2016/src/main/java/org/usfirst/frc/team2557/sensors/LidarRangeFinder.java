package org.usfirst.frc.team2557.sensors;

import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.tables.ITable;

import java.util.ArrayList;
import java.util.List;

public class LidarRangeFinder extends SensorBase implements LiveWindowSendable {

    private enum LidarState {
        BOOT,
        DATA
    }

    private SerialPort _serial;

    private LidarState _state = LidarState.BOOT;
    private String _bootMsg = "";
    private List<Byte> _byteBuilder;

    private LidarData[] _data;

    private float _currentMotorRPM;
    
    private ITable _table;

    public LidarRangeFinder() {
        this._serial = new SerialPort(115200, SerialPort.Port.kOnboard);

        this._byteBuilder = new ArrayList<Byte>();

        this._data = new LidarData[360];
        for (int i = 0; i < this._data.length; i++) {
            this._data[i] = new LidarData();
        }
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

    /**
     * Gets the boot message received from the sensor.
     *
     * @return Boot message of Lidar unit
     */
    public String getBootMessage() {
        this.selfUpdate();

        return this._bootMsg;
    }


    private void selfUpdate() {
        // See if there are any bytes to read
        while (this._serial.getBytesReceived() > 0) {
            byte currByte = this._serial.read(1)[0];
            this._byteBuilder.add(currByte);

            // See what mode we are in
            switch (this._state) {
                case DATA:
                    if (this._byteBuilder.size() == 22) {
                        this.readData(this.getByteArrayFromBuilder());
                        this._byteBuilder.clear();
                    }
                    break;
                case BOOT:
                    if (currByte == 0xFA) {
                        // This is the start of the first packet!
                        // Our job here is done.
                        this._byteBuilder.remove(this._byteBuilder.size() - 1);

                        this._bootMsg = new String(this.getByteArrayFromBuilder());

                        this._byteBuilder.clear();

                        this._byteBuilder.add(currByte); // We must include the first byte of the next packet!!

                        this._state = LidarState.DATA;
                    }
                    break;
            }
        }
    }

    private byte[] getByteArrayFromBuilder() {
        byte[] bytes = new byte[this._byteBuilder.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = this._byteBuilder.get(i);
        }
        return bytes;
    }

    private void readData(byte[] inBytes) {
        // Skip 0: always 0xFA

        byte index = inBytes[1];

        byte speed_L = inBytes[2];
        byte speed_H = inBytes[3];
        float motor_rpm = (float) ((speed_H << 8) | speed_L) / 64.0f;
        this._currentMotorRPM = motor_rpm;

        for (int i = 0; i < 4; i++) {
            int angle = index * 4 + i;

            byte d1 = inBytes[4 + 4 * i]; // First half of distance data
            byte d2 = inBytes[5 + 4 * i]; // Invalid flag or second half of distance data
            byte d3 = inBytes[6 + 4 * i]; // First half of quality data
            byte d4 = inBytes[7 + 4 * i]; // Second half of quality data

            // Check for valid distance
            int distance = 0;
            if ((d2 & 0x80) >> 7 != 0) { // Valid data?
                distance = d1 | ((d2 & 0x3F) << 8);
            }

            int quality = (d4 << 8) | d3;

            this.getData(angle).angle = angle;
            this.getData(angle).distance = distance;
            this.getData(angle).quality = quality;
        }

        // TODO: Add in checksum(?) (works without in the meantime)
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
		return "Lidar";
	}

	@Override
	public void updateTable() {
		if(this._table != null) {
			this._table.putString("Boot Message", this._bootMsg);
		}
	}

	@Override
	public void startLiveWindowMode() {
		
	}

	@Override
	public void stopLiveWindowMode() {
		
	}

}
