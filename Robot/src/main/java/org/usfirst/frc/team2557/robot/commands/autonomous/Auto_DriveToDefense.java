package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.commands.chassis.DistanceDriveCommand;

public class Auto_DriveToDefense extends DistanceDriveCommand {

    private static double metersToDefense = 0.85; //TODO: Experiment with this value to reach the edge of a defense
    private static double speed = 0.5;

    public Auto_DriveToDefense() {
        super(metersToDefense, speed);
    }

}
