package org.usfirst.frc.team2557.commands;

import org.usfirst.frc.team2557.Robot;
import org.usfirst.frc.team2557.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeMotorDown extends Command {

    public IntakeMotorDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.joystick1.getRawButton(5)){
    		Robot.intakeMotor.intakeReverse();
    	}
    	else if(Robot.oi.joystick1.getRawButton(6)){
    		Robot.intakeMotor.intakeForward();
    	}
    	else{
    		RobotMap.intakeMotor.set(0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
