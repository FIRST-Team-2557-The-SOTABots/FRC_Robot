package org.usfirst.frc.team2557.robot.commands.secondArm;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SecondArmReleaseCommand extends Command {

    public SecondArmReleaseCommand() {
        requires(Robot.secondArm);
    }

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Robot.secondArm.release();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
	}

}
