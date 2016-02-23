package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.RobotMap;

public class Auto_DistanceDrive extends Command {

    private double _distance;
    private double _speed;

    /**
     * Drives a distance with a motor speed set
     * @param distance Distance to move
     * @param speed Speed to move the distance
     */
    public Auto_DistanceDrive(double distance, double speed) {
        this._distance = distance;
        this._speed = speed;
    }

    @Override
    protected void initialize() {
        RobotMap.distanceEstimator.reset();
        RobotMap.mainGyro.reset();
    }

    final double Kp = 0.03;
    @Override
    protected void execute() {
        RobotMap.robotDrive.tankDrive(this._speed, this._speed * RobotMap.mainGyro.getAngle() * Kp);
    }

    @Override
    protected boolean isFinished() {
        return RobotMap.distanceEstimator.getDistance() >= this._distance;
    }

    @Override
    protected void end() {
        RobotMap.robotDrive.tankDrive(0, 0);
    }

    @Override
    protected void interrupted() {
        this.end();
    }

}
