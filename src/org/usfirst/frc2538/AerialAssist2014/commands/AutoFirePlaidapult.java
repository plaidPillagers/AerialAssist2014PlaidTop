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
public class AutoFirePlaidapult extends Command {
    private boolean hasFinished = false;
   
    protected void initialize() {
        hasFinished = false;
        Robot.plaidapult.triggerReleased = !Robot.plaidapult.triggerReleased;
    }

    protected void execute() {
        Robot.plaidapult.firePlaidapult();
        hasFinished = true;
    }

    protected boolean isFinished() {
        return hasFinished;
    }

    protected void end() {
        hasFinished = true;
    }

    protected void interrupted() {
    }
    
}
