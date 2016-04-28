package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.autonomous.resolvers.PosBatterResolverCommand;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultRetractCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TimeDriveCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class Auto_RoughTerrain extends CommandGroup {

    public Auto_RoughTerrain() {

        this.addParallel(new CatapultRetractCommand());
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_ROUGH_DEFENSE)); // Move the arm to a relatively high angle

        this.addSequential(new EncoderPosDriveCommand(21222, 0.85));

        this.addSequential(new PosBatterResolverCommand());

    }

}
