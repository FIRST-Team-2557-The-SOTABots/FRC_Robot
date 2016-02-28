package org.usfirst.frc.team2557.robot.commands.camera;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2557.accessories.ArduinoComm;
import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.subsystems.Camera;

public class LEDUpdateCommand extends Command {

    public LEDUpdateCommand() {
        // Does not require the camera subsystem,
        // this command can safely run with other
        // commands using the camera at the same
        // time.
        setInterruptible(false);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Camera.Target[] targets = Robot.camera.getTargets();
        for(Camera.Target target : targets) {
            SmartDashboard.putNumber("Distance", target.distance);
        }
//        if(Robot.camera.getNumTargets() > 0) {
//            RobotMap.arduinoComm.changeMode(ArduinoComm.LightsMode.PulsatingYellow);
//        }else{
//            // TODO: Change this to aliance color
//            RobotMap.arduinoComm.changeMode(ArduinoComm.LightsMode.Yellow);
//        }
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
