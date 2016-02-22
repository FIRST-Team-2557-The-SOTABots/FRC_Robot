package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ManipulatorSub extends Subsystem {

	protected void initDefaultCommand() {

	}

	public void catapult() {
		if (RobotMap.catapultHallEffect.get()) {
			RobotMap.catapultMotor.set(-.25);
		} else if (Robot.oi.manipulatorStart.get()){
			RobotMap.catapultMotor.set(-.9);
		} else{
			RobotMap.catapultMotor.set(0);
		}
	}

	public void intake() {
		if (Robot.oi.manipulatorLB.get()) {
			RobotMap.intakeMotor.set(-.5);
		} else if (Robot.oi.manipulatorRB.get()) {
			RobotMap.intakeMotor.set(.5);
		} else {
			RobotMap.intakeMotor.set(0);
		}
	}

	double Actuators_Kp = 0.03; // Adjust Kp as necessary

	public void setActuators(double speed) {
		RobotMap.leftActuatorMotor.set(speed);
		// TODO: Right Talon PID with left Talon encoder
//		RobotMap.rightActuatorMotor.set(speed);
	}

	public void climbTower() {
		if (Robot.oi.driver.getRawAxis(2) > 0.5 && Robot.oi.driver.getRawAxis(3) > 0.5) {
			RobotMap.climbingMotor.set(1);
		} else {
			RobotMap.climbingMotor.set(0);
		}
	}

	public void secondArmRelease() {
		RobotMap.secondaryArm.setAngle(90); //Subject to change since this is an arbitrary setting
	}
}