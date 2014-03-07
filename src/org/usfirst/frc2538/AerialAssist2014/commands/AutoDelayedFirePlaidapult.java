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
    private final int MAX_ATTEMPTS = 5;
    
    protected void initialize() {
        hasExecuted = false;
        numImageAttempts = 0;
        System.out.println("Started timing");
        Robot.plaidapult.resetTiming();
    }

    protected void execute() {
        if (!hasExecuted){
            if(numImageAttempts > MAX_ATTEMPTS || delayedExecution == true){
                if(Robot.plaidapult.getTime() > Robot.plaidapult.THREE_SECOND_DELAY){
                    Robot.plaidapult.firePlaidapult();
                    Robot.plaidapult.resetTiming();
                    hasExecuted = true;
                    System.out.println("DELAYED SHOT");
                }
            } 
            else {
                int toShoot = Robot.camera.toShoot();
                if(toShoot == Robot.camera.SHOOT){
                    Robot.plaidapult.firePlaidapult();
                    Robot.plaidapult.resetTiming();
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
          System.out.println("&&&&&&&&&&&&&&&&&&& ended");
    }

    protected void interrupted() {
        System.out.println("&&&&&&&&&&&&&&&&&&&& interrupted");
    }
    
}
