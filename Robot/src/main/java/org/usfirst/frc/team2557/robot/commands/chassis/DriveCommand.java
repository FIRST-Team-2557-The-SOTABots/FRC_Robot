package org.usfirst.frc.team2557.robot.commands.chassis;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {

    public DriveCommand() {
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double speedEdit = 1 - (Robot.oi.driver.getRawAxis(3) + 1) / 2;

        // Calculate arcade drive so we can use our custom "set" method
        double power = -Robot.oi.driver.getRawAxis(1);
        double turn = -Robot.oi.driver.getRawAxis(0);
        Robot.chassis.set((power - turn) * speedEdit,
                (power + turn) * speedEdit);

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
        this.end();
    }
}
