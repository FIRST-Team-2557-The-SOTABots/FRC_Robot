package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultRetractCommand;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultShootCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Auto_SpyBoxShoot extends CommandGroup {
	
	public Auto_SpyBoxShoot() {
		this.addSequential(new CatapultRetractCommand());
		this.addSequential(new Auto_LoadBall()); // Load ball!
		this.addSequential(new MoveArmToAngleCommand(Arm.ARM_BOTTOM));
		this.addSequential(new CatapultShootCommand()); // Shoot the ball!
	}
	
}