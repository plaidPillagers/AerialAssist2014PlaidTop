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
    public SpinWheelsReverse(){
        requires(Robot.pincerWheels);
    }

    protected void initialize() {
        System.out.println("spin wheels reverse initialiszed");
        if(Robot.pincerWheels.wheelState == -1){
            System.out.println("wheels at zero!!!");
            Robot.pincerWheels.wheelState = 0;
        }
        else{
            Robot.pincerWheels.wheelState = -1;
        }
    }

    protected void execute() {
        Robot.pincerWheels.spinWheels();
    }

    protected boolean isFinished() {
        return false;
    }
    protected void end() {
        
    }

    protected void interrupted() {
        System.out.println("wheels reverse initiallized");
        
    }
    
}
