package org.usfirst.frc.team2557.robot.commands.camera;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.subsystems.Camera;
import edu.wpi.first.wpilibj.Timer;

public class CorrectDistanceToTargetCommand extends Command {

    private final double minShotDistance = 1.98; // Meters!
    private final double maxShotDistance = 3.5; // Meters!

    private boolean _movingForward;
    private boolean _needsCorrection;
    private Timer _timer;

    public CorrectDistanceToTargetCommand() {
        requires(Robot.chassis);
        requires(Robot.camera);

        this._timer = new Timer();
    }

    @Override
    protected void initialize() {
        Robot.chassis.initDriveStraight();

        // Determine forward/backward to shoot
        Camera.Target target = this.getTarget();
        if(target != null) {
            this._needsCorrection = false;
            if(target.distance > maxShotDistance) {
                this._movingForward = true;
                this._needsCorrection = true;
            }
            if(target.distance < minShotDistance) {
                this._movingForward = false;
                this._needsCorrection = true;
            }

            this._timer.reset();
            this._timer.start();
        }
    }

    @Override
    protected void execute() {
        if(this._needsCorrection) {
            if (this._movingForward)
                Robot.chassis.driveStraight(0.75); // 75%
            else
                Robot.chassis.driveStraight(-0.75); // -75%
        }
    }

    private Camera.Target getTarget() {
        Camera.Target[] targets = Robot.camera.getTargets();
        Camera.Target trackedTarget = null;

        if(targets.length > 0) {
            return targets[0];
        }

        return trackedTarget;
    }

    @Override
    protected boolean isFinished() {
        if(this.getTarget() == null)
            return true; // This should never happen if TurnToTarget is called first

        if(!this._needsCorrection)
            return true;

        return this._timer.get() > 0.75;
    }

    @Override
    protected void end() {
        Robot.chassis.set(0, 0);
    }

    @Override
    protected void interrupted() {
        this.end();
    }

}
