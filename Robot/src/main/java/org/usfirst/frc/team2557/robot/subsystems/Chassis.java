package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2557.robot.commands.chassis.DriveCommand;

public class Chassis extends Subsystem {

    RobotDrive drive = RobotMap.robotDrive;
    Gyro gyro = RobotMap.mainGyro;

    double limitingFactor = 0.7;

    public void initDefaultCommand() {
        setDefaultCommand(new DriveCommand());
    }

    public void driveArcade() {
    	drive.arcadeDrive(-Robot.oi.driver.getRawAxis(1) * limitingFactor,
                -Robot.oi.driver.getRawAxis(4) * limitingFactor);
    }
    public void driveTank(){
    	drive.tankDrive(-Robot.oi.driver.getRawAxis(1) * limitingFactor,
                -Robot.oi.driver.getRawAxis(5) * limitingFactor);
    }

    private final double Kp = 0.03;
    public void driveStraight(double speed) {
        this.set(speed, speed * this.getGyroAngle() * Kp);
    }

    public void set(double lvalue, double rvalue) {
        drive.tankDrive(lvalue, rvalue);
    }

    public void stop() {
        this.set(0, 0);
    }

    public void resetGyro() {
        gyro.reset();
    }
    public double getGyroAngle() {
        return gyro.getAngle();
    }
}

