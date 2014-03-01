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

    private boolean hasExecuted;
    
    protected void initialize() {
        Robot.driveSystem.stop();
        hasExecuted = false;
    }

    protected void execute() {
        Robot.driveSystem.autoDrive();
        hasExecuted = true;
    }

    protected boolean isFinished() {
        return hasExecuted;
    }

    protected void end() {
        hasExecuted = true;
    }

    protected void interrupted() {
        hasExecuted = true;
    }
    
}
