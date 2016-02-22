package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

public class Auto_ArmPosition extends Command {

    private static double tolerance = 1;

    private double _position;

    public Auto_ArmPosition(double position) {
        this._position = position;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if(RobotMap.leftActuatorMotor.getEncPosition()/900 < 0){
            Robot.manipulatorSub.setActuators(-.5);
        }	else if(RobotMap.leftActuatorMotor.getEncPosition()/900 > 0){
            Robot.manipulatorSub.setActuators(.5);
        }
    }

    @Override
    protected boolean isFinished() {
        // TODO: Adjust tolerance
        return Math.abs(RobotMap.leftActuatorMotor.getEncPosition() / 900) - 35 <= tolerance;
    }

    @Override
    protected void end() {
        Robot.manipulatorSub.setActuators(0);
    }

    @Override
    protected void interrupted() {
        this.end();
    }
}
