/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2538.AerialAssist2014.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2538.AerialAssist2014.Robot;

/**
 *
 * @author lenny
 */
public class AutoDrive extends Command{
    
    protected void initialize() {
        Robot.driveSystem.stop();
        Robot.driveSystem.autoDriveDone = false;
    }

    protected void execute() {
        Robot.driveSystem.autoDrive();
        System.out.println("DRIVING FORWARD");
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.driveSystem.autoDriveDone = true;
        System.out.println("ENDED");
    }

    protected void interrupted() {
        Robot.driveSystem.autoDriveDone = true;
        System.out.println("INTERRUPTED");
    }
    
}
