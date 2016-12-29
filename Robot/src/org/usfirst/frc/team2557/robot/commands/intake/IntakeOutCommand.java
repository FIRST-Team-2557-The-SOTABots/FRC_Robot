package org.usfirst.frc.team2557.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;

public class IntakeOutCommand extends Command {

    public IntakeOutCommand() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.intake.set(-0.5);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.intake.set(0);
    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
