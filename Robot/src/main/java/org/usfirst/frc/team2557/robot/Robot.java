
package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2557.robot.commands.arm.MoveArmToAngleCommand;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.autonomous.*;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.*;
import org.usfirst.frc.team2557.robot.commands.camera.CorrectDistanceToTargetCommand;
import org.usfirst.frc.team2557.robot.commands.camera.TurnToTargetCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.EncoderPosDriveCommand;
import org.usfirst.frc.team2557.robot.commands.chassis.TurnByAngleCommand;
import org.usfirst.frc.team2557.robot.subsystems.*;


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
    public static Dashboard dashboard;

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

        //Subsystem Connections//
        chassis = new Chassis();
        arm = new Arm();
        intake = new Intake();
        catapult = new Catapult();
        winch = new Winch();
        secondArm = new SecondArm();
        camera = new Camera();
        lidar = new Lidar();
        dashboard = new Dashboard();

        //OI Connection//
        // NOTE: oi MUST be constructed after subsystems
        oi 						= new OI();

        // Make a SendableChooser on the SmartDashboard for changing auto programs
        autoChooser 			= new SendableChooser();
        autoChooser.addDefault("Do Nothing (AUTO)", new Auto_DoNothing());
        autoChooser.addObject("*************", null);
        autoChooser.addObject("Drive To Defense (AUTO)", new Auto_DriveToDefense());
        autoChooser.addObject("*************", null);
        autoChooser.addObject("Lowbar (AUTO)", new Auto_Lowbar());
        autoChooser.addObject("Lowbar Left Batter (AUTO)", new Auto_LowbarLeft());
        autoChooser.addObject("Lowbar Center Batter (AUTO)", new Auto_LowbarCenter());
        autoChooser.addObject("*************", null);
        autoChooser.addObject("Chival De Frise (AUTO)", new Auto_ChivalDeFrise());
        autoChooser.addObject("Chival De Frise POS 1 LEFT (AUTO)", new Auto_ChivalDeFrise_Pos1Left());
        autoChooser.addObject("Chival De Frise POS 1 CENTER (AUTO)", new Auto_ChivalDeFrise_Pos1Center());
        autoChooser.addObject("Chival De Frise POS 2 LEFT (AUTO)", new Auto_ChivalDeFrise_Pos2Left());
        autoChooser.addObject("Chival De Frise POS 2 CENTER (AUTO)", new Auto_ChivalDeFrise_Pos2Center());
        autoChooser.addObject("Chival De Frise POS 3 CENTER (AUTO)", new Auto_ChivalDeFrise_Pos3Center());
        autoChooser.addObject("Chival De Frise POS 3 RIGHT (AUTO)", new Auto_ChivalDeFrise_Pos3Right());
        autoChooser.addObject("Chival De Frise POS 4 CENTER (AUTO)", new Auto_ChivalDeFrise_Pos4Center());
        autoChooser.addObject("Chival De Frise POS 4 RIGHT (AUTO)", new Auto_ChivalDeFrise_Pos4Right());
        autoChooser.addObject("*************", null);
        autoChooser.addObject("Portcullis (AUTO)", new Auto_Portcullis());
        autoChooser.addObject("Portcullis POS 1 LEFT (AUTO)", new Auto_Portcullis_Pos1Left());
        autoChooser.addObject("Portcullis POS 1 CENTER (AUTO)", new Auto_Portcullis_Pos1Center());
        autoChooser.addObject("Portcullis POS 2 LEFT (AUTO)", new Auto_Portcullis_Pos2Left());
        autoChooser.addObject("Portcullis POS 2 CENTER (AUTO)", new Auto_Portcullis_Pos2Center());
        autoChooser.addObject("Portcullis POS 3 CENTER (AUTO)", new Auto_Portcullis_Pos3Center());
        autoChooser.addObject("Portcullis POS 3 RIGHT (AUTO)", new Auto_Portcullis_Pos3Right());
        autoChooser.addObject("Portcullis POS 4 CENTER (AUTO)", new Auto_Portcullis_Pos4Center());
        autoChooser.addObject("Portcullis POS 4 RIGHT (AUTO)", new Auto_Portcullis_Pos4Right());
        autoChooser.addObject("*************", null);
        autoChooser.addObject("Rough Terrain (AUTO)", new Auto_RoughTerrain());
        autoChooser.addObject("Rough Terrain POS 1 LEFT (AUTO)", new Auto_RoughTerrain_Pos1Left());
        autoChooser.addObject("Rough Terrain POS 1 CENTER (AUTO)", new Auto_RoughTerrain_Pos1Center());
        autoChooser.addObject("Rough Terrain POS 2 LEFT (AUTO)", new Auto_RoughTerrain_Pos2Left());
        autoChooser.addObject("Rough Terrain POS 2 CENTER (AUTO)", new Auto_RoughTerrain_Pos2Center());
        autoChooser.addObject("Rough Terrain POS 3 CENTER (AUTO)", new Auto_RoughTerrain_Pos3Center());
        autoChooser.addObject("Rough Terrain POS 3 RIGHT (AUTO)", new Auto_RoughTerrain_Pos3Right());
        autoChooser.addObject("Rough Terrain POS 4 CENTER (AUTO)", new Auto_RoughTerrain_Pos4Center());
        autoChooser.addObject("Rough Terrain POS 4 RIGHT (AUTO)", new Auto_RoughTerrain_Pos4Right());
        autoChooser.addObject("*************", null);
        autoChooser.addObject("Ramparts (AUTO)", new Auto_Rampards());
        autoChooser.addObject("*************", null);
        autoChooser.addObject("Rock Wall (AUTO)", new Auto_RockWall());
        autoChooser.addObject("*************", null);
        autoChooser.addObject("Moat (AUTO)", new Auto_Moat());

        // Test commands
        autoChooser.addObject("------------", null);
        autoChooser.addObject("Auto Shoot Position 3 RIGHT (TEST)", new Auto_Pos3Right());
        autoChooser.addObject("Auto Shoot Position 4 RIGHT (TEST)", new Auto_Pos4Right());
        autoChooser.addObject("Auto Shoot Position 1 LEFT (TEST)", new Auto_Pos1Left());
        autoChooser.addObject("Auto Shoot Position 2 LEFT (TEST)", new Auto_Pos2Left());
        autoChooser.addObject("Auto Shoot Position 1 CENTER (TEST)", new Auto_Pos1Center());
        autoChooser.addObject("Auto Shoot Position 2 CENTER (TEST)", new Auto_Pos2Center());
        autoChooser.addObject("Auto Shoot Position 3 CENTER (TEST)", new Auto_Pos3Center());
        autoChooser.addObject("Auto Shoot Position 4 CENTER (TEST)", new Auto_Pos4Center());
        autoChooser.addObject("Drive Up Onto Batter (TEST)", new EncoderPosDriveCommand(4058, 0.5));
        autoChooser.addObject("Turn 90 degrees (TEST)", new TurnByAngleCommand(90));
        autoChooser.addObject("Turn 10 degrees (TEST)", new TurnByAngleCommand(10));
        autoChooser.addObject("Turn To Target (TEST)", new TurnToTargetCommand());
        autoChooser.addObject("Arm To Camera (TEST)", new MoveArmToAngleCommand(Arm.ARM_CAMERA));
        autoChooser.addObject("Auto Align & Shoot (TEST)", new Auto_CameraShootSequence());
        autoChooser.addObject("Load Ball (TEST)", new Auto_LoadBall());

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
        // Update the arm subsystem (updates PIDs and such)
        arm.update();

        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // Cancel the autonomous command (if there was one previously running
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
        // Update the arm
        Robot.arm.update();

        Scheduler.getInstance().run();
    }

    public void testInit() {

    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	SmartDashboard.putNumber("The lidar is reading; ", RobotMap.lidarSensor.getData(10).getDistance());

        LiveWindow.run();
    }
}
