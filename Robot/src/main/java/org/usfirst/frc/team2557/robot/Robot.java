
package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.autonomous.*;
import org.usfirst.frc.team2557.robot.commands.camera.CorrectDistanceToTargetCommand;
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
    public static OI oi;
    public static Chassis chassis;
    public static Arm arm;
    public static Intake intake;
    public static Catapult catapult;
    public static Winch winch;
    public static SecondArm secondArm;
    public static Camera camera;
    public static Lidar lidar;

    //Command Declarations//
    Command autonomousCommand;

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
            new ProcessBuilder("/home/lvuser/grip").inheritIO().start();
        } catch(IOException e) {
            e.printStackTrace();
        }

        //Subsystem Connections//
        chassis = new Chassis();
        arm = new Arm();
        intake = new Intake();
        catapult = new Catapult();
        winch = new Winch();
        secondArm = new SecondArm();
        camera = new Camera();
        lidar = new Lidar();

        //OI Connection//
        // NOTE: oi MUST be constructed after subsystems
        oi 						= new OI();

        // Make a SendableChooser on the SmartDashboard for changing auto programs
        autoChooser 			= new SendableChooser();
        autoChooser.addDefault("Do Nothing (AUTO)", new Auto_DoNothing());
        autoChooser.addObject("Lowbar (AUTO)", new Auto_Lowbar());
        autoChooser.addObject("Chival De Frise (AUTO)", new Auto_ChivalDeFrise());
        autoChooser.addObject("Drive To Defense (AUTO)", new Auto_DriveToDefense());

        // Test commands
        autoChooser.addObject("Turn To Target (TEST)", new TurnToTargetCommand(0.2));
        autoChooser.addObject("Move To Target (TEST)", new CorrectDistanceToTargetCommand());
        autoChooser.addObject("Load Ball Configuration (TEST)", new MoveArmToAngleCommand(Arm.ARM_LOADBALL));

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
        // Update distance estimator
        RobotMap.distanceEstimator.update();

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
