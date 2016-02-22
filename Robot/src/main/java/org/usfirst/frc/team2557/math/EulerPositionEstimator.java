package org.usfirst.frc.team2557.math;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 * Estimates displacement and velocity using an
 * accelerometer and Euler's method of integral
 * approximation.
 *
 * @author Philip Rader
 *
 */
public class EulerPositionEstimator {

    private boolean _isInitialized = false;

    private Accelerometer _accelSensor;
    private Gyro _gyro;

    private double _velocityX;
    private double _velocityY;
    private double _displacementX;
    private double _displacementY;
    private Timer _eTimer;

    /**
     * Constructs a EulerPositionEstimator.
     * @param accelerometer The accelerometer object that is used to approximate
     * @param gyro The gyro object that is used to approximate position
     */
    public EulerPositionEstimator(Accelerometer accelerometer, Gyro gyro) {
        this._accelSensor = accelerometer;
        this._gyro = gyro;

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

    /* CUSTOM GYRO IMPLEMENTATIONS SO THAT THE GYRO DOESN'T GET RESET ACCIDENTALLY! */
    private double _gyroOffset = 0;

    /**
     * Resets the angle of the gyro to zero
     */
    public void resetGyro() {
        this._gyroOffset = this._gyro.getAngle();
    }

    /**
     * Gets the current angle of the gyro
     * @return Angle of the gyro
     */
    public double getGyroAngle() {
        return this._gyro.getAngle() - this._gyroOffset;
    }

    /**
     * Gets the current angle the robot is facing
     * @return Angle of robot
     */
    public double getAngle() {
        return this._gyro.getAngle();
    }

    /**
     * Updates the velocity and displacement. Should be called
     * once and only once during each periodic (step).
     */
    public void update() {
        // Acceleration is measured in cm/s/s,
        // multiply acceleration by seconds and you
        // are left with cm/s (velocity)
        this._velocityX = Math.sin(this._gyro.getAngle()) * this._accelSensor.getY() * this._eTimer.get() + this._velocityX;
        this._velocityY = Math.cos(this._gyro.getAngle()) * this._accelSensor.getY() * this._eTimer.get() + this._velocityY;
        // Velocity is measured in cm/s,
        // multiply velocity by seconds and you
        // are left with cm (displacement)
        this._displacementX = Math.sin(this._gyro.getAngle()) * this._velocityX * this._eTimer.get() + this._displacementX;
        this._displacementY = Math.cos(this._gyro.getAngle()) * this._velocityY * this._eTimer.get() + this._displacementY;
        // Reset the timer for the next step (delta time)
        this._eTimer.reset();
    }

    /**
     * Resets the displacement and velocity to zero.
     */
    public void reset() {
        this._velocityX = 0;
        this._velocityY = 0;
        this._displacementX = 0;
        this._displacementY = 0;
        this._eTimer.reset();
    }

    /**
     * Initializes the estimator
     */
    public void init() {
        if(!this._isInitialized) {
            this.reset();

            this._gyro.reset();
        }
    }

    /**
     * Gets the current approximated x displacement
     * in meters. Error increases over time.
     * @return Current approximated x displacement in meters
     */
    public double getDisplacementX() {
        return this._displacementX * 10;
    }

    /**
     * Gets the current approximated y displacement
     * in meters. Error increases over time.
     * @return Current approximated y displacement in meters
     */
    public double getDisplacementY() {
        return this._displacementY * 10;
    }

    /**
     * Gets the current approximated x velocity
     * in meters per second. Error increases over time.
     * @return Current approximated x velocity in m/s
     */
    public double getVelocityX() {
        return this._velocityX * 10;
    }

    /**
     * Gets the current approximated y velocity
     * in meters per second. Error increases over time.
     * @return Current approximated y velocity in m/s
     */
    public double getVelocityY() {
        return this._velocityY * 10;
    }

}

