package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2557.robot.commands.chassis.DriveCommand;

public class Chassis extends Subsystem {

//    CANTalon leftEncTalon = RobotMap.driveLeft2;
//    CANTalon rightEncTalon = RobotMap.driveRight1;
    // TODO: See whether the comp bot's encoders are switched as well
    CANTalon leftEncTalon = RobotMap.driveRight1; // Right and left are switched on the practice bot
    CANTalon rightEncTalon = RobotMap.driveLeft2;

    RobotDrive drive = RobotMap.robotDrive;
    Gyro gyro = RobotMap.mainGyro;

    double leftPosResetValue = 0;
    double rightPosResetValue = 0;

    private final double posToMeters = (14 / 28) * 8 * 3.14159;
    
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

    // NOTE: Only works when the robot has just driven straight
    public double getDistanceTraveled() {
        // Return the average of the distance between both encoders
        double posToMeters = (14 / 28) * 8 * 3.14159;
        return (this.getLeftEncoderPos()
                + this.getRightEncoderPos())
                * 0.5;
    }
    public void resetDistanceTraveled() {
        leftPosResetValue = (double) leftEncTalon.getEncPosition();
        rightPosResetValue = (double) rightEncTalon.getEncPosition();
    }

    public double getLeftEncoderVel() {
        return leftEncTalon.getEncVelocity();
    }
    public double getRightEncoderVel() {
        return -rightEncTalon.getEncVelocity(); // Right encoder is negative (spins reverse when the bot is moving forwards)
    }

    public double getLeftEncoderPos() {
        return leftEncTalon.getEncPosition() - leftPosResetValue;
    }
    public double getRightEncoderPos() {
        return -(rightEncTalon.getEncPosition() - rightPosResetValue); // Right encoder is negative (spins reverse when the bot is moving forwards)
    }

    public double getLeftEncoderDistance() {
        return this.getLeftEncoderPos() * posToMeters;
    }
    public double getRightEncoderDistance() {
        return this.getRightEncoderPos() * posToMeters;
    }

    public void resetGyro() {
        gyro.reset();
    }
    public double getGyroAngle() {
        return gyro.getAngle();
    }
}

