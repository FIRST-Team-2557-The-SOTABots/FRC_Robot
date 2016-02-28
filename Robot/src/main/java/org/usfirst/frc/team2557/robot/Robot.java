
package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2557.robot.commands.*;
import org.usfirst.frc.team2557.robot.commands.autonomous.Auto_DoNothing;
import org.usfirst.frc.team2557.robot.commands.autonomous.groups.Auto_Lowbar_Group;
import org.usfirst.frc.team2557.robot.commands.camera.TurnToTargetCommand;
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
    public static OI 				oi;
    public static Chassis chassis;
    public static Intake intake;
    public static Catapult catapult;
    public static Winch winch;
    public static SecondArm secondArm;
    public static ManipulatorSub 	manipulatorSub;
    public static Camera camera;
    public static Lidar lidar;
    public static SmartDashboardSub smartDashboardSub;

    //Command Declarations//
    Command armConfigurationCommand;
    Command autonomousCommand;
    Command smartDashboardCommand;

    SendableChooser autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Initialize RobotMap
        RobotMap.init();

        // Start GRIP
        try {
            new ProcessBuilder("/home/lvuser/start_grip").inheritIO().start();
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        //Subsystem Connections//
        chassis = new Chassis();
        intake = new Intake();
        catapult = new Catapult();
        winch = new Winch();
        secondArm = new SecondArm();
        manipulatorSub 			= new ManipulatorSub();
        camera = new Camera();
        lidar = new Lidar();
        smartDashboardSub 		= new SmartDashboardSub();

        //OI Connection//
        // NOTE: oi MUST be constructed after subsystems
        oi 						= new OI();

        //Command Connections//
        armConfigurationCommand = new ArmConfigurationCommand();
        smartDashboardCommand 	= new SmartDashboardCommand();

        // Make a SendableChooser on the SmartDashboard for changing auto programs
        autoChooser 			= new SendableChooser();
        autoChooser.addDefault("Do Nothing", new Auto_DoNothing());
        autoChooser.addObject("Lowbar", new Auto_Lowbar_Group());
        autoChooser.addObject("Turn To Target", new TurnToTargetCommand(0.2));
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
        // Update distance estimator
        RobotMap.distanceEstimator.update();

        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if(autonomousCommand != null)
            autonomousCommand.cancel();


        // Start teleop commands
        armConfigurationCommand.start();
        smartDashboardCommand.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit() {

    }

    /*

     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
    }

    public void testInit() {

    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
