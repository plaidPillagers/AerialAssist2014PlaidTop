/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2538.AerialAssist2014.subsystems;
import edu.wpi.first.wpilibj.Compressor;
import org.usfirst.frc2538.AerialAssist2014.RobotMap;
import org.usfirst.frc2538.AerialAssist2014.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2538.AerialAssist2014.Robot;
/**
 *
 * @author Plaidtop
 */
public class AirCompressor extends Subsystem{
    public boolean compressorOn = false;
    private Compressor compressor = RobotMap.compressorCompressor;
    //Compressor compressor = RobotMap.compressorCompressor;
    
    public AirCompressor(){
        super();
    }
    public void startCompressor(){
        if (!compressorOn) {
            System.out.println("-----COMPRESSOR HAS STARTED--------");
            compressor.start();
            compressorOn = true;
        }
    }
    
    protected void initDefaultCommand() {
        
    }
    //public void startCompressor(){
    //    compressor.startCompressor();
    //}
    
}
