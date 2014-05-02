/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2538.AerialAssist2014.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2538.AerialAssist2014.RobotMap;

/**
 *
 * @author Plaidtop
 */
public class PincerWheels extends Subsystem{
    SpeedController portWheel = RobotMap.pincersPortWheel;
    SpeedController starboardWheel = RobotMap.pincersStarboardWheel;
    public int wheelState = 0;//0 = stop, 1 = forward, -1 reverse
    protected void initDefaultCommand() {
        
    }
    
    public void spinWheels(){
        portWheel.set(wheelState);
        starboardWheel.set(wheelState);
        System.out.println("spinning wheels--- wheel state = " + wheelState);
    }
    
    
}
