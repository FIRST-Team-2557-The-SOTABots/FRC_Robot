package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;
import org.usfirst.frc.team2557.robot.commands.LEDUpdateCommand;

public class Camera extends Subsystem {

    ITable contoursTable = NetworkTable.getTable("GRIP/goalContoursReport");

    private final double fov = 68.5;
    private final double FOVp = 320;
    private final double Tft = 1.6667;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new LEDUpdateCommand());
    }

    public double getTargetPositionX() {
        final double Px = this.getClosestTargetValue("centerX");

        return (Px - (FOVp / 2)) / (FOVp / 2);
    }

    public double getTargetDistance() {
        final double Tp = this.getClosestTargetValue("width");
        return (Tft * FOVp) / (2 * Tp * Math.tan(Math.toRadians(fov / 2)));
    }

    public int getNumTargets() {
        double[] targets = contoursTable.getNumberArray("centerX", new double[0]);
        return targets.length;
    }

    private double getClosestTargetValue(String value) {
        int lowestIndex = 0;
        double[] xCandidates = contoursTable.getNumberArray("centerX", new double[1]);

        for(int i = 0; i < xCandidates.length; i++) {
            if(Math.abs(xCandidates[i]) < Math.abs(xCandidates[lowestIndex])) {
                lowestIndex = i;
                continue;
            }
        }

        return contoursTable.getNumberArray(value, new double[1])[lowestIndex];
    }

}
