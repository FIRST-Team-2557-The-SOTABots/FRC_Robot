package org.usfirst.frc.team2557.robot.commands.autonomous.sequences;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TurnByAngleCommand;

public class Auto_Pos2Center extends CommandGroup {

    public Auto_Pos2Center() {

        this.addParallel(new Auto_LoadBall());

        this.addSequential(new TurnByAngleCommand(56.5));

        this.addSequential(new EncoderPosDriveCommand(6513, 0.7));

        this.addSequential(new TurnByAngleCommand(-56.5));

        this.addSequential(new EncoderPosDriveCommand(1920, 0.5));

        this.addSequential(new Auto_CameraShootSequence());

    }

}
