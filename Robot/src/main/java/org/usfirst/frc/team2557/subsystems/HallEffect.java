package org.usfirst.frc.team2557.subsystems;

import org.usfirst.frc.team2557.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HallEffect extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void hallCheck(){
    	//RobotMap.hallValue = RobotMap.hallEffect.get(); //These are not supposed to be commented out but it is throwing a null. Check the declarations in RobotMap -Antonio 2/8/16
    }
}

