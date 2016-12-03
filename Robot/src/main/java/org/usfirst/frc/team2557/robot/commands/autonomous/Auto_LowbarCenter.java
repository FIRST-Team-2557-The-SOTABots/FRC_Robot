package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultRetractCommand;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultShootCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_LowbarCenter extends Auto_Lowbar {

    public Auto_LowbarCenter() {

        this.addParallel(new Auto_LoadBall());

        this.addSequential(new TurnByAngleCommand(60));

        this.addSequential(new EncoderPosDriveCommand(18508, 1));

        this.addSequential(new TurnByAngleCommand(-60));

        this.addSequential(new EncoderPosDriveCommand(1533, 0.75));

        // Onto batter, shoot
        this.addSequential(new EncoderPosDriveCommand(4058, 0.5));

        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_BOTTOM));

        this.addSequential(new CatapultShootCommand());

    }

}
