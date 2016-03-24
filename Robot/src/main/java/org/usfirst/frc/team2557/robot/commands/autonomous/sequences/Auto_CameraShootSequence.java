package org.usfirst.frc.team2557.robot.commands.autonomous.sequences;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.camera.CorrectDistanceToTargetCommand;
import org.usfirst.frc.team2557.robot.commands.camera.TurnToTargetCommand;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultShootCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_CameraShootSequence extends CommandGroup {

    public Auto_CameraShootSequence() {
//        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_LOADBALL));
        this.addSequential(new TurnToTargetCommand()); // Turn to the target
        this.addSequential(new CorrectDistanceToTargetCommand()); // Correct our distance to the target
        this.addSequential(new WaitCommand(1.5)); // Wait for camera to update
        this.addSequential(new TurnToTargetCommand()); // Double check that we are aligned
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_BOTTOM)); // Lower the arm to the floor
        this.addSequential(new CatapultShootCommand()); // Shoot the ball!
    }

}
