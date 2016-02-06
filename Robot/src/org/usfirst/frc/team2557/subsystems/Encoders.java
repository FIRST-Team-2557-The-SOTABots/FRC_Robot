package org.usfirst.frc2557.SOTABots2015.subsystems;

import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Encoders extends Subsystem {
    
    public static Counter frontLeft = RobotMap.frontLeftEnc;
    public static Counter frontRight = RobotMap.frontRightEnc;
    public static Counter rearLeft =  RobotMap.rearLeftEnc;
    public static Counter rearRight = RobotMap.rearRightEnc;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public int frontLeft(){
    	return frontLeft.get();
    }
    public int frontRight(){
    	return frontRight.get();
    }
    public int rearLeft(){
    	return rearLeft.get();
    }
    public int rearRight(){
    	return rearRight.get();
    }
    public void reset(){
    	frontLeft.reset();
    	frontRight.reset();
    	rearLeft.reset();
    	rearRight.reset();
    }
}

