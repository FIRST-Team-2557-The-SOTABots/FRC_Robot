package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SecondArmReleaseCommand extends Command{

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		if(Robot.oi.driverBack.get() && Robot.oi.driverStart.get()){
			Robot.manipulatorSub.secondArmRelease();
		}
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
