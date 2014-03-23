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
public class SpinWheelsReverse extends Command {

    protected void initialize() {
        if(Robot.pincers.wheelState == -1){
            System.out.println("wheels at zero!!!");
            Robot.pincers.wheelState = 0;
        }
        else{
            Robot.pincers.wheelState = -1;
        }
    }

    protected void execute() {
        Robot.pincers.spinWheels();
    }

    protected boolean isFinished() {
        if(Robot.pincers.wheelState != 1){
            return true;
        }
        else{
            return false;
        }
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
