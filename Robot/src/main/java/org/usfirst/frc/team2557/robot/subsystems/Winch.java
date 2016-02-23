package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.winch.WinchCommand;

public class Winch extends Subsystem {

    CANTalon climbingMotor = RobotMap.climbingMotor;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new WinchCommand());
    }

    public void set(double speed) {
        climbingMotor.set(speed);
    }

}
