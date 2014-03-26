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
public class ShortShotSetUp extends CommandGroup{
    ShortShotSetUp(){
        addSequential (new PullInWinch());
        addSequential (new LockPlaidapult());
        addSequential (new EaseWinch(), 3);
    }
}
