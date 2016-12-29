package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeStopCommand extends Command {

	public IntakeStopCommand() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.intake.set(0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
