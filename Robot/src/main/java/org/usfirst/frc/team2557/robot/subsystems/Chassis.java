package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {

    RobotDrive drive = RobotMap.robotDrive;

    double limitingFactor = 0.7;

    public void initDefaultCommand() {

    }
    public void driveArcade() {
    	drive.arcadeDrive(-Robot.oi.driver.getRawAxis(1) * limitingFactor,
                -Robot.oi.driver.getRawAxis(4) * limitingFactor);
    }
    public void driveTank(){
    	drive.tankDrive(-Robot.oi.driver.getRawAxis(1) * limitingFactor,
                -Robot.oi.driver.getRawAxis(5) * limitingFactor);
    }
}

