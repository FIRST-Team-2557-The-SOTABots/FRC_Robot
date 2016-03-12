package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.secondArm.SecondArmLatchCommand;

public class SecondArm extends Subsystem {

    Servo secondArmServo = RobotMap.secondaryArm;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new SecondArmLatchCommand());
    }

    public void latch() {
        secondArmServo.set(0);
    }

    public void release() {
        secondArmServo.set(90);
    }

}
