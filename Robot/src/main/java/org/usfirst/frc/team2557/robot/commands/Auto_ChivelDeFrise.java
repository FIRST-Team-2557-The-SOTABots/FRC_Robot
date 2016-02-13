package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_ChivelDeFrise extends Command {

    public Auto_ChivelDeFrise() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//This is saying that the subsystem which is called autonomous will have the code that is neccassary for the robot to start.
    	// even thought that this is autonomous that robot still has to be able to receive commands through all of the necassary
    	//The comment below in this section of the code shows what was there.
    	//The command of which tells the robot to look at the method stated above or below depending in what you want to do
    	//Modified on 1/22/16.
//    	if(RobotMap.RangeFinderF.getVoltage()>4 ){
//    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
//    	}
    	Robot.autonomous.chivelDeFrise(); //Put the above lines of code into a method within the autonomous subsystem 1/23/16
    	//Antonio was the one who made changes in this command to make it so that the method would include this.
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.RangeFinderF.getVoltage()<=4;
        //this tells the robot to set the statement above to false unless actually updated.
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
