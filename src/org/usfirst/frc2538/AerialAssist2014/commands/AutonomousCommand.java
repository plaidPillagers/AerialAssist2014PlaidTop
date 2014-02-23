/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2538.AerialAssist2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Plaidtop
 */
public class AutonomousCommand extends CommandGroup {
    public AutonomousCommand(){
        //addParallel(null);
        addSequential(new PullInWinch()); // stops at a limit switch
        addSequential(new TogglePincers());
    }
}
