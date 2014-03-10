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
public class AutoTogglePincers extends Command {
    public AutoTogglePincers() {
    }
    
    private boolean hasExecuted;

    protected void initialize() {
        Robot.pincers.closeArm();
        hasExecuted = false;
        //Robot.pincers.armForward = !Robot.pincers.armForward;
    }

    protected void execute() {
        hasExecuted = true;
        Robot.pincers.toggleArm();
        System.out.println("Executing toggle pincers");
    }

    protected boolean isFinished() {
        return hasExecuted;
    }

    protected void end() {
        hasExecuted = true;
    }

    protected void interrupted() {
        hasExecuted = true;
    }
    
}
