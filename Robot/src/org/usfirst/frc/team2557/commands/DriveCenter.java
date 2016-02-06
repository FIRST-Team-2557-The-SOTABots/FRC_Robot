package org.usfirst.frc2557.SOTABots2015.commands;

import org.usfirst.frc2557.SOTABots2015.Robot;
import java.lang.Math.*;
import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCenter extends Command {
	// Let's go ahead and call crap that we're going to be calling soone anyways.
	private String side;
	private double target;
	private double location;
	private double speed;
	private String left = "Left";
	private String right = "Right";
	private String center = "Center";
	private double angl;
	private double rotation;
	
    public 	DriveCenter(String side, double target, double location, double speed) { // <-- call them again... 0\
    	// And one more time for luck... So damn dumb. Wherz mah paithawnz!?
        this.side = side;
        this.target = target;
        this.location = location;
        this.speed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveWithJoystick);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Call radar to determine which side and which degree is center.
    	// Need to determine which side we need to line target up to on frame.
		double instance = RobotMap.gyro.getAngle();
		
		
    	//// NOT DONE. CANT CONTINUE UNTIL MATH IS RIGHT
    	float rotation = 0;
    	// call offset to calculate what degree target is what degree on gyro.
    	Robot.driveWithJoystick.mecanumDrive_Polar123(speed, angl, rotation);
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