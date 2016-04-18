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
        SmartDashboard.putNumber("Lidar Distance Forward", RobotMap.lidarSensor.getData(352).getDistance());

        SmartDashboard.putNumber("Distance Traveled (m)", Robot.chassis.getDistanceTraveled());

        SmartDashboard.putNumber("Encoder Distance(L)", Robot.chassis.getLeftEncoderDistance());
        SmartDashboard.putNumber("Encoder Distance (R)", Robot.chassis.getRightEncoderDistance());

        SmartDashboard.putNumber("Encoder Pos (L)", Robot.chassis.getLeftEncoderPos());
        SmartDashboard.putNumber("Encoder Pos (R)", Robot.chassis.getRightEncoderPos());

        SmartDashboard.putNumber("Encoder Speed (L)", Robot.chassis.getLeftEncoderVel());
        SmartDashboard.putNumber("Encoder Speed (R)", Robot.chassis.getRightEncoderVel());

        SmartDashboard.putNumber("Left Potentiometer", RobotMap.leftPotentiometer.getAverageVoltage());
        SmartDashboard.putNumber("Right Potentiometer", RobotMap.rightPotentiometer.getAverageVoltage());
        SmartDashboard.putNumber("Arm Position", Robot.arm.getPosition());

        SmartDashboard.putNumber("Left Potentiometer Speed", Robot.arm.getLeftSpeed());
        SmartDashboard.putNumber("Right Potentiometer Speed", Robot.arm.getRightSpeed());

        SmartDashboard.putNumber("Gyro Angle", Robot.chassis.getGyroAngle());
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
