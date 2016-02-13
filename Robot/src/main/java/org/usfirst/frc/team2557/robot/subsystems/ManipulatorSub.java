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
	
}
