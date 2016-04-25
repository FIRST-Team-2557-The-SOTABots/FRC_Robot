package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_Pos3Center;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultShootCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_Portcullis_Pos3Center extends Auto_Portcullis {

    public Auto_Portcullis_Pos3Center() {
        super();

        this.addSequential(new Auto_Pos3Center());

        this.addParallel(new MoveArmToAngleCommand(Arm.ARM_BOTTOM));

        this.addSequential(new EncoderPosDriveCommand(3458, 0.4));

        this.addSequential(new CatapultShootCommand());
    }

}
