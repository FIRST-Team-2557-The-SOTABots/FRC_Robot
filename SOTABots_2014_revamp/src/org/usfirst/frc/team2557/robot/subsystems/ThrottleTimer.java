package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import java.lang.Math;
/**
 *
 */
public class ThrottleTimer extends Subsystem {
	private double x;
    private double y;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void getOldData(){
    	x = RobotMap.time.get();
    	y = Math.abs(Robot.oi.joystick1.getThrottle());
    	if(RobotMap.time.get() > x + 0.25){
    		RobotMap.oldTime = x;
    		RobotMap.oldThrottle = y;
    	}
    }
}

