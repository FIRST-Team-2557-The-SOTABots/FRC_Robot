package org.usfirst.frc2557.SOTABots2015.subsystems;

import org.usfirst.frc2557.SOTABots2015.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutoDrive extends Subsystem {
	private double x;
	private double y;
	private double rotation;
	private double gyroAngle;
	
    int A = RobotMap.frontLeftEnc.get();
    int B = RobotMap.frontRightEnc.get();
    int C = RobotMap.rearLeftEnc.get();
    int D = RobotMap.rearRightEnc.get();
    public int E;
    

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand(double x1, double y1, double rotation1, double gyroAngle1, double E) {
  		this.x = x1;
  		this.y = y1;
  		this.rotation = rotation1;
  		this.gyroAngle = gyroAngle1;
    }
		public void Drive(){
			while (A < E && B < E && C < E && D < E){
				RobotMap.driveTrainRobotDrive41.mecanumDrive_Cartesian(this.x, this.y, this.rotation,this.gyroAngle);
				
			}
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    
		}
		@Override
		protected void initDefaultCommand() {
			// TODO Auto-generated method stub
			
		}
}
