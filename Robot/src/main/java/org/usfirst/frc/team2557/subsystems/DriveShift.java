package org.usfirst.frc.team2557.subsystems;

import org.usfirst.frc.team2557.RobotMap;

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
    public void Shift(){
    	if(Value.kReverse == RobotMap.driveShift.get()){
    		RobotMap.driveShift.set(Value.kForward);
    		}
    	else{
    		RobotMap.driveShift.set(Value.kReverse);
    	}
    		
    	}

    }



