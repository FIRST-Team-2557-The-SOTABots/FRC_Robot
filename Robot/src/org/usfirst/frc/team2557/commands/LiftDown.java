package org.usfirst.frc2557.SOTABots2015.commands;

import org.usfirst.frc2557.SOTABots2015.Robot;
import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftDown extends Command {
	
//	int currentLevel = RobotMap.liftLevel;
//	boolean done;
//	int minLevel = RobotMap.minLiftLevel;

    public LiftDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
//    	requires(Robot.manipulator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	done = false;
//    	Robot.manipulator.liftDown();
//    	if(currentLevel == minLevel){
//    		end();
//    		done = true;
//    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if(currentLevel > RobotMap.liftLevel){
//    		done = true;
//    	}
//    	else{
//    		done = false;
//    	}
    	Robot.manipulator.liftDown();
    	Timer.delay(2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return done;
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.manipulator.liftStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//    	done = true;
//    	end();
    }
}
