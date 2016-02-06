package org.usfirst.frc2557.SOTABots2015.commands;

import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoLiftDown extends Command {
	private double time;
    public AutoLiftDown(double x) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	time = x;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.liftMotor.set(-.7);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.liftStop.get() == true || isTimedOut(); // || RobotMap.liftSensor.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.liftMotor.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
