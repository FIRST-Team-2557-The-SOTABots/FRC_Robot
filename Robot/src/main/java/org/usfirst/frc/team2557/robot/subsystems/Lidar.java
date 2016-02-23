package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.LidarUpdateCommand;
import org.usfirst.frc.team2557.sensors.LidarRangeFinder;

public class Lidar extends Subsystem {

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new LidarUpdateCommand());
    }

    public LidarRangeFinder.LidarData getDat(int angle) {
        return RobotMap.lidarSensor.getData(angle);
    }

    public float getCurrentRPM() {
        return RobotMap.lidarSensor.getCurrentRPM();
    }

    public void updateNetworkTables() {
        RobotMap.lidarSensor.updateNetworkTables();
    }

}
