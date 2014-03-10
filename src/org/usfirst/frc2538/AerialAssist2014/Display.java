/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2538.AerialAssist2014;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author Plaidtop
 */
public class Display {
    static DriverStationLCD driverStation;
    static SpeedController leftForWheel;
    static SpeedController rightForWheel;
    static SpeedController leftAftWheel;
    static SpeedController rightAftWheel;
    static DigitalInput forwardLimitSwitch;
    static DigitalInput aftLimitSwitch;
    static DigitalInput winchLimitSwitch;
    static Joystick driveJoystick;
    static Joystick shooterJoystick;
    static DigitalInput pressureSwitch;
    static AnalogChannel rangeFinder;
    static Joystick getZ;
    static String trigger;
    
    public static void initializeDriverStation(){
        driverStation = DriverStationLCD.getInstance();
        leftForWheel = RobotMap.driveSystemLeftForeWheel;
        rightForWheel = RobotMap.driveSystemRightForeWheel;
        leftAftWheel = RobotMap.driveSystemLeftAftWheel;
        rightAftWheel = RobotMap.driveSystemRightAftWheel;
        forwardLimitSwitch = RobotMap.pincersForwardLimitSwitch;
        aftLimitSwitch = RobotMap.pincersAftLimitSwitch;
        winchLimitSwitch = RobotMap.plaidapultWinchLimitSwitch;
        driveJoystick = Robot.oi.driveJoystick;
        shooterJoystick = Robot.oi.shooterJoystick; 
        rangeFinder = RobotMap.rangeFinder;
        getZ = Robot.oi.driveJoystick;
        trigger = Robot.plaidapult.displayTriggerState();
        //pressureSwitch = RobotMap.pressureSwitch;
    }
    
    public static void driverStationDisplay(){
        double leftFore = leftForWheel.get();
        double rightFore = rightForWheel.get();
        double leftAft = leftAftWheel.get();
        double rightAft = rightAftWheel.get();
        double driveX = driveJoystick.getX();
        double driveY = driveJoystick.getY();
        double shooterY = shooterJoystick.getY();
        boolean foreSwitch = forwardLimitSwitch.get();
        boolean aftSwitch = aftLimitSwitch.get();
        boolean winchSwitch = winchLimitSwitch.get();
        double distance = rangeFinder.getAverageVoltage()/0.009766;
        double driveZ = getZ.getZ();
        String triggerStatus = Robot.plaidapult.displayTriggerState();
        //boolean compressorSwitch = pressureSwitch.get();
        
        
        int numberOfLines = 6;
        
        String[] lines = new String[numberOfLines];
        
        lines[0] = "DJ[" + formatDouble(driveX, 2) + "," + formatDouble(driveY,2) + "," + formatDouble(driveZ, 2) + "]";
        //lines[1] = "[" + formatDouble(leftFore, 2) + "," + formatDouble(rightFore, 2) + "]";
        //lines[2] = "[" + formatDouble(leftAft, 2) + "," + formatDouble(rightAft, 2) + "]";
        //lines[1] = "SJ:[" + formatDouble(shooterY, 2) + "]";
        lines[1] = "Fore Switch: " + foreSwitch;
        lines[2] = "Aft Switch: " + aftSwitch;
        //lines[4] = "Trigger" + triggerStatus;
        lines[3] = "PP switch: " + winchSwitch;
        lines[4] = "TriggerState: " + triggerStatus;
        if(distance > Robot.plaidapult.MIN_SHOOTING_DISTANCE && distance < Robot.plaidapult.MAX_SHOOTING_DISTANCE){
            lines[5] = "RF: *IN RANGE*";
        }
        else{
            lines[5] = "RF: " + distance;
        }
        //System.out.println("DISPLAY RANGE FINDER = " + rangeFinder);
        //lines[5] = "Aft Switch: " + aftSwitch; //should be here
        //lines[5] = "PP Switch: " + winchSwitch;
        //lines[5] = "C Switch: " + compressorSwitch;
        
        
        writeLCD(lines);
    }
    
    public static String formatDouble(double speed, int precision) {
        String string = "";
        
        if ( speed < 0.0 ) {
            string += "-";
            speed *= -1.0;
        } else {
            string += "+";
        }
        
        string += formatPositiveDouble(speed, precision);
        
        return string;
    }
    
    private static String formatPositiveDouble(double speed, int precision) {
        String string = "";
        
        speed = Math.abs(speed);
        
        string += (int) speed;
        string += ".";
        
        for ( int i = 0; i < precision; i++ ) {
            speed -= (double) ((int) speed);
            speed *= 10.0;
            string += (int) speed;
        }
        
        return string;
    }
    
    // makes driver station display look empty
    private static void cleanDSLCD() {
        String[] blankLines = { "", "", "", "", "", "" };
        writeLCD(blankLines);
    }
    
    private static void writeLCD( String[] lines ) {
        String buffer = "";
        for ( int i = 0; i < 32; i++ ) {
            buffer += " ";
        }
        DriverStationLCD.Line[] lcdLines = {DriverStationLCD.Line.kMain6, DriverStationLCD.Line.kUser2,
        DriverStationLCD.Line.kUser3,DriverStationLCD.Line.kUser4, DriverStationLCD.Line.kUser5,
        DriverStationLCD.Line.kUser6};
        
        for( int i =0; i<lines.length; i++){
             driverStation.println(lcdLines[i], 1, lines[i] + buffer);
        }
  
        driverStation.updateLCD();
    }
    
}
