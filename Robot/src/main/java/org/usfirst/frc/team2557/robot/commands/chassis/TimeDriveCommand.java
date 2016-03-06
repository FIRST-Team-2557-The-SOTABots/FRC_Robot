package org.usfirst.frc.team2557.robot.commands.chassis;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team2557.robot.Robot;

public class TimeDriveCommand extends Command {

    private Timer _timer;
    private double _expiration;
    private double _speed;

    public TimeDriveCommand(double time, double speed) {
        this._timer = new Timer();
        this._expiration = time;

        this._speed = speed;

        requires(Robot.chassis);
    }

    @Override
    protected void initialize() {
        this._timer.reset();
        this._timer.start();
    }

    @Override
    protected void execute() {
        Robot.chassis.driveStraight(this._speed);
    }

    @Override
    protected boolean isFinished() {
        return this._timer.get() >= this._expiration;
    }

    @Override
    protected void end() {
        Robot.chassis.set(0, 0);
    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
