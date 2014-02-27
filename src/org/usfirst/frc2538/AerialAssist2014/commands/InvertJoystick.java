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
public class InvertJoystick extends Command {
    public InvertJoystick(){
        //requires(Robot.driveSystem);
    }

    protected void initialize() {
        //System.out.println("joystick inversion initialized");
        Robot.driveSystem.joystickInverted = true;
        Robot.driveSystem.joystickInversion = -1;
    }

    protected void execute() {
        //System.out.println("joystick inversion executing");
        Robot.driveSystem.joystickInverted = true;
        Robot.driveSystem.joystickInversion = -1;
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        //System.out.println("joystick inversion ENDING");
        Robot.driveSystem.joystickInverted = false;
        Robot.driveSystem.joystickInversion = 1;
    }

    protected void interrupted() {
        //System.out.println("interrupted ");
        Robot.driveSystem.joystickInverted = false;
        Robot.driveSystem.joystickInversion = 1;
    }
    
}
