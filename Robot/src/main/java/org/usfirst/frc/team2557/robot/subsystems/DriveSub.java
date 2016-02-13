package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSub extends Subsystem {
	  //Liam: Added motors and drive 1/21/16
    CANTalon frontLeft    = RobotMap.driveFrontLeft;
    CANTalon frontRight   = RobotMap.driveFrontRight;
    CANTalon backLeft	  = RobotMap.driveBackLeft;
    CANTalon backRight	  = RobotMap.driveBackRight;
    RobotDrive robotDrive = RobotMap.robotDrive;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void doArcade() {
    	robotDrive.arcadeDrive(Robot.oi.driver.getRawAxis(1), Robot.oi.driver.getRawAxis(0));
    }
    public void doTank(){
    	robotDrive.tankDrive(Robot.oi.driver.getRawAxis(1), Robot.oi.driver.getRawAxis(5));
    }
}

