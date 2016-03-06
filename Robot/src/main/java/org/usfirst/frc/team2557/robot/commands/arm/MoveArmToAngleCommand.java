package org.usfirst.frc.team2557.robot.commands.arm;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class MoveArmToAngleCommand extends Command {
    private double potentiometerValue;

    public MoveArmToAngleCommand(double potentiometerValue) {
        requires(Robot.arm);

        this.potentiometerValue = potentiometerValue;
    }

    @Override
    protected void initialize() {
        Robot.arm.setSetpoint(this.potentiometerValue);
    }

    @Override
    protected void execute() {
        Robot.arm.enable();
    }

    @Override
    protected boolean isFinished() {
        return Robot.arm.onTarget();
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
