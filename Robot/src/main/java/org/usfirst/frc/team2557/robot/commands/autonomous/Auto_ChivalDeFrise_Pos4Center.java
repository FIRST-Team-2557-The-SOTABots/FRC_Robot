package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_CameraShootSequence;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_Pos3Center;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_Pos4Center;

public class Auto_ChivalDeFrise_Pos4Center extends Auto_ChivalDeFrise {

    public Auto_ChivalDeFrise_Pos4Center() {
        super();

        this.addParallel(new Auto_LoadBall());

        this.addSequential(new Auto_Pos4Center());

        this.addSequential(new Auto_CameraShootSequence());
    }

}
