package org.usfirst.frc.team2557.robot.commands.autonomous.sequences;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TurnByAngleCommand;

public class Auto_Pos1Left extends CommandGroup {

    public Auto_Pos1Left() {

        this.addSequential(new EncoderPosDriveCommand(9088, 0.65));

        this.addSequential(new TurnByAngleCommand(59.4));

        this.addSequential(new EncoderPosDriveCommand(3023, 0.5));

    }

}
