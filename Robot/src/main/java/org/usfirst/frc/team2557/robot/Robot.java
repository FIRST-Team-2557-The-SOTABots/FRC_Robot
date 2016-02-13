
package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2557.robot.commands.DriveCommand;
import org.usfirst.frc.team2557.robot.commands.Solenoid1Toggle;
import org.usfirst.frc.team2557.robot.commands.Solenoid2Toggle;
import org.usfirst.frc.team2557.robot.commands.autonomous.Auto_DoNothing;
import org.usfirst.frc.team2557.robot.subsystems.DriveSub;
import org.usfirst.frc.team2557.robot.subsystems.Solenoid_System;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    public static final DriveSub driveSub = new DriveSub();
    public static Solenoid_System SolSystem;


    public static OI oi;

    Command autonomousCommand;
    Command driveCommand;
    Command Sol1T;
    Command Sol2T;

    SendableChooser autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Initialize RobotMap
        RobotMap.init();

        SolSystem = new Solenoid_System();

        driveCommand = new DriveCommand();
        Sol1T = new Solenoid1Toggle();
        Sol2T = new Solenoid2Toggle();

        oi = new OI();

        // Make a SendableChooser on the SmartDashboard for changing auto programs
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Do Nothing", new Auto_DoNothing());
        SmartDashboard.putData("Autonomous Chooser", autoChooser);
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        autonomousCommand = (Command) autoChooser.getSelected();
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();

        // Update Lidar NetworkTables
        RobotMap.LidarSensor.updateNetworkTables();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();

        // Start the drive command
        driveCommand.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

        // Update Lidar NetworkTables
        RobotMap.LidarSensor.updateNetworkTables();
    }

    public void testInit() {

    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();

        // Update Lidar NetworkTables
        RobotMap.LidarSensor.updateNetworkTables();
    }
}
