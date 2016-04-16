package org.usfirst.frc.team2557.robot.commands.autonomous.macro;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;

import java.io.FileNotFoundException;

public class MacroPlayCommand extends Command {

    private MacroPlayer _player;

    public MacroPlayCommand(String filepath) {
        requires(Robot.arm);
        requires(Robot.catapult);
        requires(Robot.chassis);
        requires(Robot.intake);

        try {
            this._player = new MacroPlayer(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initialize() {
        this._player.init();
    }

    @Override
    protected void execute() {
        this._player.play();
    }

    @Override
    protected boolean isFinished() {
        return this._player.isFinished();
    }

    @Override
    protected void end() {
        this._player.end();
    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
