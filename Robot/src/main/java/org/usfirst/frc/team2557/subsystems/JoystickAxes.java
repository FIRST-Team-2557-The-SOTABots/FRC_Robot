package org.usfirst.frc.team2557.subsystems;

import org.usfirst.frc.team2557.Robot;
import org.usfirst.frc.team2557.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class JoystickAxes extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void xAxis(){
    	RobotMap.jx = Robot.oi.joystick1.getX();
    }
    public void yAxis(){
    	RobotMap.jy = Robot.oi.joystick1.getY();
    }
}

