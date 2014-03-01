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
public class AutoMoveSwivelAft extends Command{
    private boolean hasExecuted;
   
    protected void initialize() {
        Robot.pincers.swivelStop();
        hasExecuted = false;
    }

    protected void execute() {
        Robot.pincers.moveSwivelAft();
        hasExecuted = true;
    }

    protected boolean isFinished() {
        return hasExecuted;
    }

    protected void end() {
        Robot.pincers.swivelStop();
        hasExecuted = true;
    }

    protected void interrupted() {
        Robot.pincers.swivelStop();
        hasExecuted = true;
    }
    
}
