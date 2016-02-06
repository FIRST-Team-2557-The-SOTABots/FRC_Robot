package org.usfirst.frc.team2557.subsystems;

import org.usfirst.frc.team2557.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RightDriveEncoder extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void encoderRate(){
    	RobotMap.rightEncoderRate = RobotMap.rightDriveEncoder.getRate();
    }
}

