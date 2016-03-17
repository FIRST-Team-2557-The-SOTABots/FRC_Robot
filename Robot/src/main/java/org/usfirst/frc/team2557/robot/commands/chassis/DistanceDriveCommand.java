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
        Robot.chassis.resetDriveStraight();
    }

    @Override
    protected void execute() {
        double dir = this._distance - Robot.chassis.getDistanceTraveled();
        if(dir != 0)
            Robot.chassis.driveStraight(this._speed * ((dir) / Math.abs(dir)));
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(Robot.chassis.getDistanceTraveled()) >= Math.abs(this._distance);
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
