package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

public class Auto_RetractCatapult extends Command {
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        RobotMap.catapultMotor.set(1.0);
    }

    @Override
    protected boolean isFinished() {
        return RobotMap.catapultHallEffect.get();
    }

    @Override
    protected void end() {
        RobotMap.catapultMotor.set(0);
    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
