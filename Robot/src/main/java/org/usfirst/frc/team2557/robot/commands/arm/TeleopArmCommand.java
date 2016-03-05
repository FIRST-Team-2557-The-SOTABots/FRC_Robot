package org.usfirst.frc.team2557.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;

public class TeleopArmCommand extends Command {

    public TeleopArmCommand() {
        requires(Robot.arm);
    }

    @Override
    protected void initialize() {
        // Disable the PID on the arm
        Robot.arm.disable();
    }

    @Override
    protected void execute() {
        Robot.arm.set(-Robot.oi.manipulator.getRawAxis(1));
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
        Robot.arm.enable();
    }
}
