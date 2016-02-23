package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ManipulatorSub extends Subsystem {

	protected void initDefaultCommand() {

	}

	public void catapult() {
		
		if (RobotMap.catapultHallEffect.get() == false){
			RobotMap.set = true;
		}
		
		if (RobotMap.catapultHallEffect.get() && Robot.oi.manipulatorStart.get() == false && RobotMap.set == false) {
			RobotMap.catapultMotor.set(-.75);
		} else if (Robot.oi.manipulatorStart.get()){
			RobotMap.catapultMotor.set(-1);
			RobotMap.set = false;
		} else{
			RobotMap.catapultMotor.set(0);
		}
	}

	double Actuators_Kp = 0.03; // Adjust Kp as necessary

	public void setActuators(double speed) {
		RobotMap.leftActuatorMotor.set(speed);
		// TODO: Right Talon PID with left Talon encoder
//		RobotMap.rightActuatorMotor.set(speed);
	}

}