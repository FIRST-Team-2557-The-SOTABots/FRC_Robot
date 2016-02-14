package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ManipulatorSub extends Subsystem {

	protected void initDefaultCommand() {
		
	}
	
	public void catapult(){
		if(RobotMap.catapultHallEffect.get() == false && Robot.oi.manipulatorStart.get() == false){
			RobotMap.catapultMotor.set(Math.abs(Robot.oi.manipulator.getRawAxis(3)));
		}
		else{
			RobotMap.catapultMotor.set(0);
		}
	}
	public void intake(){
		if(Robot.oi.manipulatorLB.get()){
			RobotMap.intakeMotor.set(.5);
		}
		else if(Robot.oi.manipulatorRB.get()){
			RobotMap.intakeMotor.set(.5);
		}
		else{
			RobotMap.intakeMotor.set(0);
		}
	}
	public void actuatorsUp(){
		RobotMap.leftActuatorMotor.set(RobotMap.x);
		RobotMap.rightActuatorMotor.set(RobotMap.y);
		if(RobotMap.leftActuatorEncoder.getRate() > RobotMap.target){
			RobotMap.x = RobotMap.x - 0.1;
		}
		else if(RobotMap.leftActuatorEncoder.getRate() < RobotMap.target){
			RobotMap.x = RobotMap.x + 0.1;
		}
		
		if(RobotMap.rightActuatorEncoder.getRate() > RobotMap.target){
			RobotMap.y = RobotMap.y - 0.1;
		}
		else if(RobotMap.rightActuatorEncoder.getRate() < RobotMap.target){
			RobotMap.y = RobotMap.y + 0.1;
		}
	}
	public void actuatorsDown(){
		RobotMap.leftActuatorMotor.set(-RobotMap.x);
		RobotMap.rightActuatorMotor.set(-RobotMap.y);
		if(Math.abs(RobotMap.leftActuatorEncoder.getRate()) > RobotMap.target){
			RobotMap.x = RobotMap.x - 0.1;
		}
		else if(Math.abs(RobotMap.leftActuatorEncoder.getRate()) < RobotMap.target){
			RobotMap.x = RobotMap.x + 0.1;
		}
		
		if(Math.abs(RobotMap.rightActuatorEncoder.getRate()) > RobotMap.target){
			RobotMap.y = RobotMap.y - 0.1;
		}
		else if(Math.abs(RobotMap.rightActuatorEncoder.getRate()) < RobotMap.target){
			RobotMap.y = RobotMap.y + 0.1;
		}
	}
	public void climbTower(){
		if(Robot.oi.driver.getRawAxis(2) > 0.5 && Robot.oi.driver.getRawAxis(3) > 0.5){
			RobotMap.climbingMotor.set(1);
		}
		else{
			RobotMap.climbingMotor.set(0);
		}
	}
	public void secondArmRelease(){
		RobotMap.secondaryArm.setAngle(90);
	}
	
}
