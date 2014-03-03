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
public class AutoDelayedFirePlaidapult extends Command {
    private boolean hasExecuted;
    
    protected void initialize() {
        Robot.plaidapult.startTiming();
        hasExecuted = false;
    }

    protected void execute() {
        if(Robot.plaidapult.getTime() > Robot.plaidapult.FIVE_SECOND){
            Robot.plaidapult.firePlaidapult();
            hasExecuted = true;
        }
        else{
            hasExecuted = false;
        }
    }

    protected boolean isFinished() {
        return hasExecuted;
    }

    protected void end() {
        hasExecuted = false;
        
    }

    protected void interrupted() {
        hasExecuted = false;
    }
    
}
