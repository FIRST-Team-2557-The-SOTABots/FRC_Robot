package org.usfirst.frc.team2557.robot;

//import org.usfirst.frc.team2557.robot.subsystems.LidarRangeFinder;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Gyro;

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
        leftActuatorMotor = new CANTalon(2);
        driveLeft1.setInverted(true);
        driveLeft2.setInverted(true);
        driveRight1.setInverted(false);
        driveRight2.setInverted(false);
        

        leftActuatorMotor.enableLimitSwitch(false, false);
        rightActuatorMotor = new CANTalon(3);
        rightActuatorMotor.enableLimitSwitch(false, false);
        intakeMotor = new CANTalon(4);

        secondaryArm = new Servo(0);

        catapultHallEffect = new DigitalInput(0);

        rioAccelerometer = new BuiltInAccelerometer();

        mainGyro = new AnalogGyro(0);

        leftPotentiometer = new AnalogInput(1);
        rightPotentiometer = new AnalogInput(2);


        robotDrive = new RobotDrive(driveLeft1, driveLeft2, driveRight1, driveRight2);
        robotDrive.setExpiration(0.2);
        robotDrive.setSafetyEnabled(false);
        

    }

}
