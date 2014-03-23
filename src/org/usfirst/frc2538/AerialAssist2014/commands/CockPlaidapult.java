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
public class CockPlaidapult extends Command{

    protected void initialize() {
        Robot.plaidapult.winchMaxLoadReached = false;
    }

    protected void execute() {
        Robot.plaidapult.pullIn();
        Robot.plaidapult.lockPlaidapult();
        Robot.plaidapult.easeWinch();
    }

    protected boolean isFinished() {
        return Robot.plaidapult.winchMaxLoadReached;
    }

    protected void end() {
        Robot.plaidapult.stop();
    }

    protected void interrupted() {
        Robot.plaidapult.stop();
    }
    
}
