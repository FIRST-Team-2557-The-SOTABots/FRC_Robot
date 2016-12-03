package org.usfirst.frc.team2557.robot.commands.autonomous.resolvers;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.*;

public class PosBatterResolverCommand extends Command {

    private Command _chosenCommand = null;

    @Override
    protected void initialize() {
        switch((int) Robot.instance.posChooser.getSelected()) {
            case 0:
                this._chosenCommand = null;
                break;
            case 1:
                switch((int) Robot.instance.batterChooser.getSelected()) {
                    case -1:
                        this._chosenCommand = new Auto_Pos1Left();
                        break;
                    case 0:
                        this._chosenCommand = new Auto_Pos1Center();
                        break;
                    case 1:
                        // Can't do right!
                        break;
                }
                break;
            case 2:
                switch((int) Robot.instance.batterChooser.getSelected()) {
                    case -1:
                        this._chosenCommand = new Auto_Pos2Left();
                        break;
                    case 0:
                        this._chosenCommand = new Auto_Pos2Center();
                        break;
                    case 1:
                        // Can't do right!
                        break;
                }
                break;
            case 3:
                switch((int) Robot.instance.batterChooser.getSelected()) {
                    case -1:
                        // Can't do left!
                        break;
                    case 0:
                        this._chosenCommand = new Auto_Pos3Center();
                        break;
                    case 1:
                        this._chosenCommand = new Auto_Pos3Right();
                        break;
                }
                break;
            case 4:
                switch((int) Robot.instance.batterChooser.getSelected()) {
                    case -1:
                        // Can't do left!
                        break;
                    case 0:
                        this._chosenCommand = new Auto_Pos4Center();
                        break;
                    case 1:
                        this._chosenCommand = new Auto_Pos4Right();
                        break;
                }
                break;
        }

        if(this._chosenCommand != null) {
            this._chosenCommand.start();
        }
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        if(this._chosenCommand != null)
            return this._chosenCommand.isRunning();

        return true;
    }

    @Override
    protected void end() {
        if(this._chosenCommand != null)
            this._chosenCommand.cancel();
    }

    @Override
    protected void interrupted() {
        this.end();
    }

}
