package org.usfirst.frc.team2557.robot.commands.camera;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.subsystems.Camera;

public class TurnToTargetCommand extends Command {

    private static final double tolerance = 5;

    private double speed;

    public TurnToTargetCommand(double speed) {
        requires(Robot.chassis);
        requires(Robot.camera);

        this.speed = speed;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Camera.Target target = this.getTarget();
        if(target == null) {
            Robot.chassis.set(speed, -speed);
        }else {
            double direction = (target.offset > 0) ? 1 : -1;
            Robot.chassis.set(speed * direction, -speed * direction);
        }
    }

    private Camera.Target getTarget() {
        Camera.Target[] targets = Robot.camera.getTargets();
        Camera.Target trackedTarget = null;

        for(Camera.Target target : targets) {
            if(trackedTarget != null) {
//                if(trackedTarget.area < target.area
//                        || trackedTarget.solidity < target.solidity) {
                if(trackedTarget.width < target.width) {
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

        return Math.abs(this.getTarget().offset) - tolerance <= 0;
    }

    @Override
    protected void end() {
        Robot.chassis.stop();
    }

    @Override
    protected void interrupted() {
        this.end();
    }

}
