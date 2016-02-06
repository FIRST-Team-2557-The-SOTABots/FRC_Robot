package org.usfirst.frc2557.SOTABots2015.subsystems;

import org.usfirst.frc2557.SOTABots2015.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pnuematics extends Subsystem {
    public static DoubleSolenoid grab = RobotMap.grab;								//Breakout 1; port 0 and 1
    public static DoubleSolenoid intakeSol = RobotMap.intakeSol;					//Breakout 1; port 2 and 3
    public static DoubleSolenoid ejector = RobotMap.ejector;						//Breakout 1; port 4 and 5
    public static DoubleSolenoid rightHook = RobotMap.rightHook;					//Breakout 1; port 6 and 7
    public static DoubleSolenoid backHook = RobotMap.backHook;						//Breakout 2; port 0 and 1
    public static DoubleSolenoid leftHook = RobotMap.leftHook;						//Breakout 2; port 2 and 3
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    } 
    
    public void grab(){
    	if(RobotMap.grabbool){
	    	grab.set(Value.kForward);
	    	RobotMap.grabbool = false;
    	}else{
    		grab.set(Value.kReverse);
    		RobotMap.grabbool = true;
    	}
    }
    
    public void intake(){
    	if(RobotMap.intakebool){
    		intakeSol.set(Value.kForward);
    		RobotMap.intakebool = false;
    	}else{
    		intakeSol.set(Value.kReverse);
    		RobotMap.intakebool = true;
    	}
    }
    
    public void eject(){
    	if(RobotMap.ejectbool){
    		ejector.set(Value.kForward);
    		RobotMap.ejectbool = false;
    	}else{
    		ejector.set(Value.kReverse);
    		RobotMap.ejectbool = true;
    	}
    }
    
    public void back(){
    	if(RobotMap.backbool){
    		backHook.set(Value.kForward);
    		RobotMap.backbool = false;
    	}else{
    		backHook.set(Value.kReverse);
    		RobotMap.backbool = true;
    	}
    }
    
    public void left(){
    	if(RobotMap.leftbool){
    		leftHook.set(Value.kForward);
    		RobotMap.leftbool = false;
    	}else{
    		leftHook.set(Value.kReverse);
    		RobotMap.leftbool = true;
    	}
    }
    
    public void right(){
    	if(RobotMap.rightbool){
    		rightHook.set(Value.kForward);
    		RobotMap.rightbool = false;
    	}else{
    		rightHook.set(Value.kReverse);
    		RobotMap.rightbool = true;
    	}
    }
    public void init(){
    	grab.set(Value.kReverse);
    	RobotMap.grabbool =  true;
    	intakeSol.set(Value.kReverse);
    	RobotMap.intakebool =  true;
    	ejector.set(Value.kForward);
    	RobotMap.ejectbool = false;
    	backHook.set(Value.kReverse);
    	RobotMap.backbool = true;
    	leftHook.set(Value.kReverse);
    	RobotMap.leftbool = false;
    	rightHook.set(Value.kReverse);
    	RobotMap.rightbool =  false;
    }
}

