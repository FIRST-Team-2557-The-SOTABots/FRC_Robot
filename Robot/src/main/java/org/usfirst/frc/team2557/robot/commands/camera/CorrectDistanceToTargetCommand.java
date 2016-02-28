package org.usfirst.frc.team2557.robot.commands.camera;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.subsystems.Camera;

public class CorrectDistanceToTargetCommand extends Command {

    private final double minShotDistance = 3;
    private final double maxShotDistnace = 4;

    private double speed;

    public CorrectDistanceToTargetCommand(double speed) {
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
        if(target != null) {
            Robot.chassis.driveStraight(this.manipulateWithDistance(target.distance));
        }
    }

    private double manipulateWithDistance(double distance) {
        double x = distance - (minShotDistance + maxShotDistnace) / 2 + 3;
        return (x * x - 10) / (x * x);
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
            return true;

        return this.getTarget().distance >= minShotDistance && this.getTarget().distance <= maxShotDistnace;
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
