package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_RoughTerrain_Rotation extends Command {

    public Auto_RoughTerrain_Rotation() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.autonomous.roughTerrainRotation();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.RangeFinderF.getVoltage()<=4 && RobotMap.RangeFinderL.getVoltage()<=12 && RobotMap.RangeFinderR.getVoltage()<=16;
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
