package org.usfirst.frc.team2557.robot.commands.arm;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

public class MoveArmToAngleCommand extends Command {

    private PIDController _controller;

    private double _value;

    public MoveArmToAngleCommand(double potentiometerValue) {
        this._value = potentiometerValue;
        requires(Robot.arm);

        this._controller = new PIDController(0.3, 0.15, 0, new PIDSource() {
            @Override
            public void setPIDSourceType(PIDSourceType pidSource) {}

            @Override
            public PIDSourceType getPIDSourceType() {
                return PIDSourceType.kDisplacement;
            }

            @Override
            public double pidGet() {
                return Robot.arm.returnPIDInput();
            }
        }, new PIDOutput() {
            @Override
            public void pidWrite(double output) {
                Robot.arm.usePIDOutput(output);
            }
        });

        this._controller.setInputRange(0, 5);
        this._controller.setOutputRange(-1, 1);
        this._controller.setAbsoluteTolerance(0.05);
    }

    @Override
    protected void initialize() {
        this._controller.reset();
        this._controller.setSetpoint(this._value);
    }

    @Override
    protected void execute() {
        this._controller.enable();

        SmartDashboard.putNumber("Arm PID Setpoint", this._controller.getSetpoint());
        SmartDashboard.putNumber("Arm PID Error", this._controller.getError());
        SmartDashboard.putBoolean("Arm PID On Target", this._controller.onTarget());
    }

    @Override
    protected boolean isFinished() {
        return this._controller.onTarget();
    }

    @Override
    protected void end() {
        this._controller.disable();
    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
