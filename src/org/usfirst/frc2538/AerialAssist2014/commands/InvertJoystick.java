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
        requires(Robot.driveSystem);
    }

    protected void initialize() {
        Robot.driveSystem.joystickInversion = -1;
    }

    protected void execute() {
        Robot.driveSystem.joystickInversion = -1;
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.driveSystem.joystickInversion = 1;
    }

    protected void interrupted() {
        Robot.driveSystem.joystickInversion = 1;
    }
    
}