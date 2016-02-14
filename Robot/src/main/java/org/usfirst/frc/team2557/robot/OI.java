package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	  //Liam: Added first joystick 1/21/16
	public Joystick driver = new Joystick(0);
	public Joystick manipulator = new Joystick(1);
	
	public JoystickButton driverA = new JoystickButton(driver, 1);
	public JoystickButton driverB = new JoystickButton(driver, 2);
	public JoystickButton driverX = new JoystickButton(driver, 3);
	public JoystickButton driverY = new JoystickButton(driver, 4);
	public JoystickButton driverLB = new JoystickButton(driver, 5);
	public JoystickButton driverRB = new JoystickButton(driver,6);
	public JoystickButton driverStart = new JoystickButton(driver, 7);
	public JoystickButton driverBack = new JoystickButton(driver, 8);
	public JoystickButton driverLJB = new JoystickButton(driver, 9);
	public JoystickButton driverRJB = new JoystickButton(driver, 10);
	
	
	public JoystickButton manipulatorA = new JoystickButton(manipulator, 1);
	public JoystickButton manipulatorB = new JoystickButton(manipulator, 2);
	public JoystickButton manipulatorX = new JoystickButton(manipulator, 3);
	public JoystickButton manipulatorY = new JoystickButton(manipulator, 4);
	public JoystickButton manipulatorLB = new JoystickButton(manipulator, 5);
	public JoystickButton manipulatorRB = new JoystickButton(manipulator, 6);
	public JoystickButton manipulatorStart = new JoystickButton(manipulator, 7);
	public JoystickButton manipulatorBack = new JoystickButton(manipulator, 8);
	public JoystickButton manipulatorLJB = new JoystickButton(manipulator, 9);
	public JoystickButton manipulatorRJB = new JoystickButton(manipulator, 10);
	
    public OI(){

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
     * LJB	=	=	=	=	=	=
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
     */
}

