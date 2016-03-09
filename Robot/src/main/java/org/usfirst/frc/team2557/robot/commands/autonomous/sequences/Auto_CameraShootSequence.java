package org.usfirst.frc.team2557.robot.commands.autonomous.sequences;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.camera.CorrectDistanceToTargetCommand;
import org.usfirst.frc.team2557.robot.commands.camera.TurnToTargetCommand;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultShootCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_CameraShootSequence extends CommandGroup {

    public Auto_CameraShootSequence() {

        this.addSequential(new TurnToTargetCommand()); // Turn to the target
        this.addSequential(new CorrectDistanceToTargetCommand()); // Correct our distance to the target
        this.addSequential(new TurnToTargetCommand()); // Double check that we are aligned
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_LOWBAR)); // Lower the arm to the floor
        this.addSequential(new CatapultShootCommand()); // Shoot the ball!

    }

}
