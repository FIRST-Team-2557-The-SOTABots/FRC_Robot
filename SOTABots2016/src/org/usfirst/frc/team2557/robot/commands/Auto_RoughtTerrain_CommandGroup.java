package org.usfirst.frc.team2557.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_RoughtTerrain_CommandGroup extends CommandGroup {
    
    public  Auto_RoughtTerrain_CommandGroup() {
    	
    	//RoughTerrain which is a 
    	addSequential(new Auto_RoughTerrain());
    	addSequential(new Auto_RoughTerrain_Rotation());
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
    }
}

//this is only a test
//Plz make sure to comment all the time when doing a video
