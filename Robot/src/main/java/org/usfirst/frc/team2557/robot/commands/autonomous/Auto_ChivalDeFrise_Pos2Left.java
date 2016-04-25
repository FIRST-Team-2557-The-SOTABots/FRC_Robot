package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_CameraShootSequence;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_Pos2Left;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_Pos3Center;

public class Auto_ChivalDeFrise_Pos2Left extends Auto_ChivalDeFrise {

    public Auto_ChivalDeFrise_Pos2Left() {
        super();

        this.addParallel(new Auto_LoadBall());

        this.addSequential(new Auto_Pos2Left());

        this.addSequential(new Auto_CameraShootSequence());
    }

}
