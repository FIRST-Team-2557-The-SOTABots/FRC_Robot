package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.IntakeStopCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
    
	CANTalon intakeMotor = RobotMap.intakeMotor;

    @Override
    protected void initDefaultCommand() {
        // Stops the intake when there are no other commands
        // using the subsystem
        setDefaultCommand(new IntakeStopCommand());
    }

    public void set(double speed) {
        intakeMotor.set(speed);
    }
}

