package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2557.robot.commands.Solenoid1Toggle;
import org.usfirst.frc.team2557.robot.commands.Solenoid2Toggle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	  //Liam: Added first joystick 1/21/16
	public Joystick stick1 = new Joystick(0);
	
	public JoystickButton s1I;
	public JoystickButton s1II;
	public JoystickButton s1III;
	public JoystickButton s1IV;
	public JoystickButton s1V;
	public JoystickButton s1VI;
	public JoystickButton s1VII;
	public JoystickButton s1VIII;
	public JoystickButton s1IX;
	
	
	
	
    public OI(){
    	
    	s1I = new JoystickButton(stick1, 1);
    	s1II = new JoystickButton(stick1, 2);
    	s1III = new JoystickButton(stick1, 3);
    	s1IV = new JoystickButton(stick1, 4);
    	s1V = new JoystickButton(stick1, 5);
    	s1VI = new JoystickButton(stick1, 6);
    	s1VII = new JoystickButton(stick1, 7);
    	s1VIII = new JoystickButton(stick1, 8);
    	s1IX = new JoystickButton(stick1, 9);
    	
    	
    	
    	
    	
    	s1I.toggleWhenPressed(new Solenoid1Toggle());
    	s1II.toggleWhenPressed(new Solenoid2Toggle());
    	
    	
    }
}

