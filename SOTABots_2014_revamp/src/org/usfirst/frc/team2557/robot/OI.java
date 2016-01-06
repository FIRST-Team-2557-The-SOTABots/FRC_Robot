package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;

import org.usfirst.frc.team2557.robot.commands.ExampleCommand;

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
	public Joystick joystick1;
	public Joystick joystick2;
	
	//Driver Joystick Buttons
	
	public	JoystickButton LJ1;
	public	JoystickButton LJ2;
	public	JoystickButton LJ3;
	public	JoystickButton LJ4;
	public	JoystickButton LJ5;
	public	JoystickButton LJ6;
	public	JoystickButton LJ7;
	public	JoystickButton LJ8;
	public	JoystickButton LJ9;
	public	JoystickButton LJ10;
	public	JoystickButton LJ11;
	public	JoystickButton LJ12;
			
			//Manipulator Joystick Buttons
			
	public JoystickButton RJ1;
	public JoystickButton RJ2;
	public JoystickButton RJ3;
	public JoystickButton RJ4;
	public JoystickButton RJ5;
	public JoystickButton RJ6;
	public JoystickButton RJ7;
	public JoystickButton RJ8;
	public JoystickButton RJ9;
	public JoystickButton RJ10;
	public JoystickButton RJ11;
	public JoystickButton RJ12;

	
	
	public OI(){
		
		joystick1 = new Joystick(0);
		joystick2 = new Joystick(1);
		
		LJ1 = new JoystickButton(joystick1, 0);
		LJ2 = new JoystickButton(joystick1, 1);
		LJ3 = new JoystickButton(joystick1, 2);
		LJ4 = new JoystickButton(joystick1, 3);
		LJ5 = new JoystickButton(joystick1, 4);
		LJ6 = new JoystickButton(joystick1, 5);
		LJ7 = new JoystickButton(joystick1, 6);
		LJ8 = new JoystickButton(joystick1, 7);
		LJ9 = new JoystickButton(joystick1, 8);
		LJ10 = new JoystickButton(joystick1,9);
		LJ11 = new JoystickButton(joystick1, 10);
		LJ12 = new JoystickButton(joystick1, 11);
		
		RJ1 = new JoystickButton(joystick2, 0);
		RJ2 = new JoystickButton(joystick2, 1);
		RJ3 = new JoystickButton(joystick2, 2);
		RJ4 = new JoystickButton(joystick2, 3);
		RJ5 = new JoystickButton(joystick2, 4);
		RJ6 = new JoystickButton(joystick2, 5);
		RJ7 = new JoystickButton(joystick2, 6);
		RJ8 = new JoystickButton(joystick2, 7);
		RJ9 = new JoystickButton(joystick2, 8);
		RJ10 = new JoystickButton(joystick2,9);
		RJ11 = new JoystickButton(joystick2, 10);
		RJ12 = new JoystickButton(joystick2, 11);
		
		
		
		
	}
	
	public Joystick joystick1(){
		return joystick1;
	}
	public Joystick joystick2(){
		return joystick2;
	}
	
	
	
	
	
}

