package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team2557.robot.commands.automation.Auto_LoadBall;
import org.usfirst.frc.team2557.robot.commands.autonomous.sequences.Auto_CameraShootSequence;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeInCommand;
import org.usfirst.frc.team2557.robot.commands.intake.IntakeOutCommand;
import org.usfirst.frc.team2557.robot.commands.secondArm.SecondArmReleaseCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
//	public Joystick driver; //Gamepad
//
//	public JoystickButton driverA;
//	public JoystickButton driverB;
//	public JoystickButton driverX;
//	public JoystickButton driverY;
//	public JoystickButton driverLB;
//	public JoystickButton driverRB;
//	public JoystickButton driverBack;
//	public JoystickButton driverStart;
//	public JoystickButton driverLJB;
//	public JoystickButton driverRJB;
//
	public Joystick manipulator; //Gamepad

	public JoystickButton manipulatorA;
	public JoystickButton manipulatorB;
	public JoystickButton manipulatorX;
	public JoystickButton manipulatorY;
	public JoystickButton manipulatorLB;
	public JoystickButton manipulatorRB;
	public JoystickButton manipulatorBack;
	public JoystickButton manipulatorStart;
	public JoystickButton manipulatorLJB;
	public JoystickButton manipulatorRJB;
	
	public Joystick driver; //Gamepad

	public JoystickButton button1;
	public JoystickButton button2;
	public JoystickButton button3;
	public JoystickButton button4;
	public JoystickButton button5;
	public JoystickButton button6;
	public JoystickButton button7;
	public JoystickButton button8;
	public JoystickButton button9;
	public JoystickButton button10;
	public JoystickButton button11;
	public JoystickButton button12;

    public OI(){
//        driver = new Joystick(0);
//
//        driverA = new JoystickButton(driver, 1);
//        driverB = new JoystickButton(driver, 2);
//        driverX = new JoystickButton(driver, 3);
//        driverY = new JoystickButton(driver, 4);
//        driverLB = new JoystickButton(driver, 5);
//        driverRB = new JoystickButton(driver, 6);
//        driverBack = new JoystickButton(driver, 7);
//        driverStart = new JoystickButton(driver, 8);
//        driverLJB = new JoystickButton(driver, 9);
//        driverRJB = new JoystickButton(driver, 10);

    	
    	driver 		= new Joystick(0);

    	button1	 	= new JoystickButton(driver, 1);
    	button2 	= new JoystickButton(driver, 2);
    	button3 	= new JoystickButton(driver, 3);
    	button4 	= new JoystickButton(driver, 4);
    	button5		= new JoystickButton(driver, 5);
    	button6		= new JoystickButton(driver, 6);
    	button7 	= new JoystickButton(driver, 7);
    	button8 	= new JoystickButton(driver, 8);
    	button9 	= new JoystickButton(driver, 9);
    	button10 	= new JoystickButton(driver, 10);
    	button11 	= new JoystickButton(driver, 11);
    	button12 	= new JoystickButton(driver, 12);
    	
        manipulator = new Joystick(1);

        manipulatorA 		= new JoystickButton(manipulator, 1);
        manipulatorB 		= new JoystickButton(manipulator, 2);
        manipulatorX 		= new JoystickButton(manipulator, 3);
        manipulatorY 		= new JoystickButton(manipulator, 4);
        manipulatorLB 		= new JoystickButton(manipulator, 5);
        manipulatorRB 		= new JoystickButton(manipulator, 6);
        manipulatorBack 	= new JoystickButton(manipulator, 7);
        manipulatorStart 	= new JoystickButton(manipulator, 8);
        manipulatorLJB 		= new JoystickButton(manipulator, 9);
        manipulatorRJB 		= new JoystickButton(manipulator, 10);

        // Set commands to buttons
        //driverStart.whileActive(new SecondArmReleaseCommand());
		button3.whileHeld(new SecondArmReleaseCommand());

        manipulatorLB.whileHeld(new IntakeOutCommand());
        manipulatorRB.whileHeld(new IntakeInCommand());

		manipulatorX.whenPressed(new Auto_LoadBall());
		button2.toggleWhenPressed(new SecondArmReleaseCommand());
		manipulatorY.whileHeld(new Auto_CameraShootSequence());
    }
    /*
     * This commented section will be a place where anyone can easily see what buttons do what and what axis do what
     * 
     *===Driver Controller===
     *
     * Left Joystick Y-Axis	=	=	Left side of the drive train
     * Left Joystick X-Axis	=	=
     * Right Joystick Y-Axis	=	Right side of the drive train
     * Right Joystick X-Axis	= 
     * Left Trigger Axis	=	= 	Winch (tied into Right Trigger)
     * Right Trigger Axis	=	=	Winch (tied into Left Trigger)
     * A	=	=	=	=	=	= 
     * B	=	=	=	=	=	= 
     * X	=	=	=	=	=	= 
     * Y	=	=	=	=	=	= 
     * LB	=	=	=	=	=	= 
     * RB	=	=	=	=	=	= 
     * BACK	=	=	=	=	=	=	Secondary Arm Servo Actuation (tied into START)
     * START	=	=	=	=	= 	Secondary Arm Servo Actuation (tied into BACK)
     * LJB	=	=	=	=	=	= 
     * RJB	=	=	=	=	=	= 
     * POV-1	=	=	=	=	= 
     * POV1	=	=	=	=	=	= 
     * POV2	=	=	=	=	=	= 
     * POV3	=	=	=	=	=	= 
     * POV4	=	=	=	=	=	= 
     * POV5	=	=	=	=	=	= 
     * POV6	=	=	=	=	=	= 
     * POV7	=	=	=	=	=	= 
     * POV8	=	=	=	=	=	=
     *
     *
     *			For Joystick, not Gamepad
     * X-Axis	=	=	=	=	=	Rotation Drive
     * Y-Axis	=	=	=	=	=	Forward/Reverse Drive
     * z-Axis	=	=	=	=	=
     * Slider	=	=	=	=	=	Speed Adjustment
     * Button1 (Trigger)	=	=
     * Button2 (Thumb Button)	=
     * Button3	=	=	=	=	=
     * Button4	=	=	=	=	=
     * Button5	=	=	=	=	=
     * Button6	=	=	=	=	=
     * Button7	=	=	=	=	=
     * Button8	=	=	=	=	=
     * Button9	=	=	=	=	=
     * Button10	=	=	=	=	=
     * Button11	=	=	=	=	=	
     * Button12=	=	=	=	=
     *
     *
     *
     *
     *===Manipulator Controller===
     *
     * Left Joystick Y-Axis	=	=
     * Left Joystick X-Axis	=	=
     * Right Joystick Y-Axis	=
     * Right Joystick X-Axis	=
     * Left Trigger Axis	=	=
     * Right Trigger Axis	=	=	Setting the catapult
     * A	=	=	=	=	=	=
     * B	=	=	=	=	=	=
     * X	=	=	=	=	=	=
     * Y	=	=	=	=	=	=
     * LB	=	=	=	=	=	=	Spitting out the ball (outtake)
     * RB	=	=	=	=	=	=	Intaking the ball
     * BACK	=	=	=	=	=	=	Intake Arm Configuration 5; Climbing
     * START	=	=	=	=	=	Allows for the catapult to shoot
     * LJB	=	=	=	=	=	=	Reset Encoders
     * RJB	=	=	=	=	=	=	
     * POV-1	=	=	=	=	=
     * POV0	=	=	=	=	=	=	Intake Arm Configuration 1; Intake
     * POV1	=	=	=	=	=	=
     * POV2	=	=	=	=	=	=	Intake Arm Configuration 2; Load
     * POV3	=	=	=	=	=	=
     * POV4	=	=	=	=	=	=	Intake Arm Configuration 3; Portcullis
     * POV5	=	=	=	=	=	=
     * POV6	=	=	=	=	=	=	Intake Arm Configuration 4; Lowbar
     * POV7	=	=	=	=	=	=
     * 
     *
     *
     *
     *			For Joystick, not Gamepad
     * X-Axis	=	=	=	=	=
     * Y-Axis	=	=	=	=	=
     * z-Axis	=	=	=	=	=
     * Slider	=	=	=	=	=
     * Button1 (Trigger)	=	=
     * Button2 (Thumb Button)	=
     * Button3	=	=	=	=	=
     * Button4	=	=	=	=	=
     * Button5	=	=	=	=	=
     * Button6	=	=	=	=	=
     * Button7	=	=	=	=	=
     * Button8	=	=	=	=	=
     * Button9	=	=	=	=	=
     * Button10	=	=	=	=	=
     * Button11	=	=	=	=	=	
     * Button12=	=	=	=	=
     *
     * 
     * 
     * 
     * 
     *
     */
     
}

