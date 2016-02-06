package org.usfirst.frc2557.SOTABots2015.subsystems;

import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RangeFinders extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	AnalogInput left = RobotMap.rangeLeft;
	AnalogInput right =  RobotMap.rangeRight;
	AnalogInput center = RobotMap.rangeCenter;
	int sampleSize = 3;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand new MySpecialCommand());
    }
    
    public double checkLeft(){
    	//Initializing local variables
    	double sum = 0;
    	double average = 0;
    	//Surveying range
    	for(int i = 0; i < sampleSize; i++){
    		sum = sum + left.getVoltage();
    	}
    	//Averaging the results
    	average = sum/sampleSize;
    	//Returning average
    	return average;
    }
    
    public double checkRight(){
    	//Initializing local variables
    	double sum = 0;
    	double average = 0;
    	//Surveying range
    	for(int i = 0; i < sampleSize; i++){
    		sum = sum + right.getVoltage();
    	}
    	//Averaging the results
    	average = sum/sampleSize;
    	//Returning average
    	return average;
    }
    
    public double checkCenter(){
    	//Initializing local variables
    	double sum = 0;
    	double average;
    	//Surveying range
    	for(int i = 0; i < sampleSize; i++){
    		sum = sum + center.getVoltage();
    	}
    	//Averaging the results
    	average = sum/sampleSize;
    	//Returning average
    	return average;
    }
}

