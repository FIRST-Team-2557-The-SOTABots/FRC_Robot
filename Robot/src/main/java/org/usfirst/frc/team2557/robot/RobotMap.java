package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import org.usfirst.frc.team2557.accessories.ArduinoComm;
import org.usfirst.frc.team2557.math.EulerPositionEstimator;
import org.usfirst.frc.team2557.sensors.LidarRangeFinder;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	

    public static CANTalon driveLeft1;
    public static CANTalon driveLeft2;
    public static CANTalon driveRight1;
    public static CANTalon driveRight2;
    public static CANTalon catapultMotor;
    public static CANTalon climbingMotor;
    public static CANTalon leftActuatorMotor;
//    public static CANTalon rightActuatorMotor;
    
    public static CANTalon intakeMotor;

    public static Servo secondaryArm;

    public static DigitalInput catapultHallEffect;

    public static Accelerometer rioAccelerometer;

    private static Gyro mainGyro;
    public static AnalogOutput potentiometer;
    
    public static EulerPositionEstimator positionEstimator;

    public static LidarRangeFinder LidarSensor;

    public static ArduinoComm arduinoComm;

    public static RobotDrive robotDrive;
    
    public static boolean set = false;

    /**
     * Initializes all the parts of RobotMap. This must be called main init method
     * in Robot.java, as WPI needs to set up before these objects can be constructed.
     */
    public static void init() {
    	
    	/*
    	 * CAN ports 6, 8, 2, and 3 have encoder breakouts.
    	 */
        driveLeft1 = new CANTalon(7);
        driveLeft2 = new CANTalon(6);
        driveRight1 = new CANTalon(8);
        driveRight2 = new CANTalon(5);
        catapultMotor = new CANTalon(1);
        climbingMotor = new CANTalon(9);
        leftActuatorMotor = new CANTalon(2);
        leftActuatorMotor.enableLimitSwitch(false, false);
        leftActuatorMotor.setInverted(true);
        //        rightActuatorMotor = new CANTalon(3);

        
        intakeMotor = new CANTalon(4);

        secondaryArm = new Servo(0);

        catapultHallEffect = new DigitalInput(0);
        
        potentiometer = new AnalogOutput(1);

        rioAccelerometer = new BuiltInAccelerometer();
        mainGyro = new AnalogGyro(0);
        positionEstimator = new EulerPositionEstimator(rioAccelerometer, mainGyro);

        LidarSensor = new LidarRangeFinder(SerialPort.Port.kMXP); // Using the MXP breakout for tx/rx

        robotDrive = new RobotDrive(driveLeft1, driveLeft2, driveRight1, driveRight2);

        arduinoComm = new ArduinoComm(); // Using the MXP breakout for sda/sdt
    }

}
