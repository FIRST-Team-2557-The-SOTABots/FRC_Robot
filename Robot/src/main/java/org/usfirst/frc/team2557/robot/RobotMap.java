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

    public static CANTalon driveFrontLeft;
    public static CANTalon driveFrontRight;
    public static CANTalon driveBackLeft;
    public static CANTalon driveBackRight;
    public static CANTalon catapultMotor;
    public static CANTalon climbingMotor;
    public static CANTalon leftActuatorMotor;
    public static CANTalon rightActuatorMotor;
    public static CANTalon intakeMotor;

    public static Servo secondaryArm;
    
    public static AnalogGyro armGyro;

    public static Encoder leftActuatorEncoder;
    public static Encoder rightActuatorEncoder;

    public static DigitalInput catapultHallEffect;

    public static LidarRangeFinder LidarSensor;

    public static RobotDrive robotDrive;
    
    public static double x = 0.5;
    public static double y = 0.5;
    public static double target = 40;
    /**
     * Initializes all the parts of RobotMap. This must be called main init method
     * in Robot.java, as WPI needs to set up before these objects can be constructed.
     */
    public static void init() {
    	
        driveFrontLeft = new CANTalon(0);
        driveFrontRight = new CANTalon(1);
        driveBackLeft = new CANTalon(2);
        driveBackRight = new CANTalon(3);
        catapultMotor = new CANTalon(4);
        climbingMotor = new CANTalon(5);
        leftActuatorMotor = new CANTalon(6);
        rightActuatorMotor = new CANTalon(7);
        intakeMotor = new CANTalon(8);

        armGyro = new AnalogGyro(0);

        secondaryArm = new Servo(1);
        
        leftActuatorEncoder = new Encoder(1, 2);
        rightActuatorEncoder = new Encoder(3, 4);

        catapultHallEffect = new DigitalInput(0);

        LidarSensor = new LidarRangeFinder(SerialPort.Port.kMXP); // Using the MXP breakout for tx/rx

        robotDrive = new RobotDrive(driveFrontLeft, driveFrontRight, driveBackLeft, driveBackRight);
    }

}
