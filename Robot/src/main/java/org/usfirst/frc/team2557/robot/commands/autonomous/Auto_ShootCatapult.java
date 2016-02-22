package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team2557.robot.RobotMap;

public class Auto_ShootCatapult extends Command {
    private Timer _timer = new Timer();

    @Override
    protected void initialize() {
        this._timer.start();
        this._timer.reset();
    }

    @Override
    protected void execute() {
        RobotMap.catapultMotor.set(1);
    }

    @Override
    protected boolean isFinished() {
        // TODO: Unsure if this is the correct to shoot the catapult
        return this._timer.hasPeriodPassed(1);
    }

    @Override
    protected void end() {
        RobotMap.catapultMotor.set(0);
    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
