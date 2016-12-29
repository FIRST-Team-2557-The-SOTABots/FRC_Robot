package org.usfirst.frc.team2557.math;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 * Estimates displacement and velocity using an
 * accelerometer and Euler's method of integral
 * approximation.
 *
 * @author Philip Rader
 *
 */
public class EulerDistanceEstimator {

    private Accelerometer _accelSensor;

    private double _velocity;
    private double _displacement;
    private Timer _eTimer;

    /**
     * Constructs a EulerDistanceEstimator.
     * @param accelerometer The accelerometer objects that is used to approximate
     */
    public EulerDistanceEstimator(Accelerometer accelerometer) {
        this._accelSensor = accelerometer;

        this._eTimer = new Timer();
        this._eTimer.start(); // Start the timer right away, reset everything (including timer) when an "init" is called
    }

    /**
     * Gets the reference for the accelerometer used for approximation.
     * @return Accelerometer used for approximation
     */
    public Accelerometer getAccelerometer() {
        return this._accelSensor;
    }

    /**
     * Updates the velocity and displacement. Should be called
     * once and only once during each periodic (step).
     */
    public void update() {
        // Acceleration is measured in m/s/s,
        // multiply acceleration by seconds and you
        // are left with m/s (velocity)
        this._velocity += this._accelSensor.getY() * this._eTimer.get();
        // Velocity is measured in m/s,
        // multiply velocity by seconds and you
        // are left with m (displacement)
        this._displacement += this._velocity * this._eTimer.get();
        // Reset the timer for the next step (delta time)
        this._eTimer.reset();
    }

    /**
     * Resets the displacement and velocity to zero.
     */
    public void reset() {
        this._velocity = 0;
        this._displacement = 0;
        this._eTimer.reset();
    }

    /**
     * Gets the current approximated displacement (distance with direction)
     * in meters. Error increases over time.
     * @return Current approximated displacement in meters
     */
    public double getDisplacement() {
        return this._displacement * 10;
    }
    /**
     * Gets the current approximated distance in meters. Error
     * increases over time.
     * @return Current approximated distance in meters
     */
    public double getDistance() {
        return Math.abs(this._displacement) * 10;
    }

    /**
     * Gets the current approximated velocity (speed with direction)
     * in meters per second. Error incraeses over time.
     * @return Current approximated velocity in m/s
     */
    public double getVelocity() {
        return this._velocity * 10;
    }
    /**
     * Gets the current approximated speed in meters per
     * second. Error increases over time.
     * @return Current approximated speed in m/s
     */
    public double getSpeed() {
        return Math.abs(this._velocity) * 10;
    }

}

