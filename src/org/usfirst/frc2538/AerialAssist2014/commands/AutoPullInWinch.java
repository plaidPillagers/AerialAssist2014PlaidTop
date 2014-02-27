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
public class AutoPullInWinch extends Command{
    public AutoPullInWinch() {
        requires(Robot.plaidapult);
    }

    protected void initialize() {
        Robot.plaidapult.winchMaxLoadReached = false;
    }

    protected void execute() {
        System.out.println("Executing pull in winch");
        Robot.plaidapult.pullIn();
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
