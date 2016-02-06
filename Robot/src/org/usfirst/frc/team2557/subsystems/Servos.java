package org.usfirst.frc2557.SOTABots2015.subsystems;

import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Servos extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Servo left = RobotMap.servoLeft;
	Servo right = RobotMap.servoRight;
	Servo center = RobotMap.servoCenter;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void moveLeft(int angle){
    	//Calculates the proper value for the angle
    	double degree = 1/angle;
    	//Sets the servo to the proper degree
    	left.set(degree);    	
    }
    
    public void moveRight(int angle){
    	//Calculates the proper value for the angle
    	double degree = 1/angle;
    	//Sets the servo to the proper degree
    	right.set(degree);
    }
    
    public void moveCenter(int angle){
    	//Calculates the proper value for the angle
    	double degree = 1/angle;
    	//Sets the servo to the proper degree
    	center.set(degree);
    }
}

