package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Lowbar_Auto extends Command {

    public Lowbar_Auto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.autonomous);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//This will only work if the range finders are in the back of the robot. Added 1/21/16.
    	if(RobotMap.RangeFinderRight1.getVoltage()>5 && RobotMap.RangeFinderLeft2.getVoltage()>3){
    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
    	}
    	
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.RangeFinderRight1.getVoltage()<=5 && RobotMap.RangeFinderLeft2.getVoltage()<=5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.arcadeDrive.arcadeDrive(0,	0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
