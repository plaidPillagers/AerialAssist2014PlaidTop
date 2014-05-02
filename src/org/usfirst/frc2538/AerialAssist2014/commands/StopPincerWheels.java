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
public class StopPincerWheels extends Command{

    public StopPincerWheels(){
        requires(Robot.pincerWheels);
    }
    protected void initialize() {
        Robot.pincerWheels.wheelState = 0;
    }
    protected void execute() {
        Robot.pincerWheels.spinWheels();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
