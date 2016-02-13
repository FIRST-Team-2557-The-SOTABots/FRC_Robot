package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_DrawBridge_CommandGroup extends CommandGroup {
    
    public  Auto_DrawBridge_CommandGroup() {
    	
    	//This is to allow the below commands to run during autonomous.
    	//Due to this the commands should run. Although the commands due not have much code due to the fact that the
    	//fact that the code is in the methods.
    	
    	addSequential(new Auto_DrawBridge());
    	addSequential(new Auto_DrawBridge_Rotation());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());xs
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
