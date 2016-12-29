package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CatapultRetractCommand extends Command {

	public CatapultRetractCommand() {
        requires(Robot.catapult);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.catapult.setCatapultMotor(0.75);
    }

    @Override
    protected boolean isFinished() {
        return Robot.catapult.isCatapultDown();
    }

    @Override
    protected void end() {
        Robot.catapult.setCatapultMotor(0);
    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
