package org.usfirst.frc.team2557.subsystems;

import org.usfirst.frc.team2557.Robot;
import org.usfirst.frc.team2557.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import java.lang.Math;

/**
 *
 */
public class GradualSpeedIncrease extends Subsystem {
    private double x;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void gradualSpeedIncrease(){
    	x = Robot.oi.joystick1.getThrottle();
    	RobotMap.briefSave = Math.pow(x, 2);
    	
    	
    }
}

