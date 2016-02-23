package org.usfirst.frc.team2557.robot.commands.autonomous.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.commands.autonomous.*;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultRetractCommand;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultShootCommand;

public class Auto_Lowbar_Group extends CommandGroup {

    @Override
    public void initialize() {
        super.initialize();

        // TODO: Edit this sequence, it probably requires more steps than this

        this.addParallel(new Auto_ArmPosition(-35));
        this.addParallel(new CatapultRetractCommand());
        this.addSequential(new Auto_DriveToDefense());

        this.addSequential(new Auto_DistanceDrive(1, 0.5));

        this.addParallel(new Auto_ArmPosition(0));
        this.addSequential(new Auto_CameraAlignForShot());

        this.addSequential(new CatapultShootCommand());
    }

}
