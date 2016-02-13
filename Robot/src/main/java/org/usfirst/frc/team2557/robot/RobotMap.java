package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team2557.sensors.LidarRangeFinder;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    //
    //added motors ¯\_(ツ)_/¯
    //Liam: fixed port errors made by sam, renamed motors to motorLeft and motorRight from motor1 and motor2, respectively. 1/21/16
    public static CANTalon frontLeft = new CANTalon(0);
    public static CANTalon frontRight = new CANTalon(1);
    public static CANTalon backLeft = new CANTalon(2); //Added the other 2 motors to the drive train Antonio 2/2
    public static CANTalon backRight = new CANTalon(3); //Added the other 2 motors to the drive train Antonio 2/2

    //Liam: added robotdrive 1/21/16	//Moved the robot drive and its comment to be below the motors -H 1/22/16
    public static RobotDrive robotDrive = new RobotDrive(frontLeft, frontRight, backLeft, backRight);

    //moved the solenoids from below the counter/encoders to above the analog inputs -H 1/22
    public static DoubleSolenoid DSolenoid1 = new DoubleSolenoid(0,0,1); //Added two Double Solenoids
    public static DoubleSolenoid DSolenoid2 = new DoubleSolenoid(0,2,3); //Might Add another if needed

    //added the limit switches 1/21/16
    public static DigitalInput limitswitch = new DigitalInput(0);
    public static DigitalInput limitswitch2 = new DigitalInput(1);

    //added this DI 1/22/16
    public static DigitalInput LimitLimitSwitch = new DigitalInput(2);

    public static LidarRangeFinder LidarSensor = new LidarRangeFinder(); //This is for the lidar sensor

    //added the Encoders on 1/21/16.D  //Moved this little section to be below the inputs -H 1/22
    public static Encoder LeftEnc = new Encoder(3,4);
    public static Encoder RightEnc = new Encoder(5,6);

    /**
     * Initializes all the parts of RobotMap. This must be called main init method
     * in Robot.java, as WPI needs to set up before these objects can be constructed.
     */
    public static void init() {
    }

}
