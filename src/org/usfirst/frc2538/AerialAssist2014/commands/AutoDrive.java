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
    }

    protected void execute() {
        Robot.driveSystem.autoDrive();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
