//Radar
package org.usfirst.frc2557.SOTABots2015.subsystems;

import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Radar extends Subsystem {
	AnalogInput rangeLeft = RobotMap.rangeLeft;
    AnalogInput rangeRight = RobotMap.rangeRight;
    AnalogInput rangeCenter = RobotMap.rangeCenter;
    Servo servoLeft = RobotMap.servoLeft;
	Servo servoRight = RobotMap.servoRight;
	Servo servoCenter 	= RobotMap.servoCenter;
	double[] centerArray 	= RobotMap.centerArray;
	double[] leftArray		 = RobotMap.leftArray;
	double[] rightArray 	= RobotMap.rightArray;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

//Main Radar Methods
	public void findCenter(int x, int y){
		double[] average = new double[181];
////////TEST///////
		int c;
		double a, b, z, instant = 0, difference = 0; //voltages
		
			average[RobotMap.degCount] = rangeCenter.getVoltage()/.009765;
		a = (average[0]+average[1]+average[2])/average.length;		
		RobotMap.servoCenter.set(RobotMap.degCount / 180.0);
    	
    	
    	if (RobotMap.sweepDir == true) {
    		RobotMap.degCount+= 2;
    	}
    	else {
    		RobotMap.degCount-= 2;
    	}
    	
    	
    	if (RobotMap.degCount == y) { 
    		RobotMap.sweepDir = false;
    	}
    	else if (RobotMap.degCount == x) {
    		RobotMap.sweepDir = true;
		}
    	//Use a variable in Robotmap to account for the degree -Android 
    	if(average[RobotMap.degCount] < 30 && average[RobotMap.degCount] < 100){ //30 is just an arbitrary number
			
			//find the first side of an object in a sweep and initiate a variable to store the degree and voltage that was found
			x = RobotMap.degCount;
			a = average[RobotMap.degCount];
		}
		if(average[RobotMap.degCount] > 50 && average[RobotMap.degCount] < 100){ // needs more logic to the parameter to consider everything that ISN'T a tote or bin
			
			//find the other side of the object and initiate a variable to store the degree and voltage that was found
			y = RobotMap.degCount-2;
			b = average[RobotMap.degCount];
		}
		RobotMap.centerDegreeR = (x+y)/2;
		c = (x+y)/2;
		RobotMap.changeDegreeR  = RobotMap.centerDegreeR - 90;
		instant = RobotMap.gyro.getAngle();
		if (c < average.length){
			RobotMap.degCount = c;
			z = average[RobotMap.degCount];
		}
		x = x - 5;
		y = y + 5;
		
		
		RobotMap.changeDegreeR = RobotMap.centerDegreeR - 90;
		 
//		servo = 135
//		perpindicular = 270
//		differnce of servo to the perpendicular
//		
//		//Right
//		 * y = x-p
//		 * y = difference in degrees
//		 * x = servo angle
//		 * p = perpindicular
//		
//		
//    	if(x <= y+3 && x >= y-3 && c < a && c > b){
//			you are looking at a tote
//		}
//		else if(y <= x+3 && y >= x-3 && c > a && c < b){
//			
//		}
//		else if(){
//			
//		}
//		x = average[x];
//		y = average[y];
//		c = (x+y)/2;
//		a = (x+c)/2;
//		b = (y+c)/2;
//		
//		if(x<y&&c>a&&c<b){
//			RobotMap.driveTrainRobotDrive41.mecanumDrive_Cartesian(0,1,.2,0);
//		}

////////TEST///////
	}	
		
		/////This code works, do not touch it/////
		public void sweepMe(int y, int x){
		double a;
		double[] average = new double[10];
		for(int i = 0; i < 10; i++){
			average[i] = rangeCenter.getVoltage()/.009765;
			
		}
		a = (average[0]+average[1]+average[2])/average.length;
		
    	RobotMap.servoCenter.set(y / 180.0);
    	if (RobotMap.sweepDir == true) {
    		RobotMap.degCount+= 2;
    	}
    	else {
    		RobotMap.degCount-= 2;
    	}
    	if (RobotMap.degCount == y) {
    		RobotMap.sweepDir = false;
    	}
    	else if (RobotMap.degCount == x) {
    		RobotMap.sweepDir = true;
    	}
    	}

    

	//Servos
    public void sweepAll180(){
    	RobotMap.servoLeft.set(RobotMap.degCount / 180.0);
    	RobotMap.servoRight.set(RobotMap.degCount / 180.0);
    	RobotMap.servoCenter.set(RobotMap.degCount / 180.0);
    	if (RobotMap.sweepDir == true) {
    		RobotMap.degCount+= 2;
    	}
    	else {
    		RobotMap.degCount-= 2;
    	}
    	if (RobotMap.degCount == 178) {
    		RobotMap.sweepDir = false;
    	}
    	else if (RobotMap.degCount == 2) {
    		RobotMap.sweepDir = true;
    	}
    }
    public void sweepHalf(){
        RobotMap.servoLeft.set(RobotMap.degCount / 180.0);
       	RobotMap.servoRight.set(RobotMap.degCount / 180.0);
       	RobotMap.servoCenter.set(RobotMap.degCount / 180.0);
       	if (RobotMap.sweepDir == true) {
       		RobotMap.degCount+= 2;
       	}
       	else {
       		RobotMap.degCount-= 2;
       	}
       	if (RobotMap.degCount == 95) {
       		RobotMap.sweepDir = false;
       	}
       	else if (RobotMap.degCount == 90) {
       		RobotMap.sweepDir = true;
       	}
    }
    
//Range Finders
    public double getRangeFrontLeft(){
    	return rangeLeft.getAverageVoltage();
    }
    
    public double getRangeFrontRight(){
    	return rangeRight.getAverageVoltage();
    }
    
    public double getRangeBack(){
    	return rangeCenter.getAverageVoltage();
    }
}

