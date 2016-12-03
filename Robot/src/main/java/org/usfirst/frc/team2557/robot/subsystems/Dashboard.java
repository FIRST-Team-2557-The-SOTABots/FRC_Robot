package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2557.robot.commands.DashboardPrintCommand;

public class Dashboard extends Subsystem {

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DashboardPrintCommand());
    }

}
