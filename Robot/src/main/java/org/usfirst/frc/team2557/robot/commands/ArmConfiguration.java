package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ArmConfiguration extends Command {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
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
			RobotMap.leftActuatorMotor.set(0);
			RobotMap.rightActuatorMotor.set(0);
		}

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
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
