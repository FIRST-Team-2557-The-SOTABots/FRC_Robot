package org.usfirst.frc.team2557.subsystems;

import org.usfirst.frc.team2557.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SensorsSub extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void hallCheck(){
    	RobotMap.hallValue = RobotMap.hallEffect.get();
    }
    public void leftEncoderRate(){
    	RobotMap.leftEncoderRate = RobotMap.leftDriveEncoder.getRate();
    }
    public void rightEncoderRate(){
    	RobotMap.rightEncoderRate = RobotMap.rightDriveEncoder.getRate();
    }
    public void winchEncoderCount(){
    	RobotMap.winchEncoderCount = RobotMap.winchEncoder.get();
    }
    
}

