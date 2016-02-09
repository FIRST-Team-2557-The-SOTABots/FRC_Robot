package org.usfirst.frc.team2557;

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
	
	public static CANTalon frontLeft = new CANTalon(4);
	public static CANTalon frontRight = new CANTalon(5);
	public static CANTalon backLeft = new CANTalon(0);
	public static CANTalon backRight = new CANTalon(1);
	public static CANTalon intakeMotor = new CANTalon(3);
	public static CANTalon winchMotor = new CANTalon(2);
	
	public static DoubleSolenoid intakeArm = new DoubleSolenoid (0,2,3);
	public static DoubleSolenoid winchSolenoid = new DoubleSolenoid(0,0,1);
	public static DoubleSolenoid driveShift = new DoubleSolenoid(0,4,5);
	
	public static DigitalInput hallEffect = new DigitalInput(0);
	public static DigitalInput lightSensor = new DigitalInput(1);
	public static Encoder leftDriveEncoder = new Encoder(2,3);
	public static Encoder rightDriveEncoder = new Encoder(4,5);
	public static Encoder winchEncoder = new Encoder(6,7);
	
	public static RobotDrive robotDrive = new RobotDrive(frontLeft, frontRight, backLeft, backRight);
	
	public static int winchEncoderCount;
	public static double rightEncoderRate;
	public static double leftEncoderRate;
	
	public static Timer time;
	public static double timerValue;
	public static double oldTime;
	public static double oldThrottle;
	
	public static boolean hallValue;
	public static boolean lightValue;
	
	public static double jx;
	public static double jy;
	public static double x;
	public static double y;
	public static double c;
	
	public static double frontLeftVoltage;
	public static double frontRightVoltage;
	public static double rearLeftVoltage;
	public static double rearRightVoltage;
	public static double lowSpeed;
	
	public static double briefSave;
	
	
	public static void init(){
		
		
	}
	
	
	
	
}
