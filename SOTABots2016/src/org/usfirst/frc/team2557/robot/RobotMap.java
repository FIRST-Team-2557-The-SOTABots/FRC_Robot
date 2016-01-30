package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//
	//added motors ¯\_(ツ)_/¯
	//Liam: fixed port errors made by sam, renamed motors to motorLeft and motorRight from motor1 and motor2, respectively. 1/21/16
	public static CANTalon motorLeft = new CANTalon(0);
	public static CANTalon motorRight = new CANTalon(1);
	
	//Liam: added robotdrive 1/21/16	//Moved the robot drive and its comment to be below the motors -H 1/22/16
	public static RobotDrive arcadeDrive = new RobotDrive(motorLeft, motorRight);
	
	//moved the solenoids from below the counter/encoders to above the analog inputs -H 1/22
	public static DoubleSolenoid DSolenoid1 = new DoubleSolenoid(0, 0, 1); //Added two Double Solenoids 
	public static DoubleSolenoid DSolenoid2 = new DoubleSolenoid(0, 2, 3); //Might Add another if needed
	
	public static AnalogInput RangeFinderF = new AnalogInput(0); //Added Two range finders
	public static AnalogInput RangeFinderL = new AnalogInput(1); //More may be added if needed
	public static AnalogInput RangeFinderR = new AnalogInput(2); //Added two more range finders also renamed the existing ones
	public static AnalogInput RangeFinderB = new AnalogInput(3); //and change where they were refernce to mathc
	public static AnalogInput LidarSensor  = new AnalogInput(4); //This is for the lidar sensor
	
	
	
	//added the limit switches 1/21/16
	public static DigitalInput limitswitch = new DigitalInput(0);
	public static DigitalInput limitswitch2 = new DigitalInput(1);
	
	//added this DI 1/22/16
	public static DigitalInput LimitLimitSwitch = new DigitalInput(2);
	
	//added the Encoders on 1/21/16.D  //Moved this little section to be below the inputs -H 1/22
	public static Counter LeftEnc;
	public static Counter RightEnc;
	
	public static double RFF; //A declared double in the robot map that is for the front range finder 1/22
	public static double RFL; //A declared double in the robot map that is for the left range finder 1/22
	public static double RFR; //A declared double in the robot map that is for the right range finder
	public static double RFB; //A declared double in the robot map that is for the back range finder
	public static double LS;  //
	
	
	
	
	public static void init(){
		
		
		
		
		
	}
	
}
