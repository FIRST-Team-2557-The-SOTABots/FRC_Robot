package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ArmConfigurationCommand extends Command {

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		if(Robot.oi.manipulator.getPOV() == 0){
			if(RobotMap.armGyro.getAngle() < 45){
				Robot.manipulatorSub.actuatorsUp();
			}
			else if(RobotMap.armGyro.getAngle() > 45){
				Robot.manipulatorSub.actuatorsDown();
			}
			else{
				return;
			}
		}
		else if(Robot.oi.manipulator.getPOV() == 2){
			if(RobotMap.armGyro.getAngle() < 45){
				Robot.manipulatorSub.actuatorsUp();
			}
			else if(RobotMap.armGyro.getAngle() > 45){
				Robot.manipulatorSub.actuatorsDown();
			}
			else{
				return;
			}
		}
		else if(Robot.oi.manipulator.getPOV() == 4){
			if(RobotMap.armGyro.getAngle() < 45){
				Robot.manipulatorSub.actuatorsUp();
			}
			else if(RobotMap.armGyro.getAngle() > 45){
				Robot.manipulatorSub.actuatorsDown();
			}
			else{
				return;
			}
		}
		else if(Robot.oi.manipulator.getPOV() == 6){
			if(RobotMap.armGyro.getAngle() < 45){
				Robot.manipulatorSub.actuatorsUp();
			}
			else if(RobotMap.armGyro.getAngle() > 45){
				Robot.manipulatorSub.actuatorsDown();
			}
			else{
				return;
			}
		}
		else{
			Robot.manipulatorSub.setActuators(0);
		}

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
