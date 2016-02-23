package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;

public class Auto_CameraAlignForShot extends Command {

    public Auto_CameraAlignForShot() {
        requires(Robot.chassis);

        // Do not require camera! Although
        // we use the camera, the camera is a
        // "shared system", meaning it will
        // not under ANY circumstances interfere
        // with any other commands
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.chassis.stop();
    }

    @Override
    protected void interrupted() {
        this.end();
    }

}
