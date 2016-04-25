package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_CameraShootSequence;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_Pos3Center;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_Pos4Center;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_Portcullis_Pos4Center extends Auto_Portcullis {

    public Auto_Portcullis_Pos4Center() {
        super();

        this.addSequential(new Auto_Pos4Center());

        this.addParallel(new MoveArmToAngleCommand(Arm.ARM_BOTTOM));

        this.addParallel(new Auto_CameraShootSequence());
    }

}
