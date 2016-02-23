package org.usfirst.frc.team2557.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;

public class LidarUpdateCommand extends Command {

    public LidarUpdateCommand() {
        // This command can run without other commands
        // conflicting (requires is not needed).

        // This command cannot be interrupted!
        setInterruptible(false);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.lidar.updateNetworkTables();
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

    }

}
