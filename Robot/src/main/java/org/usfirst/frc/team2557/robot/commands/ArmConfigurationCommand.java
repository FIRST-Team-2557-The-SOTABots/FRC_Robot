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
//		if(Robot.oi.manipulatorBack.get()){
//			Robot.manipulatorSub.setActuators(-0.35);
//		}
//		else if(Robot.oi.manipulatorStart.get()){
//			Robot.manipulatorSub.setActuators(0.35);
//		}
//		else{
//			Robot.manipulatorSub.setActuators(0);
//		}
		
		if(Robot.oi.manipulator.getPOV() == 0){
			if(RobotMap.leftActuatorMotor.getEncPosition()/900 < 0){
				Robot.manipulatorSub.setActuators(-.5);
			}	else if(RobotMap.leftActuatorMotor.getEncPosition()/900 > 0){
				Robot.manipulatorSub.setActuators(.5);
			}
		}	else if(Robot.oi.manipulator.getPOV() == 90){
			if(RobotMap.leftActuatorMotor.getEncPosition()/900 < -35){
				Robot.manipulatorSub.setActuators(-.5);
			}	else if(RobotMap.leftActuatorMotor.getEncPosition()/900 > -35){
				Robot.manipulatorSub.setActuators(.5);
			}
		}	else if(Robot.oi.manipulator.getPOV() == 180){
			if(RobotMap.leftActuatorMotor.getEncPosition()/900 < -150){
				Robot.manipulatorSub.setActuators(-.5);
			}	else if(RobotMap.leftActuatorMotor.getEncPosition()/900 > -150){
				Robot.manipulatorSub.setActuators(.5);
			}
		}	else if(Robot.oi.manipulator.getPOV() == 270){
			if(RobotMap.leftActuatorMotor.getEncPosition()/900 < 45){
				Robot.manipulatorSub.setActuators(-.5);
			}	else if(RobotMap.leftActuatorMotor.getEncPosition()/900 > 45){
				Robot.manipulatorSub.setActuators(.5);
			}
		}	else{
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
