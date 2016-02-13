package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_DrawBridge extends Command {

    public Auto_DrawBridge() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//This allows the Robot to move to the Draw Bridge to get into range for the manipulator to open the drawbridge.
    	//Since their is no manipulator yet this will allow us to get to the Draw Bridge.
    	//Added 1/22/16.
//    	if(RobotMap.RangeFinderF.getVoltage()>4 ){
//    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
//    	}
    	Robot.autonomous.drawBridge(); //Put the above lines of code into a method within the autonomous subsystem 1/23/16
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.RangeFinderF.getVoltage()<=4;
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
