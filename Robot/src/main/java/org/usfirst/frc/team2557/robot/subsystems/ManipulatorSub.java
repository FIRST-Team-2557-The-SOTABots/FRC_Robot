package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ManipulatorSub extends Subsystem {

	protected void initDefaultCommand() {

	}

	double Actuators_Kp = 0.03; // Adjust Kp as necessary

	public void setActuators(double speed) {
		RobotMap.leftActuatorMotor.set(speed);
		// TODO: Right Talon PID with left Talon encoder
//		RobotMap.rightActuatorMotor.set(speed);
	}

}