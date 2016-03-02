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
        boolean fast = false;
        double speedEdit = (Math.abs(Robot.oi.driver.getRawAxis(3) + 1) / 2);
//        if(Robot.oi.manipulatorA.get()
//                && Robot.oi.manipulatorB.get()
//                && Robot.oi.manipulatorX.get()
//                && Robot.oi.manipulatorY.get()) {
//            fast = true;
//        }
        RobotMap.robotDrive.arcadeDrive(Robot.oi.driver.getRawAxis(1) * speedEdit, Robot.oi.driver.getRawAxis(0) * speedEdit);

//    	Robot.chassis.driveArcade(fast);
//    	Robot.chassis.driveTank(fast);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.chassis.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        this.end();
    }
}
