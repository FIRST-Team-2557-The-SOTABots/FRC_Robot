package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.autonomous.resolvers.PosBatterResolverCommand;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultRetractCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TimeDriveCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

//public class Auto_ChivalDeFrise extends CommandGroup {
//
//    public Auto_ChivalDeFrise() {
//
//        this.addParallel(new MoveArmToAngleCommand(Arm.ARM_LOADBALL)); // Move the arm to a position taller than the ramps (vv)
//        this.addParallel(new CatapultRetractCommand());
//
//        this.addSequential(new WaitCommand(0.5));
//        this.addSequential(new EncoderPosDriveCommand(2085, 0.75));
//
//        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_LOWBAR));
//
//        this.addSequential(new EncoderPosDriveCommand(3802, 0.8));
//
//        this.addParallel(new MoveArmToAngleCommand(Arm.ARM_ROUGH_DEFENSE));
//        this.addSequential(new EncoderPosDriveCommand(9530, 0.8));
//
//        this.addSequential(new PosBatterResolverCommand());
//    }
//
//}

public class Auto_ChivalDeFrise extends CommandGroup {

    public Auto_ChivalDeFrise() {

        this.addParallel(new MoveArmToAngleCommand(Arm.ARM_LOADBALL));
        this.addSequential(new TimeDriveCommand(3, 0.5));

        this.addParallel(new CatapultRetractCommand());
        this.addSequential(new MoveArmToAngleCommand(Arm.ARM_BOTTOM));

        this.addSequential(new TimeDriveCommand(1, 0.75));

        this.addParallel(new MoveArmToAngleCommand(Arm.ARM_LOADBALL));
        this.addSequential(new TimeDriveCommand(0.75, 1));

    }

}