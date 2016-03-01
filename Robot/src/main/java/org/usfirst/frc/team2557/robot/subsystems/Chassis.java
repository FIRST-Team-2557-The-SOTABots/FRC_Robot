package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2557.robot.commands.chassis.DriveCommand;

public class Chassis extends Subsystem {

    RobotDrive drive = RobotMap.robotDrive;
    Gyro gyro = RobotMap.mainGyro;

    double limitingFactor = 0.8;

    double rampSpeedL = 0;
    double rampSpeedR = 0;
    double rampFactor = 0.04; // Change this variable to change the ramp speed (lower = slower)

    private Timer rampTimer = new Timer();
    public Chassis() {
        rampTimer.start();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveCommand());
    }

    public void driveArcade() {
        double power = -Robot.oi.driver.getRawAxis(1);
        double turn = -Robot.oi.driver.getRawAxis(4);
    	this.set((power - turn) * limitingFactor,
                (power + turn) * limitingFactor);
    }
    public void driveTank(){
        this.set(-Robot.oi.driver.getRawAxis(1) * limitingFactor,
                -Robot.oi.driver.getRawAxis(5) * limitingFactor);
    }

    private final double Kp = 0.03;
    public void driveStraight(double speed) {
        this.set(speed, speed * this.getGyroAngle() * Kp);
    }

    public void set(double lvalue, double rvalue) {
        if(rampTimer.get() >= 0.01) {
            if (Math.abs(lvalue) > Math.abs(rampSpeedL)) {
                rampSpeedL += lvalue * rampFactor;
            }
            if (Math.abs(lvalue) < Math.abs(rampSpeedL)) {
                rampSpeedL = lvalue;
            }
            if (Math.abs(rvalue) > Math.abs(rampSpeedR)) {
                rampSpeedR += rvalue * rampFactor;
            }
            if (Math.abs(lvalue) < Math.abs(rampSpeedR)) {
                rampSpeedR = rvalue;
            }
            rampTimer.reset();
        }
//        rampSpeedL = lvalue;
//        rampSpeedR = rvalue;

        drive.tankDrive(rampSpeedL,
                rampSpeedR);
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

