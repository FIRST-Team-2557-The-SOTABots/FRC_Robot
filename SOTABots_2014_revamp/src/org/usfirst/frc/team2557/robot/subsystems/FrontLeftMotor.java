package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FrontLeftMotor extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void voltage(){
    	RobotMap.frontLeftVoltage = RobotMap.frontLeft.getBusVoltage();
    }
    public void adjustStraight(){
    	if(RobotMap.jx < 2 && RobotMap.jx > -2 && RobotMap.frontLeftVoltage < RobotMap.frontRightVoltage && RobotMap.frontLeftVoltage < RobotMap.rearLeftVoltage && RobotMap.frontLeftVoltage < RobotMap.rearRightVoltage){
    		RobotMap.lowSpeed = RobotMap.frontLeftVoltage;
    	}
    }
}

