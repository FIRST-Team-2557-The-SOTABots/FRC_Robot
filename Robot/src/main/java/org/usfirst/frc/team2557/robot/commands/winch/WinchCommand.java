package org.usfirst.frc.team2557.robot.commands.winch;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

public class WinchCommand extends Command {

    public WinchCommand() {
        requires(Robot.winch);

        // Not interruptible! Winch should be entirely driver controlled
        setInterruptible(false);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (Robot.oi.driver.getRawAxis(2) > 0.5 && Robot.oi.driver.getRawAxis(3) > 0.5) {
            RobotMap.climbingMotor.set(1);
        } else {
            RobotMap.climbingMotor.set(0);
        }
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
