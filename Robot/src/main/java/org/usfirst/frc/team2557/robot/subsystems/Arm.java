package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.arm.TeleopArmCommand;

public class Arm extends Subsystem {

    private CANTalon leftActuator = RobotMap.leftActuatorMotor;
    private CANTalon rightActuator = RobotMap.rightActuatorMotor;

    private AnalogInput leftPotentiometer = RobotMap.leftPotentiometer;
    private AnalogInput rightPotentiometer = RobotMap.rightPotentiometer;

    private double scaleFactor = 0.5;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopArmCommand());
    }

    private double rightAdder = 0;
    public void set(double speed) {
        if(RobotMap.leftActuatorMotor.isFwdLimitSwitchClosed()) {
            speed = Math.min(0, speed);
        }else if(leftActuator.isRevLimitSwitchClosed()) {
            speed = Math.max(0, speed);
        }

        leftActuator.set(speed * scaleFactor);
//        rightActuator.set(speed * scaleFactor);

        if(RobotMap.leftPotentiometer.getVoltage() > RobotMap.rightPotentiometer.getVoltage()) {
            rightAdder += -0.05;
        }
        if (speed == 0) {
            rightAdder = 0;
        }
        rightActuator.set(speed + rightAdder);
    }

}
