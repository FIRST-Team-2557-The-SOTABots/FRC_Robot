package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_CameraShootSequence;
import org.usfirst.frc.team2557.robot.commands.camera.CorrectDistanceToTargetCommand;
import org.usfirst.frc.team2557.robot.commands.camera.TurnToTargetCommand;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultShootCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.DistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TimeDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_Lowbar extends CommandGroup {

    public Auto_Lowbar() {

        // Parallels that run with a sequential
        // are added before that sequential!

        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_LOWBAR));
        this.addSequential(new Auto_DriveToDefense()); // Drive the the defense
        this.addSequential(new TimeDriveCommand(5, 0.7)); // Drive through the lowbar
        this.addSequential(new TurnByAngleCommand(45));
        this.addSequential(new Auto_LoadBall()); // Load ball!

        this.addSequential(new Auto_CameraShootSequence());

    }

}
