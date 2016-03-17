package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2557.robot.commands.chassis.DriveCommand;

public class Chassis extends Subsystem {

    CANTalon leftDrive = RobotMap.driveLeft2;
    CANTalon rightDrive = RobotMap.driveRight1;
    RobotDrive drive = RobotMap.robotDrive;
    Gyro gyro = RobotMap.mainGyro;

    double leftPosResetValue = 0;
    double rightPosResetValue = 0;

    public void initDefaultCommand() {
        setDefaultCommand(new DriveCommand());
    }

    private final double Kp = 0.05;
    public void resetDriveStraight() {
        this.resetGyro();
        this.resetDistanceTraveled();
    }
    public void driveStraight(double speed) {
        drive.arcadeDrive(speed, -this.getGyroAngle() * Kp);
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
        // TODO: Convert the pos to meters: (shaftGearTeeth / wheelGearTeeth) * wheelDiameter(m) * PI
        double posToMeters = 1;
        return ((double) leftDrive.getEncPosition() - leftPosResetValue
                + (double) rightDrive.getEncPosition() - rightPosResetValue)
                * 0.5
                * posToMeters;
    }
    public void resetDistanceTraveled() {
        leftPosResetValue = (double) leftDrive.getEncPosition();
        rightPosResetValue = (double) rightDrive.getEncPosition();
    }

    public void resetGyro() {
        gyro.reset();
    }
    public double getGyroAngle() {
        return gyro.getAngle();
    }
}

