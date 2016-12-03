package org.usfirst.frc.team2557.robot.commands.catapult;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.commands.util.WaitForButtonCommand;

public class CatapultSequence extends CommandGroup {

    public CatapultSequence() {
        this.addSequential(new CatapultRetractCommand());
        this.addSequential(new WaitForButtonCommand(Robot.oi.manipulatorStart));
        this.addSequential(new CatapultShootCommand());
    }

}
