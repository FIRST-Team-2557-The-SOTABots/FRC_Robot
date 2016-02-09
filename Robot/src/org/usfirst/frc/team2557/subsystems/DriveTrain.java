// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2557.SOTABots2015.subsystems;

import org.usfirst.frc2557.SOTABots2015.RobotMap;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController frontLeft = RobotMap.driveTrainFrontLeft;
    SpeedController frontRight = RobotMap.driveTrainFrontRight;
    SpeedController backLeft = RobotMap.driveTrainBackLeft;
    SpeedController backRight = RobotMap.driveTrainBackRight;
    RobotDrive robotDrive41 = RobotMap.driveTrainRobotDrive41;
    Gyro gyro = RobotMap.gyro;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

     public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void arcadeDrive (Joystick joystick1){
    	robotDrive41.arcadeDrive(joystick1);
    }
    public void mecanumDrive_Cartesian123(double x,double y,double rotation,double gyroAngle){
    	robotDrive41.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
    	//robotDrive41.mecanumDrive_Polar(x, y, rotation);//gyro.getAngle());
    }
   
    public void mecanumDrive_Polar123(double magnitude, double direction, double rotation) {
    	robotDrive41.mecanumDrive_Polar(magnitude, direction, rotation);	
    }
    
    public void mvX(double x){
    	robotDrive41.mecanumDrive_Cartesian(x, 0, 0, gyro.getAngle());
    	/* Strafe x
    	 */
    }
    public void mvY(double y){
    	robotDrive41.mecanumDrive_Cartesian(0, y, 0, gyro.getAngle());
    	/* Strafe x
    	 */
    }
    public void rotate(double rotate){
    	robotDrive41.mecanumDrive_Polar(0, 0, rotate);
    	/* Rotate clockwise by degrees passed to Gyro.
    	 */
    }
   }
