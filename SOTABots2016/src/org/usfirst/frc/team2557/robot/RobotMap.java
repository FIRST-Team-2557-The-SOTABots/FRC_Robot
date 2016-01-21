package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//
	//added motors ¯\_(ツ)_/¯
	public static CANTalon motor1 = new CANTalon(0);
	public static CANTalon motor2 = new CANTalon(0);
	
	public static AnalogInput RangeFinder1 = new AnalogInput(0); //Added Two range finders
	public static AnalogInput RangeFinder2 = new AnalogInput(1); //More may e added if needed
	
	//added the Encoders on 1/21/16.D
	public static Counter LeftEnc;
	public static Counter RightEnc;
	
	public static DoubleSolenoid DSolenoid1 = new DoubleSolenoid(0, 0, 1); //Added two Double Solenoids
	public static DoubleSolenoid DSolenoid2 = new DoubleSolenoid(0, 2, 3); //Might Add another if needed
	
	//added the limit switches 1/21/16
	public static DigitalInput limitswitch = new DigitalInput(0);
	public static DigitalInput limitswitch2 = new DigitalInput(1);
	
	
	public static void init(){
		
		
		
		
		
	}
	
}
