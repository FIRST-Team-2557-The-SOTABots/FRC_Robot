package org.usfirst.frc.team2557.robot.commands.chassis;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

public class DistanceDriveCommand extends Command {

    private double _distance;
    private double _speed;

    /**
     * Drives a distance with a motor speed set
     * @param distance Distance to move
     * @param speed Speed to move the distance
     */
    public DistanceDriveCommand(double distance, double speed) {
        this._distance = distance;
        this._speed = speed;

        requires(Robot.chassis);
    }

    @Override
    protected void initialize() {
        RobotMap.distanceEstimator.reset();
        RobotMap.mainGyro.reset();
    }

    @Override
    protected void execute() {
        Robot.chassis.driveStraight(-this._speed);
    }

    @Override
    protected boolean isFinished() {
        return RobotMap.distanceEstimator.getDistance() >= this._distance;
    }

    @Override
    protected void end() {
        Robot.chassis.stop();
    }

    @Override
    protected void interrupted() {
        this.end();
    }

}
