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
public class GetZ extends Command {
    public GetZ(){
        //requires(Robot.driveSystem);
    }

    protected void initialize() {
        Robot.driveSystem.getZ = false;
    }

    protected void execute() {
        Robot.driveSystem.getZ = true;
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.driveSystem.getZ = false;
    }

    protected void interrupted() {
        Robot.driveSystem.getZ = false; 
    }
    
}
