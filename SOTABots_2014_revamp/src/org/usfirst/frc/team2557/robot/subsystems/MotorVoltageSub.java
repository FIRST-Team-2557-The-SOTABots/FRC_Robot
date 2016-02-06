package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorVoltageSub extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void FrontRightVoltage(){
    	RobotMap.frontRightVoltage = RobotMap.frontRight.getBusVoltage();
    }
    public void RearRightVoltage(){
    	RobotMap.rearRightVoltage = RobotMap.backRight.getBusVoltage();
    }
    public void FrontLeftVoltage(){
    	RobotMap.frontLeftVoltage = RobotMap.frontLeft.getBusVoltage();
    }
    public void BackLeftVoltage(){
    	RobotMap.rearLeftVoltage = RobotMap.backLeft.getBusVoltage();
    }
}

