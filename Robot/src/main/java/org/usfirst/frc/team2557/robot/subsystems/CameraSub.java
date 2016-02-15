package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;

public class CameraSub extends Subsystem {

    private static ITable gripTable = NetworkTable.getTable("GRIP");

    public CameraSub() {
        super();
    }

    @Override
    protected void initDefaultCommand() {

    }

    public double getTargetPositionX() {
        final double Px = gripTable.getSubTable("goalContoursReport").getNumber("centerX", 0);

        return (Px - (FOVp / 2)) / (FOVp / 2);
    }

    private final double fov = 68.5;
    private final double FOVp = 320;
    private final double Tft = 1.6667;
    public double getTargetDistance() {
        final double Tp = gripTable.getSubTable("goalContoursReport").getNumber("width", 0);
        return (Tft * FOVp) / (2 * Tp * Math.tan(Math.toRadians(fov / 2)));
    }

}
