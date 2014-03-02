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
        System.out.println("Started autonomous");
        boolean hotGoalTracking = true;
        //addParallel(null);
        if(hotGoalTracking){
            addSequential(new AutoPullInWinch()); // stops at a limit switch
            addSequential(new AutoDrive());
            addSequential(new AutoTogglePincers());
            addSequential(new AutoFirePlaidapult());
        }
        else{
            addSequential(new AutoPullInWinch());
            addSequential(new AutoDrive());
            addSequential(new AutoTogglePincers());
            addSequential(new AutoFirePlaidapult());
            addParallel(new PullInWinch());
            addSequential(new AutoMoveSwivelForward());
            addSequential(new AutoTogglePincers());
            addSequential(new AutoMoveSwivelAft());
            addSequential(new AutoTogglePincers());
            addSequential(new AutoFirePlaidapult());
        }
    }
}
