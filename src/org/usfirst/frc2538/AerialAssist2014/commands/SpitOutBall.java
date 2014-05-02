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
public class SpitOutBall extends Command{

    protected void initialize() {
        Robot.pincerWheels.wheelState = -1;
    }

    protected void execute() {
        Robot.pincerWheels.spinWheels();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.pincerWheels.wheelState = 0;
    }

    protected void interrupted() {
        Robot.pincerWheels.wheelState = 0;
    }
    
}
