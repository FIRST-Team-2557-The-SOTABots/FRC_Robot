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

    private CANTalon leftActuator = RobotMap.leftActuatorMotor;
    private CANTalon rightActuator = RobotMap.rightActuatorMotor;

    private AnalogInput leftPotentiometer = RobotMap.leftPotentiometer;
    private AnalogInput rightPotentiometer = RobotMap.rightPotentiometer;
    private double rightAdder = 0;

    private double scaleFactor = 0.5;

    public Arm() {
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopArmCommand());
    }

    public void set(double speed) {
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

        speed *= scaleFactor;

        leftActuator.set(speed);

        if(speed > 0) {
            rightActuator.set(speed);
        }
        if(speed < 0) {
            rightActuator.set(speed * 1);
        }

        SmartDashboard.putNumber("Left Potentiometer", leftPotentiometer.getAverageVoltage());
        SmartDashboard.putNumber("Right Potentiometer", rightPotentiometer.getAverageVoltage());
        SmartDashboard.putNumber("Potentiometer Difference", leftPotentiometer.getAverageVoltage() - (rightPotentiometer.getAverageVoltage() - 0.3));
    }

    public double returnPIDInput() {
        return this.leftPotentiometer.getAverageVoltage();
    }

    public void usePIDOutput(double output) {
        this.set(-output);
    }

}
