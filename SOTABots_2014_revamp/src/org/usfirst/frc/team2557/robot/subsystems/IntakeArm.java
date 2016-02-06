package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeArm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void arm(){
    	if(RobotMap.intakeArm.get() == Value.kReverse){
    		RobotMap.intakeArm.set(Value.kForward);
    	}
    	else{
    		RobotMap.intakeArm.set(Value.kReverse);
    	}
    	}
    }


