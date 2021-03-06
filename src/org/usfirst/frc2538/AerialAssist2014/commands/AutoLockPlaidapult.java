/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2538.AerialAssist2014.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2538.AerialAssist2014.Robot;
import org.usfirst.frc2538.AerialAssist2014.RobotMap;

/**
 *
 * @author lenny
 */
public class AutoLockPlaidapult extends Command {
    private boolean hasFinished = false;
   
    protected void initialize() {
        hasFinished = false;
        //Robot.plaidapult.triggerReleased = !Robot.plaidapult.triggerReleased;
    }

    protected void execute() {
        //Robot.plaidapult.firePlaidapult();
        RobotMap.plaidapultTriggerActuator.set(DoubleSolenoid.Value.kForward);
        System.out.println("**********Locking Plaidapult*********");
        hasFinished = true;
    }

    protected boolean isFinished() {
        return hasFinished;
    }

    protected void end() {
        hasFinished = true;
    }

    protected void interrupted() {
        hasFinished = true;
    }
    
}
