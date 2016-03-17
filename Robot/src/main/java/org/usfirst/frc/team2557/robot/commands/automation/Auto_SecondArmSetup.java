package org.usfirst.frc.team2557.robot.commands.automation;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.secondArm.SecondArmReleaseCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_SecondArmSetup extends CommandGroup{

    public Auto_SecondArmSetup() {
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_RELEASE_SECOND_ARM));
        this.addSequential(new SecondArmReleaseCommand(), 1);
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_CLIMB));
    }

}
