
package org.usfirst.frc.team2557.robot;

import org.usfirst.frc.team2557.robot.subsystems.*;

import org.usfirst.frc.team2557.robot.commands.SetTime;

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
	

    Command autonomousCommand;
    Command DriveTele;
    Command WinchDown;
    Command Shift;
    Command FrontLeftVoltage;
    Command FrontRightVoltage;
    Command GetTime;
    Command GetXJoystickAxis;
    Command GetYJoystickAxis;
    Command HallCheck;
    Command IntakeMotorDown;
    Command IntakeMotorUp;
    Command LeftDriveEncoderRate;
    Command RearLeftVoltage;
    Command RearRightVoltage;
    Command RightDriveEncoderRate;
    Command SetTime;
    Command WinchEncoderCount;
    Command WinchSolenoidLaunch;
    Command WinchSolenoidLock;
    Command WinchTimer;
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		drivetrain = new Drivetrain();
		winchMotor = new WinchMotor();
		driveShift = new DriveShift();
		intakeArm = new IntakeArm();
		intakeMotor = new IntakeMotor();
		leftDriveEncoder = new LeftDriveEncoder();
		rightDriveEncoder = new RightDriveEncoder();
		timer = new Timer();
		winchEncoder = new WinchEncoder();
		winchMotor = new WinchMotor();
		winchSolenoid = new WinchSolenoid();
		hallEffect = new HallEffect();
		rearRightMotor = new RearRightMotor();
		rearLeftMotor = new RearLeftMotor();
		frontRightMotor = new FrontRightMotor();
		frontLeftMotor = new FrontLeftMotor();
		joystickAxes = new JoystickAxes();
		
		SetTime = new SetTime();
		
		
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
    	SetTime.start();
        Scheduler.getInstance().run();
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
