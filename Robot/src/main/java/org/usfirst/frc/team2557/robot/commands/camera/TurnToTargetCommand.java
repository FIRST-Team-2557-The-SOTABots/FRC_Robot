package org.usfirst.frc.team2557.robot.commands.camera;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.subsystems.Camera;

public class TurnToTargetCommand extends Command {

    private PIDController _controller;

    public TurnToTargetCommand() {

        // Kp, Ki, Kd, input (gyro), output (chassis)
        this._controller = new PIDController(0.025, 0.08, 0,
                new PIDSource() {
                    @Override
                    public void setPIDSourceType(PIDSourceType pidSource) {
                    }

                    @Override
                    public PIDSourceType getPIDSourceType() {
                        return PIDSourceType.kDisplacement;
                    }

                    @Override
                    public double pidGet() {
                        return Robot.chassis.getGyroAngle();
                    }
                }, new PIDOutput() {
            @Override
            public void pidWrite(double output) {
                Robot.chassis.set(output * 0.55, -output * 0.55);
            }
        });
        requires(Robot.chassis);

        this._controller.setContinuous(true);
        this._controller.setOutputRange(-1, 1);
        this._controller.setAbsoluteTolerance(0.5); // 1 degree tolerance
    }

    @Override
    protected void initialize() {
        // Reset the gyro
        Robot.chassis.resetGyro();
        // Reset the PID
        this._controller.reset();

        Camera.Target target = Robot.camera.getTarget();
        if(target != null) {
            double degrees = (target.centerX - Camera.cameraWidth / 2) * Camera.degreesPerWidth;

            // Set the setpoint for the PID
            this._controller.setSetpoint(degrees - 7);
        }
    }

    @Override
    protected void execute() {
        this._controller.enable();
    }

    @Override
    protected boolean isFinished() {
        return this._controller.onTarget();
    }

    protected void end() {
        this._controller.disable();
    }

    @Override
    protected void interrupted() {
        this.end();
    }

}
