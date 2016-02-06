package org.usfirst.frc2557.SOTABots2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousThird extends CommandGroup {
    
    public  AutonomousThird() {
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
    	addSequential(new AutoGrabClose()); //.1
    	addSequential(new AutoLiftUp(.1));
    	addParallel(new AutoDrive(0,.5,0,.1));
    	addSequential(new AutoLiftUp(2.9)); //3
    	
    	addSequential(new AutoArmClose());
    	
    	addParallel(new AutoDrive(0,.6,-.03,.5));//3.5
    	addSequential(new AutoIntake(1,.5));
    	
    	addSequential(new AutoArmOpen());
    	
    	addSequential(new AutoDrive(0,.5,-.03,2.5));//6
    	
    	addSequential(new AutoArmClose());
    	
    	addParallel(new AutoIntake(-.75, .5));//6.5
    	addSequential(new AutoLiftDown(.5));
    	
    	addSequential(new AutoGrabOpen());
    	addSequential(new AutoLiftDown(3));//9.5
    	addSequential(new AutoGrabClose());
    	addSequential(new AutoLiftUp(1));//10.5
    }
}
