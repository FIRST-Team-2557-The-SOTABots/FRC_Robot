package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_CameraShootSequence;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultShootCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.DistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TimeDriveCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_ChivalDeFrise extends CommandGroup {

    public Auto_ChivalDeFrise() {

        this.addParallel(new MoveArmToAngleCommand(Arm.ARM_LOADBALL)); // Move the arm to a position taller than the ramps (vv)
        this.addSequential(new Auto_DriveToDefense()); // Drive the the defense
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_LOWBAR)); // Lower the arm to push down the ramps
//        this.addSequential(new DistanceDriveCommand(0.35, 0.5)); // Drive on the chival de frise
        this.addSequential(new TimeDriveCommand(0.75, 0.75));
        this.addParallel(new MoveArmToAngleCommand(Arm.ARM_LOADBALL)); // Move the arm back up (vv)
//        this.addSequential(new DistanceDriveCommand(1, 0.5)); // Drive over the chival de frise
        this.addSequential(new TimeDriveCommand(0.75, 1));
        this.addSequential(new Auto_LoadBall()); // Load ball!
//        this.addSequential(new Auto_CameraShootSequence());
        this.addSequential(new CatapultShootCommand());

    }

}
