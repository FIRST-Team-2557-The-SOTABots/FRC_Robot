package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardSub extends Subsystem{

	protected void initDefaultCommand() {
		
	}
	
	public void voltageCheck(){
		SmartDashboard.putNumber("The driveLeft1 is pulling: ", RobotMap.driveLeft1.getOutputVoltage());
		SmartDashboard.putNumber("The driveLeft2 is pulling: ", RobotMap.driveLeft2.getOutputVoltage());
		SmartDashboard.putNumber("The driveRight1 is pulling: ", RobotMap.driveRight1.getOutputVoltage());
		SmartDashboard.putNumber("The driveRight2 is pulling: ", RobotMap.driveRight2.getOutputVoltage());
		SmartDashboard.putNumber("The CatapultMotor is pulling: ", RobotMap.catapultMotor.getOutputVoltage());
		SmartDashboard.putNumber("The ClimbingMotor is pulling: ", RobotMap.climbingMotor.getOutputVoltage());
		SmartDashboard.putNumber("The IntakeMotor is pulling: ", RobotMap.intakeMotor.getOutputVoltage());
		SmartDashboard.putNumber("The LeftActuatormotor is pulling: ", RobotMap.leftActuatorMotor.getOutputVoltage());
		SmartDashboard.putNumber("The RightActuatorMotor is pulling: ", RobotMap.rightActuatorMotor.getOutputVoltage());
	}
	
	
	
	
	
}
