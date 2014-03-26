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
        Robot.pincers.wheelState = -1;
    }

    protected void execute() {
        Robot.pincers.spinWheels();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.pincers.wheelState = 0;
    }

    protected void interrupted() {
        Robot.pincers.wheelState = 0;
    }
    
}
