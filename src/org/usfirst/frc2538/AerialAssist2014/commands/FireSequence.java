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
public class FireSequence extends CommandGroup {
    public FireSequence(){
        //addSequential (new SpitOutBall(), 1);
        addSequential (new OpenPincers(), .5);
        addSequential (new FirePlaidapult());
    }
    
}
