package org.usfirst.frc.team2557.robot.commands.autonomous.sequences;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TurnByAngleCommand;

public class Auto_Pos1Center extends CommandGroup {

    public Auto_Pos1Center() {

        this.addSequential(new TurnByAngleCommand(77));

        this.addSequential(new EncoderPosDriveCommand(11406, 0.9));

        this.addSequential(new TurnByAngleCommand(-77));

        this.addSequential(new EncoderPosDriveCommand(2320, 0.75));

    }

}
