package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_Moat extends Command {

    public Auto_Moat() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//This will only work if the rangeFinders are in the Front. Added 1/21/16.
//    	if(RobotMap.RangeFinderF.getVoltage()>10){ 
//    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
//    	}
    	Robot.autonomous.moat(); //Put the above lines of code into a method within the autonomous subsystem 1/23/16
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.RangeFinderF.getVoltage()<=10;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.robotDrive.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
