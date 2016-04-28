package org.usfirst.frc.team2557.robot.commands.autonomous.sequences;

import edu.wpi.first.wpilibj.command.CommandGroup;

import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.camera.TurnToTargetCommand;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultShootCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_CameraShootSequence extends CommandGroup {

    public Auto_CameraShootSequence() {
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_CAMERA));

        this.addSequential(new WaitCommand(0.75));

        this.addSequential(new TurnToTargetCommand()); // Turn to the widest thing

        this.addParallel(new MoveArmToAngleCommand(Arm.ARM_BOTTOM));
        this.addSequential(new EncoderPosDriveCommand(4058, 0.4)); // Move onto the batter

        this.addSequential(new CatapultShootCommand()); // Shoot the ball!
    }

}
