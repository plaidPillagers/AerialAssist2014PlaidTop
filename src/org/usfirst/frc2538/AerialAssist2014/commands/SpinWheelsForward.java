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
public class SpinWheelsForward extends Command{
    public SpinWheelsForward(){
        requires(Robot.pincerWheels);
    }
    protected void initialize() {
        System.out.println("wheels forward initialized");
        if(Robot.pincerWheels.wheelState == 1){
            Robot.pincerWheels.wheelState = 0;
        }
        else{
            Robot.pincerWheels.wheelState = 1;
        }
    }

    protected void execute() {
        Robot.pincerWheels.spinWheels();
    }

    protected boolean isFinished() {
        
        //if(Robot.pincers.wheelState != -1 && hasExecuted){
        //    return true;
        //}
        //else{
            return false;
        //}
    }

    protected void end() {
    }

    protected void interrupted() {
        System.out.println("wheels forward interrupted");
    }
    
}
