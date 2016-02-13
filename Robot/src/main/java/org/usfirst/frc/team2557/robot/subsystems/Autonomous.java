package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Autonomous extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void chivelDeFrise(){
    	if(RobotMap.RangeFinderF.getVoltage()>4 ){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    }
    
    public void chivelDeFriserotation(){
    	if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()<=12 && RobotMap.RangeFinderR.getVoltage()<=16){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(1, 1);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()<=4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(.5, 1);
    	}
    	
    }
    
    public void drawBridge(){
    	if(RobotMap.RangeFinderF.getVoltage()>4 ){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    }
    
    public void drawBridgeRotation(){
    	if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()<=12 && RobotMap.RangeFinderR.getVoltage()<=16){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(1, 1);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()<=4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(.5, 1);
    	}
    }
    
    public void lowBarRotation(){
    	if(RobotMap.RangeFinderF.getVoltage()>3){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    	else if(RobotMap.RangeFinderF.getVoltage()<=3){
    		RobotMap.robotDrive.arcadeDrive(0, 1);
    	}
    }
    
    public void lowBar(){
    	if(RobotMap.RangeFinderB.getVoltage()>5){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    }
    
    public void moat(){
    	if(RobotMap.RangeFinderF.getVoltage()>10){ 
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    }
    
    public void moatRotation(){
    	if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()<=12 && RobotMap.RangeFinderR.getVoltage()<=16){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(1, 1);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()<=4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(.5, 1);
    	}
    }
    
    public void portcullis(){
    	if(RobotMap.RangeFinderF.getVoltage()>4){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    }
    
    public void portcullisRotation(){
    	if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()<=12 && RobotMap.RangeFinderR.getVoltage()<=16){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(1, 1);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()<=4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(.5, 1);
    	}
    }
    
    public void rampart(){
    	if(RobotMap.RangeFinderF.getVoltage()>10){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    }
    
    public void rampartRotation(){
    	if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()<=12 && RobotMap.RangeFinderR.getVoltage()<=16){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(1, 1);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()<=4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(.5, 1);
    	}
    }
    
    public void rockWall(){
    	if(RobotMap.RangeFinderF.getVoltage()>10){
    		RobotMap.robotDrive.arcadeDrive(.5,0);
    	}
    }
    
    public void rockWallRotation(){
    	if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()<=12 && RobotMap.RangeFinderR.getVoltage()<=16){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(1, 1);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()<=4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(.5, 1);
    	}
    }
    
    public void roughTerrain(){
    	if(RobotMap.RangeFinderF.getVoltage()>10){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    }
    
    public void roughTerrainRotation(){
    	if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()<=12 && RobotMap.RangeFinderR.getVoltage()<=16){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(1, 1);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()<=4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(.5, 1);
    	}
    }
    
    public void sallyPort(){
    	if(RobotMap.RangeFinderF.getVoltage()>4){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    }
    
    public void sallyPortRotation(){
    	if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()<=12 && RobotMap.RangeFinderR.getVoltage()<=16){
    		RobotMap.robotDrive.arcadeDrive(1, 0);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()>4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(1, 1);
    	}
    	else if (RobotMap.RangeFinderF.getVoltage()<=4 && RobotMap.RangeFinderL.getVoltage()>12 && RobotMap.RangeFinderR.getVoltage()<16){
    		RobotMap.robotDrive.arcadeDrive(.5, 1);
    	}
    }
}
