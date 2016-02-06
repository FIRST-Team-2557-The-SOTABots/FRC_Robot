package org.usfirst.frc2557.SOTABots2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousSecond extends CommandGroup {
    
    public  AutonomousSecond() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
//    	addSequential(new AutoGrabClose());
//    	addSequential(new AutoDrive(0,.4,-.03,1.3));
//    	
//    	addParallel(new AutoDrive(0,-.5,0,.3));
//    	addSequential(new AutoLiftUp(1));
//    	
//    	addParallel(new AutoDrive(0,0,.5,1));
//    	addSequential(new AutoLiftUp(1));
//    	
//    	addParallel(new AutoDrive(-1,.06,0,1));
//    	addSequential(new AutoLiftUp(1));
//    	
//    	
//    	addSequential(new AutoRightHook());
//    	addSequential(new AutoDrive(0,0,-.5,1));
//    	addSequential(new AutoDrive(0,.5,-.03,1));
//    	addSequential(new AutoArmClose());
//    	
//    	addParallel(new AutoIntake(.5, 1));
//    	addSequential(new AutoLiftDown(.5));
//    	
//    	addSequential(new AutoGrabOpen());
//    	addSequential(new AutoLiftDown(2.5));
//    	addSequential(new AutoGrabClose());
//    	
//    	addParallel(new AutoLiftUp(1));
//    	addSequential(new AutoDrive(0,0,-.5,1));
//    	
//    	addParallel(new AutoLiftUp(1));
//    	addSequential(new AutoDrive(1,.03,0,1));
//    	
//    	addSequential(new AutoLeftHook());
//    	
//    	addParallel(new AutoDrive(0,0,.5,1));
//    	addSequential(new AutoLiftUp(1));
//    	
//    	addSequential(new AutoDrive(0,.5,-.03,1));
//    	addSequential(new AutoArmClose());
//    	addSequential(new AutoIntake(.5, 1));
//    	
//    	addParallel(new AutoLiftDown(.5));
//    	addSequential(new AutoDrive(1,0,0,1));
//    	
//    	addSequential(new AutoGrabOpen());
//    	addSequential(new AutoArmOpen());
//    	addSequential(new AutoDrive(0,-.5,.03,1));
    	
///////Straight Ahead//////
    	addSequential(new AutoGrabClose()); //1
    	addSequential(new AutoLiftUp(1));
    	
    	addParallel(new AutoDrive(0,-.2,0,.5));
    	addSequential(new AutoLiftUp(.5)); //1.5
    	
    	addSequential(new AutoArmClose());
    	
    	addParallel(new AutoDrive(0,.25,-.03,1.5));//2.5
    	addSequential(new AutoIntake(1,1.5));
    	
    	addSequential(new AutoArmOpen());
    	
    	addParallel(new AutoDrive(0,.3,-.03,2.5));//5
    	addSequential(new AutoLiftUp(1.5));
    	
    	addSequential(new AutoArmClose());
    	
    	addParallel(new AutoIntake(-.75, .5));//5.5
    	addSequential(new AutoLiftDown(.5));
    	
    	addSequential(new AutoGrabOpen());
    	addSequential(new AutoLiftDown(3));
    	addSequential(new AutoGrabClose());
    	addSequential(new AutoLiftUp(1));
    	
    	addParallel(new AutoDrive(0,-.3,-.03,.5));//6
    	addSequential(new AutoLiftUp(.5));
    	
    	addSequential(new AutoArmClose());
    	
    	addParallel(new AutoDrive(0,.5,-.03,1.5));//7
    	addSequential(new AutoIntake(1,1.5));
    	
    	addSequential(new AutoArmOpen());
    	
    	addParallel(new AutoDrive(0,.3,-.03,2.5));//9.5
    	addSequential(new AutoLiftUp(1.5));
    	
    	addSequential(new AutoArmClose());
    	
    	addSequential(new AutoIntake(-.75, 1));//10.5
    	
    	addParallel(new AutoDrive(-1,0,0,3));//13.5
    	addSequential(new AutoLiftDown(1));
    	
    	addSequential(new AutoGrabOpen());
    	addSequential(new AutoArmOpen());
    	addSequential(new AutoDrive(0,-.5,0,1));//14.5

    	
    	
    	
    	
    	
    	
    }
}
