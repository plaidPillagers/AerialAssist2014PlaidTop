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
public class AutoDelayedFirePlaidapult extends Command {
    private boolean hasExecuted = false;
    private boolean delayedExecution = false;
    private int numImageAttempts = 0;
    private final int MAX_ATTEMPTS = 3;
    
    protected void initialize() {
        hasExecuted = false;
        Robot.plaidapult.startTiming();
    }

    protected void execute() {
        if (!hasExecuted){
            if(numImageAttempts > MAX_ATTEMPTS || delayedExecution == true){
                if(Robot.plaidapult.getTime() > Robot.plaidapult.FIVE_SECOND){
                    Robot.plaidapult.firePlaidapult();
                    Robot.plaidapult.startTiming();
                    hasExecuted = true;
                    System.out.println("SHOOTING DELAYED");
                }
            } 
            else {
                int toShoot = Robot.camera.toShoot();
                if(toShoot == Robot.camera.SHOOT){
                    Robot.plaidapult.firePlaidapult();
                    Robot.plaidapult.startTiming();
                    hasExecuted = true;
                    System.out.println("HOT GOAL SHOOTING");
                }
                else if(toShoot == Robot.camera.NO_IMAGE){
                    numImageAttempts++;
                }
                else{
                    delayedExecution = true;
                }
            }
        }
    }

    protected boolean isFinished() {
        return hasExecuted;
    }

    protected void end() {
        
    }

    protected void interrupted() {
    }
    
}
