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

    public enum ForwardAxis {
        X,
        Y,
        Z,
        NegX,
        NegY,
        NegZ
    }

    private Accelerometer _accelSensor;
    private ForwardAxis _forwardAxis;

    private double _velocity;
    private double _displacement;
    private Timer _eTimer;

    /**
     * Constructs a EulerDistanceEstimator.
     * @param accelerometer The accelerometer objects that is used to approximate
     * @param forwardAxis The axis of the accelerometer that points forward
     */
    public EulerDistanceEstimator(Accelerometer accelerometer, ForwardAxis forwardAxis) {
        this._accelSensor = accelerometer;
        this._forwardAxis = forwardAxis;

        this._eTimer = new Timer();
        this._eTimer.start(); // Start the timer right away, reset everything (including timer) when an "autoInit" is called
    }

    /**
     * Gets the reference for the accelerometer used for approximation.
     * @return Accelerometer used for approximation
     */
    public Accelerometer getAccelerometer() {
        return this._accelSensor;
    }

    /**
     * Updates the velocity and displacement. This should
     * be called every periodic.
     */
    public void update() {
        // d = v(dt) + (1/2)a(dt^2)
        this._displacement += this._velocity * this._eTimer.get()
                + (this.getAcceleration() * Math.pow(this._eTimer.get(), 2)) / 2;
        // v = a(dt)
        // This is as close as we can get since we don't have jerk (the derivative of acceleration)
        this._velocity += this._accelSensor.getY() * this._eTimer.get();
        // Reset the timer for the next step (delta time)
        this._eTimer.reset();
    }

    /**
     * MUST BE CALLED IN AUTO INIT!
     * Initializes the estimator for use.
     */
    public void autoInit() {
        this._velocity = 0;
        this._displacement = 0;
        this._eTimer.reset();
    }

    /**
     * Resets the displacement to zero
     */
    public void reset() {
        this._displacement = 0;
    }

    /**
     * Gets the current approximated displacement (distance with direction)
     * in meters. Error increases over time.
     * @return Current approximated displacement in meters
     */
    public double getDisplacement() {
        return this._displacement;
    }
    /**
     * Gets the current approximated distance in meters. Error
     * increases over time.
     * @return Current approximated distance in meters
     */
    public double getDistance() {
        return Math.abs(this._displacement);
    }

    /**
     * Gets the current approximated velocity (speed with direction)
     * in meters per second. Error incraeses over time.
     * @return Current approximated velocity in m/s
     */
    public double getVelocity() {
        return this._velocity;
    }
    /**
     * Gets the current approximated speed in meters per
     * second. Error increases over time.
     * @return Current approximated speed in m/s
     */
    public double getSpeed() {
        return Math.abs(this._velocity);
    }

    /**
     * Reads the current acceleration in meters per second
     * per second.
     * @return Current acceleration in m/s/s
     */
    public double getAcceleration() {
        double Gs = 0;

        switch(this._forwardAxis) {
            case X:
                Gs = this._accelSensor.getX();
            case NegX:
                Gs = this._accelSensor.getX() * -1;
                break;
            case Y:
                Gs = this._accelSensor.getY();
                break;
            case NegY:
                Gs = this._accelSensor.getY() * -1;
                break;
            case Z:
                Gs = this._accelSensor.getZ();
                break;
            case NegZ:
                Gs = this._accelSensor.getZ() * -1;
                break;
        }

        // One "g" is 9.81m/s/s
        return Gs * 9.81;
    }

}

