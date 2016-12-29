package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.commands.CatapultRetractCommand;
import org.usfirst.frc.team2557.robot.commands.CatapultShootCommand;
import org.usfirst.frc.team2557.robot.commands.WaitForButtonCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CatapultSequence extends CommandGroup {
    
	public CatapultSequence() {
        this.addSequential(new CatapultRetractCommand());
        this.addSequential(new WaitForButtonCommand(Robot.oi.manipulatorStart));
        this.addSequential(new CatapultShootCommand());
    }
}
