package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_SallyPort extends Command {

    public Auto_SallyPort() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//This code is pretty much the same as the Draw Bridge but is for the sally port instead
    	//and like always this will only work if the rangeFinders are in the front to register the doors of the drawbridge and the sally port
    	//Added 1/22/16.
    	if(RobotMap.RangeFinderF.getVoltage()>4){
    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.RangeFinderF.getVoltage()<=4;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.arcadeDrive.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
