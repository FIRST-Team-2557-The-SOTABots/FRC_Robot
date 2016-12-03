package org.usfirst.frc.team2557.robot.commands.chassis;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;

public class EncoderPosDriveCommand extends Command {

    private double _speed;
    private double _encpos;

    public EncoderPosDriveCommand(double encpos, double speed) {
        requires(Robot.chassis);

        this._speed = speed;
        this._encpos = encpos;
    }

    @Override
    protected void initialize() {
        Robot.chassis.resetDriveStraight();
    }

    @Override
    protected void execute() {
        Robot.chassis.driveStraight(this._speed);
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(Robot.chassis.getLeftEncoderPos()) > this._encpos;
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
