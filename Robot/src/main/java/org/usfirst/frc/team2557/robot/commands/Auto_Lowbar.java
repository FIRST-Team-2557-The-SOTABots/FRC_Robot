package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_Lowbar extends Command {

    public Auto_Lowbar() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//This will only work if the range finders are in the back of the robot. Added 1/21/16.
    	//This will now work. Changed code on 1/22/16.
//    	if(RobotMap.RangeFinderB.getVoltage()>5){
//    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
//    	}
    	Robot.autonomous.lowBar(); //Put the above lines of code into a method within the autonomous subsystem 1/23/16
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.RangeFinderB.getVoltage()<=5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.robotDrive.arcadeDrive(0,	0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
