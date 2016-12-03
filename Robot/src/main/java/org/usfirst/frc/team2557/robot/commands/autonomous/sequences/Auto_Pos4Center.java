package org.usfirst.frc.team2557.robot.commands.autonomous.sequences;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TurnByAngleCommand;

public class Auto_Pos4Center extends CommandGroup {

    public Auto_Pos4Center() {

        this.addParallel(new Auto_LoadBall());

        this.addSequential(new TurnByAngleCommand(-57));

        this.addSequential(new EncoderPosDriveCommand(9403, 0.8));

        this.addSequential(new TurnByAngleCommand(57));

        this.addSequential(new EncoderPosDriveCommand(350, 0.6));

        this.addSequential(new Auto_CameraShootSequence());

    }

}
