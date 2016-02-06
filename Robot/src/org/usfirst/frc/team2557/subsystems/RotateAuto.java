package org.usfirst.frc2557.SOTABots2015.subsystems;

import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RotateAuto extends Subsystem {
	public double x;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Rotation(int x){
    	while(RobotMap.gyro.getAngle() < x){
    		RobotMap.driveTrainRobotDrive41.mecanumDrive_Cartesian(0, 0, 1, 0);
    		
    	}
    }
}

