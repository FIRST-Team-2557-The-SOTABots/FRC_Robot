
package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2557.robot.commands.*;
import org.usfirst.frc.team2557.robot.commands.autonomous.Auto_DoNothing;
import org.usfirst.frc.team2557.robot.subsystems.*;

import java.io.IOException;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//Subsystem Declarations//
    public static OI oi;
    public static DriveSub driveSub;
    public static ManipulatorSub manipulatorSub;
    public static CameraSub cameraSub;

    //Command Declarations//
    Command autonomousCommand;
    Command catapultCommand;
    Command climbTower;
    Command driveCommand;
    Command intakeCommand;
    Command secondArmRelease;

    SendableChooser autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Initialize RobotMap
        RobotMap.init();

        // Run GRIP
        try {
            new ProcessBuilder("/home/lvuser/start_grip").inheritIO().start();
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        //Subsystem Connections//
        driveSub = new DriveSub();
        manipulatorSub = new ManipulatorSub();
        cameraSub = new CameraSub();

        //Command Connections//
        catapultCommand = new CatapultCommand();
        climbTower = new ClimbTower();
        driveCommand = new DriveCommand();
        intakeCommand = new IntakeCommand();
        secondArmRelease = new SecondArmRelease();
        
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
        autonomousCommand.cancel();

        // Start the drive command
        catapultCommand.start();
        climbTower.start();
        driveCommand.start();
        intakeCommand.start();
        secondArmRelease.start();
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
