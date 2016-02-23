package org.usfirst.frc.team2557.robot.commands.autonomous;

import org.usfirst.frc.team2557.robot.RobotMap;

public class Auto_DriveToDefense extends Auto_DistanceDrive {

    private static double metersToDefense = 1.5; //TODO: Experiment with this value to reach the edge of a defense
    private static double speed = 0.5;

    public Auto_DriveToDefense() {
        super(metersToDefense, speed);
    }

}
