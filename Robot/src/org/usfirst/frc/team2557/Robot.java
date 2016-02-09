// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2557.SOTABots2015;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2557.SOTABots2015.commands.*;
import org.usfirst.frc2557.SOTABots2015.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    
	Command autonomousFirst;
	Command autonomousSecond;
	Command autonomousThird;
    Command drive;
    Command dashboard;
    Command gyroReset;
    Command radarCommand;
    Command intake;
    Command lift;
    Command init;
    Command warning;
    Command autoStack;
    

    public static OI oi;
    public static DriveTrain driveWithJoystick;
    public static GyroSub gyroSub;
    public static AccelerometerSub accelerometerSub;
    public static DigitalOutput LimitSwitch;
    public static SmartDashboardSS dashboardSub;
    public static GyroReset GyroReset;
    public static Radar radarSub;
    public static LightSensors lightSensor;
    public static Pnuematics pnuematics;
    public static Manipulator manipulator;
    public static HallEffect hallEffect;
    public static MomentarySensors momentary;
    public static Encoders encoders;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RobotMap.init();
        driveWithJoystick = new DriveTrain();

        // Create a counter to tie degrees and rangefinder collection
        // The hopes of these being declared here is so they are not instantiated inside a loop
        // Where they will keep clearing themselves.
        // Let's say true is clockwise, false is counter clockwise.
        // instantiate the command used for the autonomous period
//Subsystem Initializers (must be first)
        
        dashboardSub = new SmartDashboardSS();
        drive = new Drive();
        gyroSub = new GyroSub();
        accelerometerSub = new AccelerometerSub();
        radarSub = new Radar();
        lightSensor = new LightSensors();
        pnuematics = new Pnuematics();
        manipulator = new Manipulator();
        hallEffect = new HallEffect();
        momentary = new MomentarySensors();
        encoders = new Encoders();
        
//Command Initializers (must be second)
        radarCommand = new RadarCommand();
        gyroReset = new GyroReset();
        dashboard = new Dashboard();
        autonomousFirst = new AutonomousMain();
        autonomousSecond = new AutonomousSecond();
        autonomousThird = new AutonomousThird();
        intake = new Intake();
        lift = new Lift();
        init = new AutoInitialize();
        warning = new LiftWarning();
        autoStack=new AutoStack();
        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
      
//OI (must always be the last one to be initialized)  
      oi = new OI();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	
//        if (autonomousFirst != null) autonomousFirst.start();
        if (RobotMap.autoSwitch.get() == true){
        	autonomousFirst.start();
        }
        else if(RobotMap.autoSwitch.get() == false){
        	autonomousSecond.start();
        }
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("front left enc", RobotMap.frontLeftEnc.get());
    	SmartDashboard.putNumber("front right enc", RobotMap.frontRightEnc.get());
    	SmartDashboard.putNumber("rear left enc", RobotMap.rearLeftEnc.get());
    	SmartDashboard.putNumber("rear right enc", RobotMap.rearRightEnc.get());
    	SmartDashboard.putNumber("front left dist", RobotMap.frontLeftEnc.getDistance());
    	SmartDashboard.putNumber("front left rate", RobotMap.frontLeftEnc.getRate());
        //radarCommand.start();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
//        if (autonomous != null) autonomous.cancel();
    	if (autonomousFirst != null && RobotMap.autoSwitch.get()){
        	autonomousFirst.cancel();
        }
        else if(autonomousSecond != null && RobotMap.autoSwitch.get() == false){
        	autonomousSecond.cancel();
        }
    	gyroReset.start();
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        drive.start();
        dashboard.start();
//        radarCommand.start();
        intake.start();
        lift.start();
        warning.start();
        SmartDashboard.putBoolean("The Lift sensor is reading",RobotMap.liftStop.get());
        RobotMap.intakeMotors.set(-oi.gamepad1.getRawAxis(5));
        SmartDashboard.putBoolean("AutoSwitch ", RobotMap.autoSwitch.get());
//        if(RobotMap.liftSensor.get() == true && RobotMap.liftMotor.get() > 0){
//        	RobotMap.stackCount = RobotMap.stackCount + 1;
//        }
//        else if(RobotMap.liftSensor.get() == true && RobotMap.liftMotor.get() < 0 && RobotMap.stackCount > 0){
//        	RobotMap.stackCount -= 1;
//        }
//        if(RobotMap.liftStop.get() == true){
//        	RobotMap.stackCount = 0;
//        }
//        if(RobotMap.toteStop.get() == false && RobotMap.stackCount != RobotMap.level2){
//        	autoStack.start();
//        }
        // Need to create a sub here that will perform the calculations for each reading Based on the variables.
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
        //init.start();
    }
}