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
public class AutoMoveSwivelForward extends Command {
    private boolean hasExecuted;
    
    protected void initialize() {
        hasExecuted = false;
        Robot.pincers.swivelStop();
        Robot.pincers.autoMoveSwivelDone = false;
    }

    protected void execute() {
        Robot.pincers.autoMoveSwivelForward();
        hasExecuted = true;
    }

    protected boolean isFinished() {
        return hasExecuted;
        }

    protected void end() {
        Robot.pincers.swivelStop();
        hasExecuted = true;
        Robot.pincers.autoMoveSwivelDone = true;
    }

    protected void interrupted() {
        Robot.pincers.swivelStop();
        hasExecuted = true;
        Robot.pincers.autoMoveSwivelDone = true;
    }
    
}
