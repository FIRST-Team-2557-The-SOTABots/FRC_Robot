package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2557.robot.commands.chassis.DriveCommand;

public class Chassis extends Subsystem {

    CANTalon leftEncTalon = RobotMap.driveLeft2;
    CANTalon rightEncTalon = RobotMap.driveRight1;
    RobotDrive drive = RobotMap.robotDrive;
    Gyro gyro = RobotMap.mainGyro;

    double leftPosResetValue = 0;
    double rightPosResetValue = 0;
    
    public Chassis() {
    	
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveCommand());
    }

    public void resetDriveStraight() {
        this.resetGyro();
        this.resetDistanceTraveled();
    }
    public void driveStraight(double speed) {
    	drive.drive(speed, -gyro.getAngle() * 0.01);
    }

    public void set(double lvalue, double rvalue) {
        drive.tankDrive(lvalue, rvalue);
    }

    public void stop() {
        this.set(0, 0);
    }

    // NOTE: Works best when the robot has just driven straight
    public double getDistanceTraveled() {
        // Return the average of the distance between both encoders
        double posToMeters = (14 / 28) * 8 * 3.14159;
        return ((double) leftEncTalon.getEncPosition() - leftPosResetValue
                + (double) rightEncTalon.getEncPosition() - rightPosResetValue)
                * 0.5
                * posToMeters;
    }
    public void resetDistanceTraveled() {
        leftPosResetValue = (double) leftEncTalon.getEncPosition();
        rightPosResetValue = (double) rightEncTalon.getEncPosition();
    }

    public double getLeftEncoderVel() {
        return leftEncTalon.getEncVelocity();
    }

    public double getRightEncoderVel() {
        return rightEncTalon.getEncVelocity();
    }

    public void resetGyro() {
        gyro.reset();
    }
    public double getGyroAngle() {
        return gyro.getAngle();
    }
}

