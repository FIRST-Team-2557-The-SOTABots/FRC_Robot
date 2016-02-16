package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2557.robot.RobotMap;

/**
 * Approximates the current position of the robot
 * from the starting position using Euler's method
 * of approximating integrals.
 *
 * TODO: 2d positioning
 * TODO: Rotation using encoders on wheels
 * TODO: Displacement/Velocity using encoders(?)
 */
public class PositionSub extends Subsystem {

    private Timer _eulerTimer;

    private double _displacement;
    private double _velocity;

    public PositionSub() {
        this._eulerTimer = new Timer();
    }

    @Override
    protected void initDefaultCommand() {

    }

    public void update() {
        // Assumes accelerometer is in m/s/s
        this._velocity += RobotMap.rioAccelerometer.getY() * this._eulerTimer.get();
        this._displacement += this._velocity * this._eulerTimer.get();

        this._eulerTimer.reset();
    }

    public void reset() {
        this._displacement = 0.0;
        this._velocity = 0.0;
        this._eulerTimer.reset();
        this._eulerTimer.start();
    }

}
