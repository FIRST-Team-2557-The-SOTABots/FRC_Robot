package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import org.usfirst.frc.team2557.accessories.ArduinoComm;
import org.usfirst.frc.team2557.math.EulerDistanceEstimator;
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
    public static CANTalon rightActuatorMotor;
    
    public static CANTalon intakeMotor;

    public static Servo secondaryArm;

    public static DigitalInput catapultHallEffect;

    public static Accelerometer rioAccelerometer;

    public static Gyro mainGyro;
    
    public static AnalogInput leftPotentiometer;
    public static AnalogInput rightPotentiometer;

    public static EulerDistanceEstimator distanceEstimator;

    public static LidarRangeFinder lidarSensor;

    public static ArduinoComm arduinoComm;

    public static RobotDrive robotDrive;

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
        intakeMotor = new CANTalon(4);

        leftActuatorMotor = new CANTalon(2);
        leftActuatorMotor.enableLimitSwitch(false, false);
        leftActuatorMotor.enableBrakeMode(true);
        rightActuatorMotor = new CANTalon(3);
        rightActuatorMotor.enableLimitSwitch(false, false);
        rightActuatorMotor.enableBrakeMode(true);

        secondaryArm = new Servo(4);

        catapultHallEffect = new DigitalInput(0);

        rioAccelerometer = new BuiltInAccelerometer();

        mainGyro = new AnalogGyro(0);

        leftPotentiometer = new AnalogInput(1);
        rightPotentiometer = new AnalogInput(2);

        // The roborio's accelerometer's y-axis is pointing towards the front of the robot
        // NOTE: The practice bot's forward axis is NegY!!
        distanceEstimator = new EulerDistanceEstimator(rioAccelerometer, EulerDistanceEstimator.ForwardAxis.Y);

        lidarSensor = new LidarRangeFinder(SerialPort.Port.kMXP); // Using the MXP breakout for tx/rx (serial)

        robotDrive = new RobotDrive(driveLeft1, driveLeft2, driveRight1, driveRight2);
        robotDrive.setExpiration(0.2);
        robotDrive.setSafetyEnabled(false);

        arduinoComm = new ArduinoComm(); // Using the MXP breakout for sda/sdt (i2c)
    }

}
