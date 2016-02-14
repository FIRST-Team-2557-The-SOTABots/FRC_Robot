package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ManipulatorSub extends Subsystem {

	protected void initDefaultCommand() {

	}

	public void catapult() {
		if (RobotMap.catapultHallEffect.get() == false && Robot.oi.manipulatorStart.get() == false) {
			RobotMap.catapultMotor.set(Math.abs(Robot.oi.manipulator.getRawAxis(3)));
		} else {
			RobotMap.catapultMotor.set(0);
		}
	}

	public void intake() {
		if (Robot.oi.manipulatorLB.get()) {
			RobotMap.intakeMotor.set(.5);
		} else if (Robot.oi.manipulatorRB.get()) {
			RobotMap.intakeMotor.set(.5);
		} else {
			RobotMap.intakeMotor.set(0);
		}
	}

	double Actuators_Kp = 0.03; // Adjust Kp as necessary

	public void setActuators(double speed) {
		RobotMap.leftActuatorMotor.set(speed);
		RobotMap.rightActuatorMotor.set(speed * ((RobotMap.leftActuatorEncoder.getRate() - RobotMap.rightActuatorEncoder.getRate()) * Actuators_Kp)); // PID error correction algorithm
	}

	double defaultSpeed = 0.5;

	public void actuatorsUp() {
		setActuators(defaultSpeed);
	}

	public void actuatorsDown() {
		setActuators(-defaultSpeed);
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