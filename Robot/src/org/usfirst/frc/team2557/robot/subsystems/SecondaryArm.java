package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SecondaryArm extends Subsystem {
    
	Servo secondArmServo = RobotMap.secondaryArm;

    @Override
    protected void initDefaultCommand() {

    }

    public void latch() {
        secondArmServo.set(0);
    }

    public void release() {
        secondArmServo.set(90);
    }
}

