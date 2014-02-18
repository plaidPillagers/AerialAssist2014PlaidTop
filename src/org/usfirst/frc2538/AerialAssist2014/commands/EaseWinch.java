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
public class EaseWinch extends Command {
    public EaseWinch(){
        requires(Robot.plaidapult);
    }

    protected void initialize() {
       
    }

    protected void execute() {
        Robot.plaidapult.easeWinch();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }     
    
}
