package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultRetractCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TimeDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_Lowbar extends CommandGroup {

    public Auto_Lowbar() {

        // Parallels that run with a sequential
        // are added before that sequential!

        this.addParallel(new CatapultRetractCommand());
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_LOWBAR));

        this.addSequential(new EncoderPosDriveCommand(18282, 0.5));
    }

}
