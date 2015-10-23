package org.usfirst.frc2557.SOTABots2015.commands;

import org.usfirst.frc2557.SOTABots2015.Robot;
import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Lift extends Command {

    public Lift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.manipulator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {


//        if(RobotMap.liftStop.get() == true && Robot.oi.gamepad1.getRawButton(5)){
//        	RobotMap.grab.set(Value.kForward);
//        	RobotMap.grabbool = false;
//        }

    	SmartDashboard.putBoolean("LEVEL 1 FOR TOTE: ", RobotMap.liftSensor.get());
    	if (Robot.oi.gamepad1.getRawButton(6)){
    		
			RobotMap.liftMotor.set(1);
		}
		else if (RobotMap.liftStop.get() == true && Robot.oi.gamepad1.getRawButton(5)){
			RobotMap.liftMotor.set(0);
		}
    	else if (RobotMap.liftStop.get() == false && Robot.oi.gamepad1.getRawButton(5)){
			RobotMap.liftMotor.set(-1);
		}
		else{
    		RobotMap.liftMotor.set(0);
		}
//    	
//    	
//    	
    	
//    	if(RobotMap.liftStop.get() == false && -Robot.oi.XboxController2.getRawAxis(1) <= 0){
//    		RobotMap.liftMotor.set(0);
//    	}
//    	else{
//    		RobotMap.liftMotor.set(-Robot.oi.XboxController2.getRawAxis(1));
//    	}
//    	
    	
    	//RobotMap.liftMotor.set(-Robot.oi.XboxController2.getRawAxis(1));
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
