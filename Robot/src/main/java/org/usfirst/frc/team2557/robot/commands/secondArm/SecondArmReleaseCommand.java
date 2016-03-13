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
        // Final check
//		if(Robot.oi.driverBack.get() && Robot.oi.driverStart.get()){
//			Robot.secondArm.release();
//		}
		if(Robot.oi.button11.get()){
			RobotMap.secondaryArm.setAngle(0);
		} else if(Robot.oi.button12.get()){
			RobotMap.secondaryArm.setAngle(90);
		} else{
			RobotMap.secondaryArm.set(0);
		}

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
