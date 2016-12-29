package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.arm.LoadBallArmAngle;
import org.usfirst.frc.team2557.robot.commands.arm.LowbarArmAngle;
import org.usfirst.frc.team2557.robot.commands.chassis.DistanceDriveCommand;

public class Auto_ChivalDeFrise extends CommandGroup {

    public Auto_ChivalDeFrise() {

        // Parallels that run together with a sequential
        // are added before a sequential!

        // TODO: Edit this sequence, it probably requires more steps than this

        // TODO: Change the "Auto_ArmPosition(n)" to actual commands for positions (eg. LoadBallArmAngle)
//        this.addParallel(new Auto_ArmPosition(-35)); // Lower the arm to the lowbar position
//        this.addParallel(new CatapultRetractCommand()); // Retract the catapult on the way to the lowbar
        this.addParallel(new LoadBallArmAngle());
        this.addSequential(new Auto_DriveToDefense()); // Drive the the defense

        this.addSequential(new LowbarArmAngle());

        this.addSequential(new DistanceDriveCommand(0.35, 0.5)); // Drive through the lowbar

        this.addParallel(new LoadBallArmAngle());
        this.addSequential(new DistanceDriveCommand(1.5, 0.5));

        // Load ball! (we are still holding onto it...)
        this.addSequential(new LoadBall());

        // TODO: Parallel to lower the arm to the floor
//        this.addSequential(new TurnToTargetCommand(0.25));
//        this.addSequential(new CorrectDistanceToTargetCommand());

        // Shoot the ball!
//        this.addSequential(new CatapultShootCommand());

    }

}
