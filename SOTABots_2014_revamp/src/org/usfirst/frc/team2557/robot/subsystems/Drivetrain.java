package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;


import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void driveTele(){
    	RobotMap.robotDrive.arcadeDrive(Robot.oi.joystick1);
    }
    public void driveExpo(){
    	if(Robot.oi.joystick1.getThrottle() > RobotMap.oldThrottle + 0.75 || Robot.oi.joystick1.getThrottle() > RobotMap.oldThrottle - 0.75 && RobotMap.time.get() > RobotMap.oldTime + 0.25){
    		RobotMap.robotDrive.arcadeDrive(RobotMap.briefSave, Robot.oi.joystick1.getX());
    	}
    }
}

