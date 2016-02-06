package org.usfirst.frc2557.SOTABots2015.subsystems;

import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AccelerometerSub extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	BuiltInAccelerometer locationAccelerometer = RobotMap.accelerometer;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double getX(){
    	return locationAccelerometer.getX();
    }
    
    public double getY(){
    	return locationAccelerometer.getY();
    }
    
    public double getZ(){
    	return locationAccelerometer.getZ();
    }
}

