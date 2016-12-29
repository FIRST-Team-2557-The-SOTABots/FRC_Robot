package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.catapult.CatapultSequence;

public class Catapult extends Subsystem {

    CANTalon motor = RobotMap.catapultMotor;
    DigitalInput hallEffect = RobotMap.catapultHallEffect;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new CatapultSequence());
    }

    public void setCatapultMotor(double speed) {
        // Catapult motor is reversed
        this.motor.set(-speed);
    }

    public boolean isCatapultDown() {
        return !this.hallEffect.get();
    }

}
