package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_ChivelDeFrise_Rotation extends Command {

    public Auto_ChivelDeFrise_Rotation() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//Created this autonomous on 1/25/16.
    	//This is part of the subsystem that is called autonomous in which the robot will do what ever it is told to do given a certain parameters.
    	//This is in the method.
    	Robot.autonomous.chivelDeFriserotation();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       //Once this statement is true the robot will stop the action and make it so that the robot will be ready for the next operation
    	return RobotMap.RangeFinderF.getVoltage()<=4 && RobotMap.RangeFinderL.getVoltage()<=12 && RobotMap.RangeFinderR.getVoltage()<=16;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//This is telling the robot that once the above statement is true that the robot should stop in its tracks.
    	RobotMap.robotDrive.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
