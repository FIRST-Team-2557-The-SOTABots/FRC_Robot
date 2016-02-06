package org.usfirst.frc2557.SOTABots2015.commands;

import org.usfirst.frc2557.SOTABots2015.Robot;
import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RangeCorrectionAuto extends Command {
	private double inchesFront;
	private double inchesLeftBack;
	private double inchesRightBack;
	private double minSweepAngle;
	private double maxSweepAngle;
	private double sweepAngle;
	private double hitInches;
	private double hitAngle;
	public boolean inRange;
	public double noHitInches;
	public double noHitAngle;
	public boolean notDone;
	public double x;
	public double z;
    public RangeCorrectionAuto() {
//    	requires(Robot.gyroSub);
//    	requires(Robot.rangeSub);
//    	requires(Robot.accelerometerSub);
//    	requires(Robot.driveWithJoystick);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	inchesFront = RobotMap.rangeCenter.getVoltage()/.009765;
    	inchesLeftBack = RobotMap.rangeLeft.getVoltage()/.009765;
    	inchesRightBack = RobotMap.rangeRight.getVoltage()/.009765;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	  minSweepAngle = 0;
    	  maxSweepAngle = 180;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	notDone = true;
    	while(notDone == true){
    	
    	noHitAngle = maxSweepAngle;
    	inRange = false;
    	sweepAngle = minSweepAngle;
    	while(sweepAngle <= maxSweepAngle){
    		RobotMap.servoCenter.setAngle(sweepAngle);
    		inchesFront = RobotMap.rangeCenter.getVoltage()/.009765;
    		if(inchesFront < 20){
    			hitInches = inchesFront;
    			hitAngle = sweepAngle;
    			inRange = true;
    	
    			}
    		else if(inRange == true){
    			noHitInches = inchesFront;
    			noHitAngle = sweepAngle;
    			inRange = false;
    		}
    		
    		sweepAngle = sweepAngle + 10;
    	}
    	while(sweepAngle >= minSweepAngle){
    		RobotMap.servoCenter.setAngle(sweepAngle);
    		sweepAngle = sweepAngle - 10;
    	}
    	
    	SmartDashboard.putNumber("The inches are", hitInches);
    	SmartDashboard.putNumber("The angle is", hitAngle);
    	SmartDashboard.putNumber("Not hitting inches", noHitInches);
    	SmartDashboard.putNumber("Not hitting angle", noHitAngle);
    	// Checking for the midpoint of the object using the servo angle
    	x = 0;
    	z = 0;
    	if((hitAngle + noHitAngle) / 2 > 2){
    		x = 1;
    		// SHOULD MOVE RIGHT
    	}
    	else if((hitAngle + noHitAngle) / 2 < -2){
    		x = -1;
    		// SHOULD MOVE LEFT
    	}
    	if(Math.cos(hitAngle) / hitInches < Math.cos(noHitAngle) / noHitInches){
    		z = 1;
    	}
    	else{
    		z = -1;
    	}
    	RobotMap.driveTrainRobotDrive41.mecanumDrive_Cartesian(x,0,z,0);
    	
    	if(((Math.abs(hitAngle + noHitAngle) / 2) < 2) && (Math.abs(hitInches - noHitInches) < 2)){
    		while(RobotMap.toteStop.get() == false){
    		RobotMap.driveTrainRobotDrive41.mecanumDrive_Cartesian(0,1,0,0);
    		}
    		RobotMap.driveTrainRobotDrive41.mecanumDrive_Cartesian(0,0,0,0);
    		notDone = false;
    	
    	}
    	
    	}
    	
    }
   

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
