package org.usfirst.frc.team2557.robot.commands.autonomous.macro;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import java.io.FileWriter;
import java.io.IOException;

public class MacroRecorder {

    //this object writes values into the file we specify
    FileWriter writer;

    long startTime;

    public MacroRecorder(String filepath) throws IOException
    {
        //record the time we started recording
        startTime = System.currentTimeMillis();

        //put the filesystem location you are supposed to write to as a string
        //as the argument in this method, as of 2015 it is /home/lvuser/recordedAuto.csv
        writer = new FileWriter(filepath);
    }


    public void record() throws IOException
    {
        if(writer != null)
        {
            //start each "frame" with the elapsed time since we started recording
            writer.append("" + (System.currentTimeMillis()-startTime));

            //in this chunk, use writer.append to add each type of data you want to record to the frame
            //the 2015 robot used the following motors during auto

            // Drive motors
            writer.append("," + RobotMap.driveLeft1.get()); // Left 1
            writer.append("," + RobotMap.driveLeft2.get()); // Left 2
            writer.append("," + RobotMap.driveRight1.get()); // Right 1
            writer.append("," + RobotMap.driveRight2.get()); // Right 2

            // Catapult motor
            writer.append("," + RobotMap.catapultMotor.get()); // Catapult

            // Arm position
            writer.append("," + Robot.arm.getPosition()); // Arm potentiometer position

		/*
		 * THE LAST ENTRY OF THINGS YOU RECORD NEEDS TO HAVE A DELIMITER CONCATENATED TO
		 * THE STRING AT THE END. OTHERWISE GIVES NOSUCHELEMENTEXCEPTION
		 */

            // Intake motor
            writer.append("," + RobotMap.intakeMotor.get() + "\n");

		/*
		 * CAREFUL. KEEP THE LAST THING YOU RECORD BETWEEN THESE TWO COMMENTS AS A
		 * REMINDER TO APPEND THE DELIMITER
		 */
        }
    }


    //this method closes the writer and makes sure that all the data you recorded makes it into the file
    public void end() throws IOException
    {
        if(writer !=null)
        {
            writer.flush();
            writer.close();
        }
    }

}
