
package org.usfirst.frc.team2557;

import org.usfirst.frc.team2557.subsystems.*;
import org.usfirst.frc.team2557.commands.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drivetrain drivetrain;
	public static DriveShift driveShift;
	public static IntakeArm intakeArm;
	public static IntakeMotor intakeMotor;
	public static LeftDriveEncoder leftDriveEncoder;
	public static RightDriveEncoder rightDriveEncoder;
	public static Timer timer;
	public static WinchEncoder winchEncoder;
	public static WinchMotor winchMotor;
	public static WinchSolenoid winchSolenoid;
	public static HallEffect hallEffect;
	public static RearRightMotor rearRightMotor;
	public static RearLeftMotor rearLeftMotor;
	public static FrontRightMotor frontRightMotor;
	public static FrontLeftMotor frontLeftMotor;
	public static JoystickAxes joystickAxes;
	public static ThrottleTimer throttleTimer;
	public static GradualSpeedIncreaseSub gradualSpeedIncreaseSub;
	public static LightSensor lightSensor;
	

    Command autonomousCommand;
    Command driveTele;
    Command frontLeftVoltage;
    Command frontRightVoltage;
    Command getOldData;
    Command getTime;
    Command getXJoystickAxis;
    Command getYJoystickAxis;
    Command gradualSpeedIncreaseCommand;
    Command hallCheck;
    Command intakeMotorDown;
    Command intakeMotorUp;
    Command leftDriveEncoderRate;
    Command lightGet;
    Command lightLaunch;
    Command rearLeftVoltage;
    Command rearRightVoltage;
    Command rightDriveEncoderRate;
    Command setTime;
    Command shift;
    Command winchDown;
    Command winchEncoderCount;
    Command winchSolenoidLaunch;
    Command winchSolenoidLock;
    Command winchTimer;
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		
		/////SUBSYSTEMS/////
		drivetrain = new Drivetrain();
		driveShift = new DriveShift();
		frontRightMotor = new FrontRightMotor();
		frontLeftMotor = new FrontLeftMotor();		
		gradualSpeedIncreaseSub = new GradualSpeedIncreaseSub();
		hallEffect = new HallEffect();
		intakeArm = new IntakeArm();
		intakeMotor = new IntakeMotor();
		joystickAxes = new JoystickAxes();
		leftDriveEncoder = new LeftDriveEncoder();
		lightSensor = new LightSensor();
		throttleTimer = new ThrottleTimer();
		timer = new Timer();
		rearRightMotor = new RearRightMotor();
		rearLeftMotor = new RearLeftMotor();
		rightDriveEncoder = new RightDriveEncoder();
		winchMotor = new WinchMotor();
		winchEncoder = new WinchEncoder();
		winchSolenoid = new WinchSolenoid();
		
		
		/////COMMANDS/////
		autonomousCommand = new Autonomous();
		driveTele = new DriveTele();
		frontLeftVoltage = new FrontLeftVoltage();
		frontRightVoltage = new FrontRightVoltage();
		getOldData = new GetOldData();
		getTime = new GetTime();
		getXJoystickAxis = new GetXJoystickAxis();
		getYJoystickAxis = new GetYJoystickAxis();
		gradualSpeedIncreaseCommand = new GradualSpeedIncreaseCommand();
		hallCheck = new HallCheck();
		intakeMotorDown = new IntakeMotorDown();
		intakeMotorUp = new IntakeMotorUp();
		leftDriveEncoderRate = new LeftDriveEncoderRate();
		lightGet = new LightGet();
		lightLaunch = new LightLaunch();
		rearLeftVoltage = new RearLeftVoltage();
		rearRightVoltage = new RearRightVoltage();
		rightDriveEncoderRate = new RightDriveEncoderRate();
		setTime = new SetTime();
		shift = new Shift();
		winchDown = new WinchDown();
		winchEncoderCount = new WinchEncoderCount();
		winchSolenoidLaunch = new WinchSolenoidLaunch();
		winchSolenoidLock = new WinchSolenoidLock();
		winchTimer = new WinchTimer();
		
		
        // instantiate the command used for the autonomous period
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }
    

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        lightLaunch.start();
        lightGet.start();
        
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	setTime.start();
    	hallCheck.start();
    	winchTimer.start();
    	winchSolenoidLock.start();
        Scheduler.getInstance().run();
        if(oi.joystick1.getRawAxis(0) > 0 && gradualSpeedIncreaseCommand.isRunning() == false && getOldData.isRunning() == false){
        	gradualSpeedIncreaseCommand.start();
        	getOldData.start();
        	
        }
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
