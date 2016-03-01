package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.arm.LoadBallArmAngle;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeInCommand;

public class LoadBall extends CommandGroup {

    public LoadBall() {
        // Move the arm to the correct position
        this.addSequential(new LoadBallArmAngle());
        // Spin the intake for 2 seconds
        this.addSequential(new IntakeInCommand(), 2.0);
    }

}
