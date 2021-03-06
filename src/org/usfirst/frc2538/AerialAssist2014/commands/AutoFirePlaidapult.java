/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2538.AerialAssist2014.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2538.AerialAssist2014.RobotMap;

/**
 *
 * @author lenny
 */
public class AutoFirePlaidapult extends Command{
    boolean hasExecuted = false;
    
    protected void initialize() {
        hasExecuted = false;
    }

    protected void execute() {
        RobotMap.plaidapultTriggerActuator.set(DoubleSolenoid.Value.kReverse);
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
