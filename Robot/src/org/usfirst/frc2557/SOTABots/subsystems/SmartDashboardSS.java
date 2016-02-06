package org.usfirst.frc2557.SOTABots2015.subsystems;

import org.usfirst.frc2557.SOTABots2015.Robot;
import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SmartDashboardSS extends Subsystem {
	Counter frontLeftEncoder 	= RobotMap.frontLeftEnc;
	Counter frontRightEncoder 	= RobotMap.frontRightEnc;
	Counter rearLeftEncoder 	= RobotMap.rearLeftEnc;
	Counter rearRightEncoder 	= RobotMap.rearRightEnc;
	AnalogInput rangeLeft 		= RobotMap.rangeLeft;
	AnalogInput rangeRight 		= RobotMap.rangeRight;
	AnalogInput rangeCenter		= RobotMap.rangeCenter;
	PowerDistributionPanel PDP	= RobotMap.PDP;
	BuiltInAccelerometer accelerometer = RobotMap.accelerometer;
	double divider 		= .009765;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void limitSwitchOutput() {
        //Limit Switch
        if(RobotMap.toteStop.equals(true)){
            SmartDashboard.putString("Limit Switch", "ON");
        }
        else{
            SmartDashboard.putString("Limit Switch", "OFF");
        }
    }    
    public void locationOutput(){
      	//Gyro
        SmartDashboard.putNumber("Gyro angle is: ",RobotMap.gyro.getAngle() );
        
        //Accelerometers
        SmartDashboard.putNumber("Accelerometer Y-Axis: ", RobotMap.accelerometer.getY());
        SmartDashboard.putNumber("Accelerometer X-Axis: ", RobotMap.accelerometer.getX());
        }
        
    public void rangeOutputs(){
    	//RangeFinders
        
        SmartDashboard.putNumber("The Left Range Finder normal: ", rangeLeft.getVoltage()/divider);
        SmartDashboard.putNumber("The Right Range Finder normal: ", rangeRight.getVoltage()/divider);
        SmartDashboard.putNumber("The Center Range Finder normal: ", rangeCenter.getVoltage()/divider);
        SmartDashboard.putNumber("The Left Range Finder average: ", rangeLeft.getAverageVoltage()/divider);
        SmartDashboard.putNumber("The Right Range Finder average: ", rangeRight.getAverageVoltage()/divider);
        SmartDashboard.putNumber("The Center Range Finder average: ", rangeCenter.getAverageVoltage()/divider);
    }
    public void servoAngleOutputs(){
    	//Testing for Radar/Rangefinder
        	SmartDashboard.putNumber("The Center Range Finder Angle:", RobotMap.servoCenter.getAngle());
        	SmartDashboard.putNumber("The Left Range Finder Angle:", RobotMap.servoLeft.getAngle());
        	SmartDashboard.putNumber("The Right Range Finder Angle:", RobotMap.servoRight.getAngle());
    }
    public void encoderOutput(){
    	//Encoders
        SmartDashboard.putNumber("front left enc", frontLeftEncoder.get());
    	SmartDashboard.putNumber("front right enc", frontRightEncoder.get());
    	SmartDashboard.putNumber("rear left enc", rearLeftEncoder.get());
    	SmartDashboard.putNumber("rear right enc", rearRightEncoder.get());
    }
    public void powerOutput(){
    	//Power Distribution
    	SmartDashboard.putNumber("Front Right", PDP.getCurrent(12));
        SmartDashboard.putNumber("Front Left", PDP.getCurrent(13));
        SmartDashboard.putNumber("Back Right", PDP.getCurrent(14));
        SmartDashboard.putNumber("Back Left", PDP.getCurrent(15));
    }
}

