package org.usfirst.frc2557.SOTABots2015.commands;

import org.usfirst.frc2557.SOTABots2015.Robot;
import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoLiftUp extends Command {
	private double time;
    public AutoLiftUp(double x) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.manipulator);
    	requires(Robot.hallEffect);
    	time = x;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.manipulator.liftUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return count == 2;
    	return isTimedOut();
    	//return RobotMap.liftSensor.get() == true;
    	//return Robot.hallEffect.checkLift();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.manipulator.liftStop();
    	RobotMap.stackCount = RobotMap.level2;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
