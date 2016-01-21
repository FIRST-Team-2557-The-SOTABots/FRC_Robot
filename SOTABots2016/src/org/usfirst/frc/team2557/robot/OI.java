package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2557.robot.commands.ExampleCommand;
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
	
    public OI(){
    	
    	s1I = new JoystickButton(stick1, 0);
    	s1II = new JoystickButton(stick1, 1);
    	
    	
    	
    	s1I.toggleWhenPressed(new Solenoid1Toggle());
    	s1II.toggleWhenPressed(new Solenoid2Toggle());
    	
    	
    }
}

