package org.usfirst.frc.team2557.robot.commands.autonomous.sequences;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TurnByAngleCommand;

public class Auto_Pos3Center extends CommandGroup {

    public Auto_Pos3Center() {

        this.addSequential(new TurnByAngleCommand(-20));

        this.addSequential(new EncoderPosDriveCommand(6776, 0.5));

        this.addSequential(new TurnByAngleCommand(20));

    }

}
