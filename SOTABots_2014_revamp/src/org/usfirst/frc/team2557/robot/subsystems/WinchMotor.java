package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchMotor extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void winchDown(){
    	while(RobotMap.hallValue == false){
    	RobotMap.winchMotor.set(1);
    	}
    }
    public void winchTimer(){
    	if(RobotMap.timerValue > 5){
    		while(RobotMap.hallValue == false){
    		RobotMap.winchMotor.set(1);
    		}
    	}
    }
}

