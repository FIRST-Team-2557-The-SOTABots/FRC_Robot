package org.usfirst.frc.team2557.robot.commands.autonomous.macro;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;

import java.io.IOException;

public class MacroRecordCommand extends Command {

    private MacroRecorder _recorder;

    public MacroRecordCommand(String filepath) {
        requires(Robot.arm);
        requires(Robot.catapult);
        requires(Robot.chassis);
        requires(Robot.intake);

        try {
            this._recorder = new MacroRecorder(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        try {
            this._recorder.record();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean isFinished() {
        return false; // Must call for it to end
    }

    @Override
    protected void end() {
        try {
            this._recorder.end();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
