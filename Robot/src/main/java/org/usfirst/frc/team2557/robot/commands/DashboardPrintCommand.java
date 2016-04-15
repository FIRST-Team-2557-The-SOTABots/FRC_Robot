package org.usfirst.frc.team2557.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.subsystems.Dashboard;

public class DashboardPrintCommand extends Command {

    public DashboardPrintCommand() {
        requires(Robot.dashboard);

        // Can't be interrupted, nor does
        // it make sense TO interrupt it
        setInterruptible(false);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("Lidar distance forward", RobotMap.lidarSensor.getData(352).getDistance());

        SmartDashboard.putNumber("Distance traveled (m)", Robot.chassis.getDistanceTraveled());

        SmartDashboard.putNumber("Encoder (L)", Robot.chassis.getLeftEncoderVel());
        SmartDashboard.putNumber("Encoder (R)", Robot.chassis.getRightEncoderVel());

        SmartDashboard.putBoolean("Second Arm Release", RobotMap.leftPotentiometer.getVoltage() < 2.85);

        SmartDashboard.putBoolean("Left Actuator Hall Effect FWD", RobotMap.leftActuatorMotor.isFwdLimitSwitchClosed());
        SmartDashboard.putBoolean("Left Actuator Hall Effect REV", RobotMap.leftActuatorMotor.isRevLimitSwitchClosed());
        SmartDashboard.putBoolean("Right Actuator Hall Effect FWD", RobotMap.rightActuatorMotor.isFwdLimitSwitchClosed());
        SmartDashboard.putBoolean("Right Acutator Hall Effect REV", RobotMap.rightActuatorMotor.isRevLimitSwitchClosed());

        SmartDashboard.putNumber("Left Potentiometer", RobotMap.leftPotentiometer.getAverageVoltage());
        SmartDashboard.putNumber("Right Potentiometer", RobotMap.rightPotentiometer.getAverageVoltage());

        SmartDashboard.putNumber("Left Speed", Robot.arm.getLeftSpeed());
        SmartDashboard.putNumber("Right Speed", Robot.arm.getRightSpeed());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }

}
