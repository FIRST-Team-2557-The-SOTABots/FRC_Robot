package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SmartDashboardCommand extends Command {

	protected void initialize() {
		
	}

	protected void execute() {
		Robot.smartDashboardSub.voltageCheck();
		Robot.smartDashboardSub.EncoderCheck();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}

}
