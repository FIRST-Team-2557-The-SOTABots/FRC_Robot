package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.RobotMap;

public class Auto_DriveToDefense extends Auto_DistanceDrive {

    private static double metersToDefense = 1.5; //TODO: Experiment with this value to reach the edge of a defense
    private static double speed = 0.5;

    public Auto_DriveToDefense() {
        super(metersToDefense, speed);
    }

    @Override
    protected void initialize() {
        RobotMap.positionEstimator.reset();
    }

    final double Kp = 0.03;
    @Override
    protected void execute() {
        // TODO: Drive with PID and Talon encoders
        RobotMap.robotDrive.tankDrive(speed, speed);
    }

    @Override
    protected boolean isFinished() {
        return RobotMap.positionEstimator.getDisplacementY() >= metersToDefense;
    }

    @Override
    protected void end() {
        RobotMap.robotDrive.tankDrive(0, 0);
    }

    @Override
    protected void interrupted() {
        RobotMap.robotDrive.tankDrive(0, 0);
    }

}
