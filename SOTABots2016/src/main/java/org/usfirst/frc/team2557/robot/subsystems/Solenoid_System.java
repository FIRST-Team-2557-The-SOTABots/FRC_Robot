package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Solenoid_System extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void Solenoid1F(){
    	RobotMap.DSolenoid1.set(Value.kForward);
    }
    public void Solenoid2f(){
    	RobotMap.DSolenoid2.set(Value.kForward);
    }
    public void Solenoid1R(){
    	RobotMap.DSolenoid1.set(Value.kReverse);
    }
    public void Solenoid2R(){
    	RobotMap.DSolenoid2.set(Value.kReverse);
    }
    
    
    
}

