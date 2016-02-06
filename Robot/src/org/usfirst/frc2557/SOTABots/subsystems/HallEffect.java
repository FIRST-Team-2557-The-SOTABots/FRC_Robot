package org.usfirst.frc2557.SOTABots2015.subsystems;

import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HallEffect extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public DigitalInput lift = RobotMap.liftSensor;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean checkLift(){
    	return !lift.get();
    }
}

