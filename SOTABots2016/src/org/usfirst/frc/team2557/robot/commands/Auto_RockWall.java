package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_RockWall extends Command {
//Lol
    public Auto_RockWall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//Will only work if the RangeFineders are in the Front. and above the drive train. Added 1/22/16.
    	if(RobotMap.RangeFinderF.getVoltage()>10){
    		
    		RobotMap.arcadeDrive.arcadeDrive(.5,0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.RangeFinderF.getVoltage()<=10;
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
