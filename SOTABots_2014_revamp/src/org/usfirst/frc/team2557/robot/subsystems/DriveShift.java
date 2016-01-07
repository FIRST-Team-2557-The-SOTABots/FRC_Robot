package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveShift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void shiftUp(){
    	if(Value.kReverse == RobotMap.driveShift.get()){
    		RobotMap.driveShift.set(Value.kForward);
    		}
    		
    	}
    public void shiftDown(){
    	if(Value.kForward == RobotMap.driveShift.get()){
    		RobotMap.driveShift.set(Value.kReverse);
    	}
    }
    }


