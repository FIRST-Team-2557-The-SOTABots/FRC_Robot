package org.usfirst.frc.team2557.robot.commands.camera;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.subsystems.Camera;

public class CorrectDistanceToTargetCommand extends Command {

    private final double minShotDistance = 1.98; // Meters!
    private final double maxShotDistance = 3.5; // Meters!

    private PIDController _controlller;

    public CorrectDistanceToTargetCommand() {
        requires(Robot.chassis);
        requires(Robot.camera);

        // Kp, Ki, Kd
        this._controlller = new PIDController(0.2, 0.1, 0, new PIDSource() {
            @Override
            public void setPIDSourceType(PIDSourceType pidSource) {
            }

            @Override
            public PIDSourceType getPIDSourceType() {
                return PIDSourceType.kDisplacement;
            }

            @Override
            public double pidGet() {
                Camera.Target target = getTarget();
                if(target != null) {
                    return target.distance;
                }

                return (minShotDistance + maxShotDistance) / 2;
            }
        }, new PIDOutput() {
            @Override
            public void pidWrite(double output) {
                Robot.chassis.driveStraight(output);
            }
        });

        this._controlller.setInputRange(0, 5);
        this._controlller.setOutputRange(-1, 1);
        this._controlller.setPercentTolerance(10);
    }

    @Override
    protected void initialize() {
        this._controlller.reset();
        this._controlller.setSetpoint((minShotDistance + maxShotDistance) / 2);
        Robot.chassis.initDriveStraight();
    }

    @Override
    protected void execute() {
        this._controlller.enable();
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
            return true; // This should never happen if TurnToTarget is called first

        return this._controlller.onTarget();
    }

    @Override
    protected void end() {
        this._controlller.disable();
        Robot.chassis.set(0, 0);
    }

    @Override
    protected void interrupted() {
        this.end();
    }

}
