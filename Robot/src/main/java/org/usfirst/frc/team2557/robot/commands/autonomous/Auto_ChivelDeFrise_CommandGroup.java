package org.usfirst.frc.team2557.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_ChivelDeFrise_CommandGroup extends CommandGroup {
    
    public  Auto_ChivelDeFrise_CommandGroup() {
    	
    	//Added this to make sure that when the subsystem receives an input form the drive team that the robot will know what to do.
    	//In this Command Group we can see that the chivel de frise will be activated then once done do another command in the order of which they are presented.
    	//You see this by seeing the add Sequential next to each of the commands that are going to run during this command group.
    	addSequential(new Auto_ChivelDeFrise());
    	addSequential(new Auto_ChivelDeFrise_Rotation());
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
