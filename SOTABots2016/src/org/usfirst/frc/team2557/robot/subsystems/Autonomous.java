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
    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
    	}
    }
    
    public void drawBridge(){
    	if(RobotMap.RangeFinderF.getVoltage()>4 ){
    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
    	}
    }
    
    public void lowBarRotation(){
    	if(RobotMap.RangeFinderF.getVoltage()>3){
    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
    	}
    	else if(RobotMap.RangeFinderF.getVoltage()<=3){
    		RobotMap.arcadeDrive.arcadeDrive(0, 1);
    	}
    }
    
    public void lowBar(){
    	if(RobotMap.RangeFinderB.getVoltage()>5){
    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
    	}
    }
    public void moat(){
    	if(RobotMap.RangeFinderF.getVoltage()>10){ 
    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
    	}
    }
    
    public void portculis(){
    	if(RobotMap.RangeFinderF.getVoltage()>4){
    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
    	}
    }
    
    public void rampart(){
    	if(RobotMap.RangeFinderF.getVoltage()>10){
    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
    	}
    }
    
    public void rockWall(){
    	if(RobotMap.RangeFinderF.getVoltage()>10){
    		RobotMap.arcadeDrive.arcadeDrive(.5,0);
    	}
    }
    
    public void roughTerrain(){
    	if(RobotMap.RangeFinderF.getVoltage()>10){
    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
    	}
    }
    
    public void sallyPort(){
    	if(RobotMap.RangeFinderF.getVoltage()>4){
    		RobotMap.arcadeDrive.arcadeDrive(1, 0);
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
}

