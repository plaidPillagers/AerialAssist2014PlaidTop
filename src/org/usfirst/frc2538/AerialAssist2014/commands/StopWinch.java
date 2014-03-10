/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2538.AerialAssist2014.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2538.AerialAssist2014.Robot;

/**
 *
 * @author Plaidtop
 */
public class StopWinch extends Command{
    private boolean hasExecuted = false;
    protected void initialize() {
        hasExecuted = false;
    }

    protected void execute() {
        Robot.plaidapult.stop();
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
