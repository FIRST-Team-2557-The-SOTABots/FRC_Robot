package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardSub extends Subsystem{

	protected void initDefaultCommand() {
		
	}
	
	public void voltageCheck(){
		SmartDashboard.putNumber("The FrontLeftDriveMotor is pulling: ", RobotMap.driveFrontLeft.getOutputVoltage());
		SmartDashboard.putNumber("The FrontRightDriveMotor is pulling: ", RobotMap.driveFrontRight.getOutputVoltage());
		SmartDashboard.putNumber("The BackLeftDriveMotor is pulling: ", RobotMap.driveBackLeft.getOutputVoltage());
		SmartDashboard.putNumber("The BackRightDriveMotor is pulling: ", RobotMap.driveBackRight.getOutputVoltage());
		SmartDashboard.putNumber("The CatapultMotor is pulling: ", RobotMap.catapultMotor.getOutputVoltage());
		SmartDashboard.putNumber("The ClimbingMotor is pulling: ", RobotMap.climbingMotor.getOutputVoltage());
		SmartDashboard.putNumber("The IntakeMotor is pulling: ", RobotMap.intakeMotor.getOutputVoltage());
		SmartDashboard.putNumber("The LeftActuatormotor is pulling: ", RobotMap.leftActuatorMotor.getOutputVoltage());
		SmartDashboard.putNumber("The RightActuatorMotor is pulling: ", RobotMap.rightActuatorMotor.getOutputVoltage());
	}
	
	
	
	
	
}
