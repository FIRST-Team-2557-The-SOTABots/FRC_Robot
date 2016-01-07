package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.*;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static CANTalon frontLeft;
	public static CANTalon frontRight;
	public static SpeedController backLeft;
	public static SpeedController backRight;
	public static SpeedController intakeMotor;
	public static SpeedController winchMotor;
	
	public static DoubleSolenoid intakeArm;
	public static DoubleSolenoid winchSolenoid;
	public static DoubleSolenoid driveShift;
	
	public static DigitalInput hallEffect;
	public static DigitalInput lightSensor;
	public static Counter leftDriveEncoder;
	public static Counter rightDriveEncoder;
	public static Counter winchEncoder;
	
	public static RobotDrive robotDrive;
	
	public static int winchEncoderCount;
	public static double rightEncoderRate;
	public static double leftEncoderRate;
	
	public static Timer time;
	public static double timerValue;
	
	public static boolean hallValue;
	
	
	public static void init(){
		frontRight = new CANTalon(1, 0);
		
		
	}
	
	
	
	
}
