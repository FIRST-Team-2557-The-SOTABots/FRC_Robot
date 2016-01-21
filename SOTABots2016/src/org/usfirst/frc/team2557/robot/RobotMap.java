package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	
	
	
	
	
	
	public static DoubleSolenoid DSolenoid1 = new DoubleSolenoid(0, 0, 1);
	public static DoubleSolenoid DSolenoid2 = new DoubleSolenoid(0, 2, 3);
	
	
}
