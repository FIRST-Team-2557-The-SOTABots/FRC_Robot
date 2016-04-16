package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultRetractCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TimeDriveCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_Portcullis extends CommandGroup {

    public Auto_Portcullis() {
        this.addParallel(new Auto_LoadBall()); // Load ball!
        this.addSequential(new CatapultRetractCommand());

        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_LOWBAR)); // Move the arm down
        this.addSequential(new Auto_DriveToDefense()); // Drive to the defense
//        this.addSequential(new DistanceDriveCommand(1.5, 0.8)); // Drive through the portcullis (fast enough will bounce the gate up high enough)
        this.addSequential(new TimeDriveCommand(2, 0.8));

//        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_CAMERA)); // Move the arm so the camera can see
//        this.addSequential(new WaitCommand(1.5)); // Wait for the camera to update
//
//        this.addSequential(new Auto_CameraShootSequence());

    }
}
