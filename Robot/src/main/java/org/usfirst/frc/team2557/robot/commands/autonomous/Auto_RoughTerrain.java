package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_CameraShootSequence;
import org.usfirst.frc.team2557.robot.commands.chassis.DistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TimeDriveCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_RoughTerrain extends CommandGroup {

    public Auto_RoughTerrain() {

        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_ROUGH_DEFENSE)); // Move the arm to a relatively high angle
        this.addSequential(new Auto_DriveToDefense()); // Drive the the defense
        this.addSequential(new DistanceDriveCommand(1.5, 0.85)); // Drive over the rough terrain
//        this.addSequential(new TimeDriveCommand(3, 0.85));
        this.addSequential(new Auto_LoadBall()); // Load ball!
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_LOWBAR));

//        this.addSequential(new Auto_CameraShootSequence());
    }

}
