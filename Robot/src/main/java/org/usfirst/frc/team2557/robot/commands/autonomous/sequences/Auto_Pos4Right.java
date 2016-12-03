package org.usfirst.frc.team2557.robot.commands.autonomous.sequences;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TurnByAngleCommand;

public class Auto_Pos4Right extends CommandGroup {

    public Auto_Pos4Right() {

        this.addParallel(new Auto_LoadBall());

        this.addSequential(new TurnByAngleCommand(7));

        this.addSequential(new EncoderPosDriveCommand(9295, 0.7));

        this.addSequential(new TurnByAngleCommand(-64));

        this.addSequential(new EncoderPosDriveCommand(1409, 0.5));

        this.addSequential(new Auto_CameraShootSequence());

    }

}
