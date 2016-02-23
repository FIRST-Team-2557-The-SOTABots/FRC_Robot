package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;
import org.usfirst.frc.team2557.accessories.ArduinoComm;
import org.usfirst.frc.team2557.robot.RobotMap;

public class CameraSub extends Subsystem {

    private static ITable gripTable = NetworkTable.getTable("GRIP");

    public CameraSub() {
        super();
    }

    @Override
    protected void initDefaultCommand() {

    }

    public double getTargetPositionX() {
        final double Px = this.getClosestTargetValue("centerX");

        return (Px - (FOVp / 2)) / (FOVp / 2);
    }

    private final double fov = 68.5;
    private final double FOVp = 320;
    private final double Tft = 1.6667;
    public double getTargetDistance() {
        final double Tp = this.getClosestTargetValue("width");
        return (Tft * FOVp) / (2 * Tp * Math.tan(Math.toRadians(fov / 2)));
    }

    public void update() {
        if(this.getNumTargets() > 0) {
            RobotMap.arduinoComm.changeMode(ArduinoComm.LightsMode.PulsatingYellow);
        }else{
            // TODO: Change this to aliance color
            RobotMap.arduinoComm.changeMode(ArduinoComm.LightsMode.Yellow);
        }
    }

    public int getNumTargets() {
        double[] targets = gripTable.getSubTable("goalContoursReport").getNumberArray("centerX", new double[0]);
        return targets.length;
    }

    private double getClosestTargetValue(String value) {
        int lowestIndex = 0;
        double[] xCandidates = gripTable.getSubTable("goalContoursReport").getNumberArray("centerX", new double[1]);

        for(int i = 0; i < xCandidates.length; i++) {
            if(Math.abs(xCandidates[i]) < Math.abs(xCandidates[lowestIndex])) {
                lowestIndex = i;
                continue;
            }
        }

        return gripTable.getSubTable("goalContoursReport").getNumberArray(value, new double[1])[lowestIndex];
    }

}
