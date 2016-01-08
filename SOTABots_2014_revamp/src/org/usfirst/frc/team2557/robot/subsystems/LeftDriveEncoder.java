package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LeftDriveEncoder extends Subsystem {

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void encoderRate(){
    	RobotMap.leftEncoderRate = RobotMap.leftDriveEncoder.getRate();
    }
    public void encoderDrive(){
    	while(RobotMap.leftDriveEncoder.get() < RobotMap.c){
    		RobotMap.robotDrive.arcadeDrive(RobotMap.x, RobotMap.y);
    	}
    }

}

