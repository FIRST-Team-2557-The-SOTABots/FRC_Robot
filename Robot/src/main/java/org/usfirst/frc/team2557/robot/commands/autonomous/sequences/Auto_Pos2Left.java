package org.usfirst.frc.team2557.robot.commands.autonomous.sequences;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TurnByAngleCommand;

public class Auto_Pos2Left extends CommandGroup {

    public Auto_Pos2Left() {

        this.addParallel(new Auto_LoadBall());

        this.addSequential(new TurnByAngleCommand(-22.2));

        this.addSequential(new EncoderPosDriveCommand(10764, 0.5));

        this.addSequential(new TurnByAngleCommand(81.4));

        this.addSequential(new EncoderPosDriveCommand(750, 0.5));

        this.addSequential(new Auto_CameraShootSequence());

    }

}
