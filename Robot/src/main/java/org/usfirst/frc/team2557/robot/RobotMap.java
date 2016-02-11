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
    public static CANTalon frontLeft;
    public static CANTalon frontRight;
    public static CANTalon backLeft; //Added the other 2 motors to the drive train Antonio 2/2
    public static CANTalon backRight; //Added the other 2 motors to the drive train Antonio 2/2

    //Liam: added robotdrive 1/21/16	//Moved the robot drive and its comment to be below the motors -H 1/22/16
    public static RobotDrive arcadeDrive;

    //moved the solenoids from below the counter/encoders to above the analog inputs -H 1/22
    public static DoubleSolenoid DSolenoid1; //Added two Double Solenoids
    public static DoubleSolenoid DSolenoid2; //Might Add another if needed

    public static AnalogInput RangeFinderF; //Added Two range finders
    public static AnalogInput RangeFinderL; //More may be added if needed
    public static AnalogInput RangeFinderR; //Added two more range finders also renamed the existing ones
    public static AnalogInput RangeFinderB; //and change where they were refernce to mathc

    //added the limit switches 1/21/16
    public static DigitalInput limitswitch;
    public static DigitalInput limitswitch2;

    //added this DI 1/22/16
    public static DigitalInput LimitLimitSwitch;

    public static LidarRangeFinder LidarSensor; //This is for the lidar sensor

    //added the Encoders on 1/21/16.D  //Moved this little section to be below the inputs -H 1/22
    public static Encoder LeftEnc;
    public static Encoder RightEnc;

    public static double RFF; //A declared double in the robot map that is for the front range finder 1/22
    public static double RFL; //A declared double in the robot map that is for the left range finder 1/22
    public static double RFR; //A declared double in the robot map that is for the right range finder
    public static double RFB; //A declared double in the robot map that is for the back range finder


    /**
     * Initializes all the parts of RobotMap. This must be called main init method
     * in Robot.java, as WPI needs to set up before these objects can be constructed.
     */
    public static void init() {
        frontLeft = new CANTalon(0);
        frontRight = new CANTalon(1);
        backLeft = new CANTalon(2);
        backRight = new CANTalon(3);

        arcadeDrive = new RobotDrive(frontLeft, frontRight, backLeft, backRight);

        DSolenoid1 = new DoubleSolenoid(0, 0, 1);
        DSolenoid2 = new DoubleSolenoid(0, 2, 3);

        RangeFinderF = new AnalogInput(0);
        RangeFinderL = new AnalogInput(1);
        RangeFinderR = new AnalogInput(2);
        RangeFinderB = new AnalogInput(3);

        limitswitch = new DigitalInput(0);
        limitswitch2 = new DigitalInput(1);

        LimitLimitSwitch = new DigitalInput(2);

        LidarSensor = new LidarRangeFinder();

        LeftEnc = new Encoder(3, 4);
        RightEnc = new Encoder(5, 6);
    }

}
