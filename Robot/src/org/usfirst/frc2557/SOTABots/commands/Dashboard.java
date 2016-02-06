package org.usfirst.frc2557.SOTABots2015.commands;

import org.usfirst.frc2557.SOTABots2015.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Dashboard extends Command {

    public Dashboard() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.rangeSub);
    	requires(Robot.dashboardSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {               
    	Robot.dashboardSub.rangeOutputs();
    	Robot.dashboardSub.encoderOutput();
    	Robot.dashboardSub.locationOutput();
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
