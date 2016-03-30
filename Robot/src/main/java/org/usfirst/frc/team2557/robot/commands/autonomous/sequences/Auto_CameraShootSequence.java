package org.usfirst.frc.team2557.robot.commands.autonomous.sequences;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.camera.TurnToTargetCommand;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultShootCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_CameraShootSequence extends CommandGroup {

    public Auto_CameraShootSequence() {
        this.addSequential(new TurnToTargetCommand()); // Turn to the large
    	this.addSequential(new MoveArmToAngleCommand(Arm.ARM_BOTTOM));
        this.addSequential(new CatapultShootCommand()); // Shoot the ball!
    }

}
