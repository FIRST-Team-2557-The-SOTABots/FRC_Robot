package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultRetractCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.CorrectAngleOffsetCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeInCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_Portcullis extends CommandGroup {

    public Auto_Portcullis() {
        this.addSequential(new CatapultRetractCommand());
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_LOADBALL)); // Load ball!

        this.addParallel(new IntakeInCommand(), 2);
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_LOWBAR)); // Move the arm down

        this.addSequential(new EncoderPosDriveCommand(8399, 1)); // Move to the middle of the portcullis

        this.addParallel(new MoveArmToAngleCommand(Arm.ARM_ROUGH_DEFENSE));
        this.addSequential(new EncoderPosDriveCommand(10615, 1)); // Move to the green tape

        this.addSequential(new CorrectAngleOffsetCommand());

    }
}