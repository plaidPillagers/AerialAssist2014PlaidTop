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
public class MoveSwivelFor extends Command {
    private boolean hasExecuted = false;
    
    protected void initialize() {
        Robot.pincers.swivelStop();
    }

    protected void execute() {
        Robot.pincers.moveSwivelForward();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.pincers.swivelStop();
    }

    protected void interrupted() {
        Robot.pincers.swivelStop();
    }
    
}
