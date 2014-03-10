// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc2538.AerialAssist2014;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController pincersSwivelMotor;
    public static DoubleSolenoid pincersArmActuator;
    public static DoubleSolenoid pincersElevatorActuator1;
    //public static DoubleSolenoid pincersElevatorActuator2;
    public static DigitalInput pincersForwardLimitSwitch;
    public static DigitalInput pincersAftLimitSwitch;
    public static SpeedController plaidapultWinchMotor;
    public static DoubleSolenoid plaidapultTriggerActuator;
    public static DoubleSolenoid plaidapultStopActuator;
    public static DigitalInput plaidapultWinchLimitSwitch;
    public static SpeedController driveSystemRightAftWheel;
    public static SpeedController driveSystemLeftForeWheel;
    public static SpeedController driveSystemLeftAftWheel;
    public static SpeedController driveSystemRightForeWheel;
    public static RobotDrive driveSystemRobotDrive41;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static AnalogChannel rangeFinder;
    public static Compressor compressorCompressor;
    public static Relay dumyRelay; 
    //public static DigitalInput pressureSwitch;//GET RID OF
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        pincersSwivelMotor = new Talon(1, 7);
	LiveWindow.addActuator("Pincers", "SwivelMotor", (Talon) pincersSwivelMotor);
        
        pincersArmActuator = new DoubleSolenoid(1, 1, 2);      
	
        
        pincersElevatorActuator1 = new DoubleSolenoid(1, 3, 4);      
	
        
        //pincersElevatorActuator2 = new DoubleSolenoid(2, 1, 2);      
	
        
        pincersForwardLimitSwitch = new DigitalInput(1, 1);
	LiveWindow.addSensor("Pincers", "ForwardLimitSwitch", pincersForwardLimitSwitch);
        
        pincersAftLimitSwitch = new DigitalInput(1, 2);
	LiveWindow.addSensor("Pincers", "AftLimitSwitch", pincersAftLimitSwitch);
        
        plaidapultWinchMotor = new Victor(1, 10);
	LiveWindow.addActuator("Plaidapult", "WinchMotor", (Victor) plaidapultWinchMotor);
        
        plaidapultTriggerActuator = new DoubleSolenoid(1, 5, 6);      
	
        
        plaidapultStopActuator = new DoubleSolenoid(1, 7, 8);      
	
        
        plaidapultWinchLimitSwitch = new DigitalInput(1, 3);
	LiveWindow.addSensor("Plaidapult", "WinchLimitSwitch", plaidapultWinchLimitSwitch);
        
        driveSystemRightAftWheel = new Talon(1, 2);
	LiveWindow.addActuator("DriveSystem", "RightAftWheel", (Talon) driveSystemRightAftWheel);
        
        driveSystemLeftForeWheel = new Talon(1, 3);
	LiveWindow.addActuator("DriveSystem", "LeftForeWheel", (Talon) driveSystemLeftForeWheel);
        
        driveSystemLeftAftWheel = new Victor(1, 4);
	LiveWindow.addActuator("DriveSystem", "LeftAftWheel", (Victor) driveSystemLeftAftWheel);
        
        driveSystemRightForeWheel = new Talon(1, 1);
	LiveWindow.addActuator("DriveSystem", "RightForeWheel", (Talon) driveSystemRightForeWheel);
        
        driveSystemRobotDrive41 = new RobotDrive(driveSystemLeftForeWheel, driveSystemLeftAftWheel,
              driveSystemRightForeWheel, driveSystemRightAftWheel);
	
        driveSystemRobotDrive41.setSafetyEnabled(true);
        //driveSystemRobotDrive41.setExpiration(0.1);
        //driveSystemRobotDrive41.setSensitivity(0.5);
        //driveSystemRobotDrive41.setMaxOutput(1.0);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        rangeFinder = new AnalogChannel(1,7);
        compressorCompressor = new Compressor(4,6);
        LiveWindow.addSensor(null, 1, 10, rangeFinder);
        dumyRelay = new Relay(1,5);
        //pressureSwitch = new DigitalInput(5);//GET RID OF
    }
}
