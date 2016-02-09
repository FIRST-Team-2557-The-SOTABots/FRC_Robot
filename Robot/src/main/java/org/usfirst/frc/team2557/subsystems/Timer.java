package org.usfirst.frc.team2557.subsystems;

import org.usfirst.frc.team2557.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Timer extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setTime(){
    	if(RobotMap.hallValue == false){
    	//RobotMap.time.start(); //These are not supposed to be commented out but they are throwing nulls. Check RobotMap declaration -Antonio 2/8/16
    	}
    }
    public void getTime(){
    	//RobotMap.time.get(); //These are not supposed to be commented out but they are throwing nulls. Check RobotMap declaration -Antonio 2/8/16
    }
}

