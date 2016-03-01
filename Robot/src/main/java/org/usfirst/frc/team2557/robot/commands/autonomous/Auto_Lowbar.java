package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.arm.LoadBallArmAngle;
import org.usfirst.frc.team2557.robot.commands.autonomous.*;
import org.usfirst.frc.team2557.robot.commands.camera.CorrectDistanceToTargetCommand;
import org.usfirst.frc.team2557.robot.commands.camera.TurnToTargetCommand;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultRetractCommand;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultShootCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.DistanceDriveCommand;

public class Auto_Lowbar extends CommandGroup {

    public Auto_Lowbar() {

        // Parallels that run together with a sequential
        // are added before a sequential!

        // TODO: Edit this sequence, it probably requires more steps than this

        // TODO: Change the "Auto_ArmPosition(n)" to actual commands for positions (eg. LoadBallArmAngle)
//        this.addParallel(new Auto_ArmPosition(-35)); // Lower the arm to the lowbar position
        this.addParallel(new CatapultRetractCommand()); // Retract the catapult on the way to the lowbar
        this.addSequential(new Auto_DriveToDefense()); // Drive the the defense

        this.addSequential(new DistanceDriveCommand(5, 0.25)); // Drive through the lowbar

        // Load ball! (we are still holding onto it...)
        this.addSequential(new LoadBall());

        // TODO: Parallel to lower the arm to the floor
        this.addSequential(new TurnToTargetCommand(0.25));
        this.addSequential(new CorrectDistanceToTargetCommand());

        // Shoot the ball!
        this.addSequential(new CatapultShootCommand());

    }

}
