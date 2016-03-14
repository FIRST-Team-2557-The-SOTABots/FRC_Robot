package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.arm.TeleopArmCommand;

public class Arm extends Subsystem {

    public static final double ARM_LOWBAR = 4.081,
        ARM_LOADBALL = 2.648,
        ARM_ROUGH_DEFENSE = 3;

    public static final double deadzone = 0.1;

//    private static final double ARM_MIN_SPEED = -0,
//        ARM_MAX_SPEED = 0; // These values need to be determined experimentally!
    private static final double ARM_MAX_SPEED = -0.75;

    private CANTalon leftActuator = RobotMap.leftActuatorMotor;
    private CANTalon rightActuator = RobotMap.rightActuatorMotor;

    private AnalogInput leftPotentiometer = RobotMap.leftPotentiometer;
    private AnalogInput rightPotentiometer = RobotMap.rightPotentiometer;

    private double prevLeftVal = 0;
    private double prevRightVal = 0;

    private double leftSpeed = 0;
    private double rightSpeed = 0;

    private final double Kp = 0.25;
    private final double Ki = 0.15;
    private final double Kd = 0;
    private PIDController _leftSpeedController;
    private PIDController _rightSpeedController;

    private Timer _elapsedTimer;

    public Arm() {
        this._leftSpeedController = new PIDController(Kp, Ki, Kd,
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
                        return leftSpeed;
                    }
                }, new PIDOutput() {
                    @Override
                    public void pidWrite(double output) {
                        leftActuator.set(-output);
                    }
                });
        this._rightSpeedController = new PIDController(Kp, Ki, Kd,
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
                        return rightSpeed;
                    }
                }, new PIDOutput() {
            @Override
            public void pidWrite(double output) {
                rightActuator.set(-output);
            }
        });

//        this._leftSpeedController.setContinuous(true); // Might need to replace this with an input range
//        this._rightSpeedController.setContinuous(true); // Might need to replace this with an input range
        this._leftSpeedController.setInputRange(-1, 1);
        this._rightSpeedController.setInputRange(-1, 1);

        this._leftSpeedController.setOutputRange(-1, 1);
        this._rightSpeedController.setOutputRange(-1, 1);

        this._leftSpeedController.setPercentTolerance(1); // Might need to replace this with absolute tolerance
        this._rightSpeedController.setPercentTolerance(1); // Might need to replace this with absolute tolerance

        this._leftSpeedController.setSetpoint(0);
        this._rightSpeedController.setSetpoint(0);

        this._elapsedTimer = new Timer();
        this._elapsedTimer.start();
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopArmCommand());
    }

    public void set(double speed) {
        if(speed > 0 && speed < deadzone)
            speed = 0;
        if(speed < 0 && speed > -deadzone)
            speed = 0;

        /*
        Left Actuator's "bottomed-out" switch is fwd
        Right Actuator's "bottomed-out" switch is rev

        Left Actuator's "topped-out" switch is rev
        Right Actuator's "topped-out" switch is fwd
         */
    	if(leftActuator.isRevLimitSwitchClosed() || rightActuator.isFwdLimitSwitchClosed()) {
    		speed = Math.min(0, speed);
    	}
    	if(leftActuator.isFwdLimitSwitchClosed() || rightActuator.isRevLimitSwitchClosed()) {
    		speed = Math.max(0, speed);
    	}

        //region REMOVE THIS SECTION ONCE MIN/MAX RATES HAVE BEEN DETERMINED!
//        speed *= scaleFactor;
//
//        leftActuator.set(speed);
//
//        if(speed > 0) {
//            rightActuator.set(speed);
//        }
//        if(speed < 0) {
//            rightActuator.set(speed * 1);
//        }
        //endregion
        //region UNCOMMENT THIS SECTION ONCE MIN/MAX RATES HAVE BEEN DETERMINED!
//        leftActuator.set(speed * ARM_MAX_SPEED);
//        rightActuator.set(speed * ARM_MAX_SPEED);
        setSpeed(speed * ARM_MAX_SPEED);
        //endregion

        SmartDashboard.putNumber("Left Potentiometer", leftPotentiometer.getAverageVoltage());
        SmartDashboard.putNumber("Right Potentiometer", rightPotentiometer.getAverageVoltage());
    }

    private void setSpeed(double rate) {
        if(this._leftSpeedController.getSetpoint() != rate) {
            this._leftSpeedController.reset();
            this._leftSpeedController.setSetpoint(rate);
        }
        if(this._rightSpeedController.getSetpoint() != rate) {
            this._rightSpeedController.reset();
            this._rightSpeedController.setSetpoint(rate);
        }
    }

    /**
     * Must be called every periodic!
     */
    public void update() {
        /*
            This is the equation for an approximated rate of change,
            nick-named "rise over run":
            Y2 - Y1
            -------
            X2 - X1

            We can change this formula a bit to use a change in time
            instead of "X":
            Y2 - Y1
            -------
              dT

            Let Y2 represent the current voltage of the potentiometer
            Let Y1 represent the previous voltage of the potentiometer

            This process is repeated for both the left and right potentiometers
            individually. The "velocity" of the potentiometer is measured in
            volts per second.
         */
        leftSpeed = (leftPotentiometer.getAverageVoltage() - prevLeftVal) / this._elapsedTimer.get();
        rightSpeed = (rightPotentiometer.getAverageVoltage() - prevRightVal) / this._elapsedTimer.get();

        prevLeftVal = leftPotentiometer.getAverageVoltage();
        prevRightVal = rightPotentiometer.getAverageVoltage();

        _elapsedTimer.reset();
        _elapsedTimer.start();

        // Update the PIDs
        this._leftSpeedController.enable();
        this._rightSpeedController.enable();

        // SMART DASHBOARD!
        SmartDashboard.putNumber("Left Speed", leftSpeed);
        SmartDashboard.putNumber("Right Speed", rightSpeed);
    }

    public double returnPIDInput() {
        return this.leftPotentiometer.getAverageVoltage();
    }

    public void usePIDOutput(double output) {
        this.set(-output);
    }

}
