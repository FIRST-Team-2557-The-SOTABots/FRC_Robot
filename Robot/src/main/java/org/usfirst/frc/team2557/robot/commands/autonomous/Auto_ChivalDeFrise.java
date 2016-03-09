package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.camera.CorrectDistanceToTargetCommand;
import org.usfirst.frc.team2557.robot.commands.camera.TurnToTargetCommand;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultShootCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.DistanceDriveCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_ChivalDeFrise extends CommandGroup {

    public Auto_ChivalDeFrise() {

        this.addParallel(new MoveArmToAngleCommand(Arm.ARM_LOADBALL)); // Move the arm to a position taller than the ramps (vv)
        this.addSequential(new Auto_DriveToDefense()); // Drive the the defense
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_LOWBAR)); // Lower the arm to push down the ramps
        this.addSequential(new DistanceDriveCommand(0.35, 0.5)); // Drive on the chival de frise
        this.addParallel(new MoveArmToAngleCommand(Arm.ARM_LOADBALL)); // Move the arm back up (vv)
        this.addSequential(new DistanceDriveCommand(1, 0.5)); // Drive over the chival de frise
        this.addSequential(new Auto_LoadBall()); // Load ball!
        this.addSequential(new TurnToTargetCommand()); // Turn to the target
        this.addSequential(new CorrectDistanceToTargetCommand()); // Correct our distance to the target
        this.addSequential(new TurnToTargetCommand()); // Double check that we are aligned
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_LOWBAR)); // Lower the arm to the floor
        this.addSequential(new CatapultShootCommand()); // Shoot the ball!

    }

}
