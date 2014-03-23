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
public class ConfigTalon extends Command{
    
    protected void initialize() {
        Robot.plaidapult.configured = false;
        Robot.plaidapult.resetTiming();
    }

    protected void execute() {
        if(Robot.plaidapult.configured == false){
            Robot.plaidapult.configTalon();
        }
    }
    
    protected boolean isFinished() {
        return Robot.plaidapult.configured;
    }

    protected void end() {
        Robot.plaidapult.configured = true;
    }

    protected void interrupted() {
        Robot.plaidapult.configured = true;
    }
    
}
