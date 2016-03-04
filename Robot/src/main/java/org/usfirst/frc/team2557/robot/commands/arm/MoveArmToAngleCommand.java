package org.usfirst.frc.team2557.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;

public class MoveArmToAngleCommand extends Command {

    private final double tolerance = 0.1;

    private double potentiometerValue;

    public MoveArmToAngleCommand(double potentiometerValue) {
        requires(Robot.arm);

        this.potentiometerValue = potentiometerValue;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if(Robot.arm.getPotentiometerValue() > potentiometerValue) {
            Robot.arm.set(1);
        }
        if(Robot.arm.getPotentiometerValue() < potentiometerValue) {
            Robot.arm.set(-1);
        }
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(Robot.arm.getPotentiometerValue() - potentiometerValue) < tolerance;
    }

    @Override
    protected void end() {
        Robot.arm.set(0);
    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
