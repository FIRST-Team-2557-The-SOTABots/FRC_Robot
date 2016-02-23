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
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void doArcade() {
    	RobotMap.robotDrive.arcadeDrive(-Robot.oi.driver.getRawAxis(1), -Robot.oi.driver.getRawAxis(4));
    }
    public void doTank(){
    	RobotMap.robotDrive.tankDrive(-Robot.oi.driver.getRawAxis(1), -Robot.oi.driver.getRawAxis(5));
    }
}

