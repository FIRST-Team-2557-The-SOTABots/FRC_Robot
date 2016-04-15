package org.usfirst.frc.team2557.robot.commands.chassis;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;

public class SpeedDriveCommand extends Command {

    public static final double MAX_SPEED = 0; // TODO: Find max encoder speed

    private final double Kp = 0.25;
    private final double Ki = 0.15;
    private final double Kd = 0;

    private PIDController _leftSpeedController;
    private PIDController _rightSpeedController;

    private double leftSpeed = 0;
    private double rightSpeed = 0;


    public SpeedDriveCommand(double leftSpeed, double rightSpeed) {
        requires(Robot.chassis);

        this.leftSpeed = leftSpeed * MAX_SPEED;
        this.rightSpeed = rightSpeed * MAX_SPEED;

        this._leftSpeedController = new PIDController(Kp, Ki, Kd,
                Robot.chassis.getLeftPIDSource(),
                Robot.chassis.getLeftPIDOutput());
        this._rightSpeedController = new PIDController(Kp, Ki, Kd,
                Robot.chassis.getRightPIDSource(),
                Robot.chassis.getRightPIDOutput());

        this._leftSpeedController.setInputRange(-MAX_SPEED, MAX_SPEED);
        this._rightSpeedController.setInputRange(-MAX_SPEED, MAX_SPEED);

        this._leftSpeedController.setOutputRange(-1, 1);
        this._rightSpeedController.setOutputRange(-1, 1);

        this._leftSpeedController.setPercentTolerance(1);
        this._rightSpeedController.setPercentTolerance(1);
    }

    @Override
    protected void initialize() {
        this._leftSpeedController.reset();
        this._rightSpeedController.reset();

        this._leftSpeedController.setSetpoint(leftSpeed);
        this._rightSpeedController.setSetpoint(rightSpeed);
    }

    @Override
    protected void execute() {
        this._leftSpeedController.enable();
    }

    @Override
    protected boolean isFinished() {
        return false; // This command should be stopped by a timeout
    }

    @Override
    protected void end() {
        this._leftSpeedController.disable();
        this._rightSpeedController.disable();
    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
