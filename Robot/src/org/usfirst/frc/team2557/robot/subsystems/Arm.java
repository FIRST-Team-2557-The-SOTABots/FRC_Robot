package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.TeleopArmCommand;
import org.usfirst.frc.team2557.robot.subsystems.Arm;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends Subsystem {
    
	private CANTalon leftActuator = RobotMap.leftActuatorMotor;
    private CANTalon rightActuator = RobotMap.rightActuatorMotor;

    private AnalogInput leftPotentiometer = RobotMap.leftPotentiometer;
    private AnalogInput rightPotentiometer = RobotMap.rightPotentiometer;
    private double rightAdder = 0;

    private double scaleFactor = 0.5;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopArmCommand());
    }

    public void set(double speed) {
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

    public double getPotentiometerValue() {
        return this.leftPotentiometer.getValue();
    }

    public PIDSource getPIDSource() {
        return this.leftPotentiometer;
    }

    public static class ArmOutput implements PIDOutput {

        private Arm arm;

        public ArmOutput() {
            arm = Robot.arm;
        }

        @Override
        public void pidWrite(double output) {
            arm.set(-output);
        }

    }
}

