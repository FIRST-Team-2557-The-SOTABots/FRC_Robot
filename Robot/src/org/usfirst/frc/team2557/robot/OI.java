package org.usfirst.frc.team2557.robot;

import org.usfirst.frc.team2557.robot.commands.IntakeInCommand;
import org.usfirst.frc.team2557.robot.commands.IntakeOutCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public Joystick driver;
	
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

	public Joystick manipulator;
	
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
	
	public OI(){
		
		driver = new Joystick(0);
		
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
    	
        manipulatorLB.whileHeld(new IntakeOutCommand());
        manipulatorRB.whileHeld(new IntakeInCommand());
				
	}
}

