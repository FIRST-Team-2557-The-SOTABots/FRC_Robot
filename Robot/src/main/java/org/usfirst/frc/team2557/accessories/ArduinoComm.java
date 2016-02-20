package org.usfirst.frc.team2557.accessories;

import edu.wpi.first.wpilibj.I2C;

public class ArduinoComm {

    public enum LightsMode {
        Purple,
        Green,
        Orange,
        SafetyYellow,
        Nothing
    }

    private I2C _arduino;

    public ArduinoComm() {
        this._arduino = new I2C(I2C.Port.kMXP, 8);
    }

    public void changeMode(LightsMode mode) {
        this._arduino.transaction(new byte[] { (byte) mode.ordinal() }, 1, null, 0);
    }

}
