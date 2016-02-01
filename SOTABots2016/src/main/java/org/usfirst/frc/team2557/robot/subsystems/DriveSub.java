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
    CANTalon left    = RobotMap.motorLeft;
    CANTalon right   = RobotMap.motorRight;
    RobotDrive drive = RobotMap.arcadeDrive;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void doArcade() {
    	  //Liam: added arcade drive 1/21/16
    	drive.arcadeDrive(Robot.oi.stick1);
    }
}

