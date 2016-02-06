package org.usfirst.frc2557.SOTABots2015.commands;

import org.usfirst.frc2557.SOTABots2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterOnRamp extends Command {
	
	boolean found;

    public CenterOnRamp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lightSensor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	found = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.lightSensor.checkLeft()){
    		//turn left
    	}
    	else if(Robot.lightSensor.checkRight()){
    		//turn right
    	}
    	else{
    		//drive straight
    	}
    	if(Robot.lightSensor.checkLeft() && Robot.lightSensor.checkRight()){
    		found = true;
    	}
    	else{
    		found = false;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return found;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Stop driving
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
