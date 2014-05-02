
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
public class MoveSwivelFore extends Command {
    public MoveSwivelFore(){
        requires(Robot.pincers);
    }
    
    protected void initialize() {
        Robot.pincers.swivelStop();
    }

    protected void execute() {
        Robot.pincers.moveSwivelForward();
    }

    protected boolean isFinished() {
        return !Robot.pincers.okForward();
    }

    protected void end() {
        Robot.pincers.swivelStop();
        if(!Robot.pincers.okForward()){
            Robot.pincerWheels.wheelState = 1;
            Robot.pincerWheels.spinWheels();
        }
        
    }

    protected void interrupted() {
        Robot.pincers.swivelStop();
    }
    
}
