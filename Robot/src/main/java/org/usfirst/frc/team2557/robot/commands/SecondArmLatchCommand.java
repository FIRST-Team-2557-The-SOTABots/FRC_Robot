package org.usfirst.frc.team2557.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;

public class SecondArmLatchCommand extends Command {

    public SecondArmLatchCommand() {
        requires(Robot.secondArm);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.secondArm.latch();
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
