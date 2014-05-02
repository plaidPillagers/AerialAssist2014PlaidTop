/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2538.AerialAssist2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author lenny
 */
public class SetPlaidapult extends CommandGroup{
    public SetPlaidapult(){
        addSequential (new PullInWinch());
        addSequential (new HalfSecondDelay(),.5);
        addSequential (new AutoLockPlaidapult(),.02);
        addSequential (new HalfSecondDelay(), .25);
        addSequential (new EaseWinch(),5.5);
    }
    
}
