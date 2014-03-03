/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2538.AerialAssist2014.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import java.util.Vector;
import org.usfirst.frc2538.AerialAssist2014.Robot;

/**
 *
 * @author Plaidtop
 */
public class AutoCamera extends Command {
    private boolean hasExecuted;
    
    protected void initialize() {
        hasExecuted = false;
    }

    protected void execute() {
        final ParticleAnalysisReport[] generateReports = Robot.camera.generateReports();
        final Vector checkOffset = Robot.camera.checkOffset(generateReports);
        final Vector checkProportion = Robot.camera.checkProportion(checkOffset);
        final boolean boxDistance = Robot.camera.boxDistance(checkProportion);
        
        hasExecuted = true;
    }

    protected boolean isFinished() {
        return hasExecuted;
    }

    protected void end() {
        hasExecuted = false;
    }

    protected void interrupted() {
        hasExecuted = false;
        
    }
    
}
