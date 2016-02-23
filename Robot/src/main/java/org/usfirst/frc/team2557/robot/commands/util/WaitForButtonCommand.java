package org.usfirst.frc.team2557.robot.commands.util;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * To be used in command groups as a sequential.
 */
public class WaitForButtonCommand extends Command {

    JoystickButton button;

    public WaitForButtonCommand(JoystickButton button) {
        this.button = button;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return button.get();
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
