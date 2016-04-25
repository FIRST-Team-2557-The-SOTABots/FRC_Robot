package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_CameraShootSequence;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_Pos1Center;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_Pos2Left;

public class Auto_RoughTerrain_Pos2Left extends Auto_RoughTerrain {

    public Auto_RoughTerrain_Pos2Left() {
        super();

        this.addParallel(new Auto_LoadBall());

        this.addSequential(new Auto_Pos2Left());

        this.addSequential(new Auto_CameraShootSequence());
    }

}
