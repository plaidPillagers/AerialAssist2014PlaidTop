/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2538.AerialAssist2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2538.AerialAssist2014.Robot;

/**
 *
 * @author Plaidtop
 */
public class AutonomousCommand extends CommandGroup {
    public AutonomousCommand(){
        boolean hotGoalTracking = true;
        //addParallel(null);
        if(hotGoalTracking){
            addSequential(new AutoPullInWinch()); // stops at a limit switch
            //System.out.println("************** Start driving ****************");
            addSequential(new AutoFirePlaidapult(),0.2);
            addSequential(new EaseWinch(), 5);
            addSequential(new AutoDrive(), 1.5);
            //System.out.println("************** Stop driving, start pincers ****************");
            addSequential(new AutoTogglePincers(),2);
            addSequential(new AutoFirePlaidapult(),0.2);
            //System.out.println("************** Start plaidapult ****************");
            //addSequential(new AutoDelayedFirePlaidapult());         
        }
        
        else{
            addSequential(new AutoPullInWinch());
            addSequential(new AutoDrive());
            addSequential(new AutoTogglePincers());
            addSequential(new AutoFirePlaidapult());
            addSequential(new PullInWinch());
            addSequential(new AutoMoveSwivelForward());
            addSequential(new AutoTogglePincers());
            addSequential(new AutoMoveSwivelAft());
            addSequential(new AutoTogglePincers());
            addSequential(new AutoFirePlaidapult());
        }
    }
}
