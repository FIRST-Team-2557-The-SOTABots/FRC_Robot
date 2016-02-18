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
		if(Robot.oi.manipulatorBack.get()){
			Robot.manipulatorSub.setActuators(-0.35);
		}
		else if(Robot.oi.manipulatorStart.get()){
			Robot.manipulatorSub.setActuators(0.35);
		}
		else{
			Robot.manipulatorSub.setActuators(0);
		}
		
		
		
//		if(Robot.oi.manipulator.getPOV() == 0){
//			if(RobotMap.leftActuatorMotor.getEncPosition() < 0){
//				Robot.manipulatorSub.actuatorsUp();
//			}
//			else if(RobotMap.leftActuatorMotor.getEncPosition() > 0){
//				Robot.manipulatorSub.actuatorsDown();
//			}
//			else{
//				return;
//			}
//		}
//		else if(Robot.oi.manipulator.getPOV() == 2){
//			if(RobotMap.leftActuatorMotor.getEncPosition() < 45){
//				Robot.manipulatorSub.actuatorsUp();
//			}
//			else if(RobotMap.leftActuatorMotor.getEncPosition() > 45){
//				Robot.manipulatorSub.actuatorsDown();
//			}
//			else{
//				return;
//			}
//		}
//		else if(Robot.oi.manipulator.getPOV() == 4){
//			if(RobotMap.leftActuatorMotor.getEncPosition() < 45){
//				Robot.manipulatorSub.actuatorsUp();
//			}
//			else if(RobotMap.leftActuatorMotor.getEncPosition() > 45){
//				Robot.manipulatorSub.actuatorsDown();
//			}
//			else{
//				return;
//			}
//		}
//		else if(Robot.oi.manipulator.getPOV() == 6){
//			if(RobotMap.leftActuatorMotor.getEncPosition() < 45){
//				Robot.manipulatorSub.actuatorsUp();
//			}
//			else if(RobotMap.leftActuatorMotor.getEncPosition() > 45){
//				Robot.manipulatorSub.actuatorsDown();
//			}
//			else{
//				return;
//			}
//		}
//		else{
//			Robot.manipulatorSub.setActuators(0);
//		}

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
