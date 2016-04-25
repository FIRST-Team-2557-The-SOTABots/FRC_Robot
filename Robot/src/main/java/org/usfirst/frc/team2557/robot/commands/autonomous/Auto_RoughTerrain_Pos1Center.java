package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_CameraShootSequence;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_Pos1Center;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_Pos3Center;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultShootCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_RoughTerrain_Pos1Center extends Auto_RoughTerrain {

    public Auto_RoughTerrain_Pos1Center() {
        super();

        this.addParallel(new Auto_LoadBall());

        this.addSequential(new Auto_Pos1Center());

        this.addSequential(new Auto_CameraShootSequence());
    }

}
