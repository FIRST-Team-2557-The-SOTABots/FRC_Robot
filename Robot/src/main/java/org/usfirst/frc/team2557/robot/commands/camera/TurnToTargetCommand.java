package org.usfirst.frc.team2557.robot.commands.camera;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.subsystems.Camera;

public class TurnToTargetCommand extends Command {

    private static final double tolerance = 5;

    private double speed;

    private PIDController _controller;

    public TurnToTargetCommand() {
        requires(Robot.chassis);
        requires(Robot.camera);

        this.speed = 0;

        // Kp, Ki, Kd
        this._controller = new PIDController(0.2, 0.1, 0, new PIDSource() {
            @Override
            public void setPIDSourceType(PIDSourceType pidSource) {}

            @Override
            public PIDSourceType getPIDSourceType() {
                return PIDSourceType.kDisplacement;
            }

            @Override
            public double pidGet() {
                Camera.Target target = getTarget();
                if(target != null) {
                    return target.offset;
                }
                return 20;
            }
        }, new PIDOutput() {
            @Override
            public void pidWrite(double output) {
                Robot.chassis.set(speed, -speed);
            }
        });

        this._controller.setInputRange(-Camera.cameraWidth / 2, Camera.cameraWidth / 2);
        this._controller.setOutputRange(-1, 1);
        this._controller.setAbsoluteTolerance(tolerance);
    }

    @Override
    protected void initialize() {
        this._controller.reset();
        this._controller.setSetpoint(0);
    }

    @Override
    protected void execute() {
        this._controller.enable();
    }

    private Camera.Target getTarget() {
        Camera.Target[] targets = Robot.camera.getTargets();
        Camera.Target trackedTarget = null;

        for(Camera.Target target : targets) {
            if(trackedTarget != null) {
//                if(trackedTarget.area < target.area
//                        || trackedTarget.solidity < target.solidity) {
                if(target.width > trackedTarget.width) {
                    trackedTarget = target;
                }
            }else{
                trackedTarget = target;
            }
        }

        return trackedTarget;
    }

    @Override
    protected boolean isFinished() {
        if(this.getTarget() == null)
            return false;

        return this._controller.onTarget();
    }

    @Override
    protected void end() {
        this._controller.disable();
        Robot.chassis.stop();
    }

    @Override
    protected void interrupted() {
        this.end();
    }

}
