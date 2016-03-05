package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeInCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class LoadBall extends CommandGroup {

    public LoadBall() {
        // Move the arm to the correct position
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_LOADBALL));
        // Spin the intake for 2 seconds
        this.addSequential(new IntakeInCommand(), 2.0);
    }

}
