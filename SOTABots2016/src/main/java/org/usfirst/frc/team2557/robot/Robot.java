
package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team2557.robot.commands.DriveCommand;
import org.usfirst.frc.team2557.robot.commands.Solenoid1Toggle;
import org.usfirst.frc.team2557.robot.commands.Solenoid2Toggle;
import org.usfirst.frc.team2557.robot.subsystems.Autonomous;
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
    public static final Autonomous autonomous = new Autonomous();
    public static Solenoid_System SolSystem;


    public static OI oi;


    Command autonomousCommand;
    Command driveCommand;
    Command Sol1T;
    Command Sol2T;
    Command Lowbar_Auto;
    Command Moat_Auto;
    Command Rampart_Auto;
    Command RockWall_Auto;
    Command RoughTerrain_Auto;


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
        // instantiate the command used for the autonomous period

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //talked to Antonio about how to make a switch-able autonomous
        //so that the drive team can set it up on the field
        //Made adjustments to this code on 1/22/16
        if (autonomousCommand != null) autonomousCommand.start();
        if (Lowbar_Auto != null) Lowbar_Auto.start();
        if (Moat_Auto != null) Moat_Auto.start();
        if (Rampart_Auto != null) Rampart_Auto.start();
        if (RockWall_Auto != null) RockWall_Auto.start();
        if (RoughTerrain_Auto != null) RoughTerrain_Auto.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
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
        driveCommand.start();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
