package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CatapultShootCommand extends Command {

	Timer timer;

    public CatapultShootCommand() {
        requires(Robot.catapult);
    }

    @Override
    protected void initialize() {
        timer = new Timer();
        timer.reset();
        timer.start();
    }

    @Override
    protected void execute() {
        Robot.catapult.setCatapultMotor(1);
    }

    @Override
    protected boolean isFinished() {
        // Adjust time if needed
        return timer.get() >= 1.5;
    }

    @Override
    protected void end() {
        Robot.catapult.setCatapultMotor(0);

        timer.stop();
    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
