package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_CameraShootSequence;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultRetractCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.DistanceDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TimeDriveCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_Moat extends CommandGroup {

    public Auto_Moat() {

        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_ROUGH_DEFENSE)); // Move the arm to a relatively high angle
        this.addParallel(new CatapultRetractCommand());
        this.addSequential(new Auto_DriveToDefense()); // Drive the the defense
//        this.addSequential(new DistanceDriveCommand(1.5, 0.9)); // Drive over the moat
        this.addSequential(new TimeDriveCommand(2.3, 0.9));
        this.addSequential(new Auto_LoadBall()); // Load ball!

        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_CAMERA)); // Move the arm so the camera can see
        this.addSequential(new WaitCommand(1.5)); // Wait for the camera to update

        this.addSequential(new Auto_CameraShootSequence());

    }

}
