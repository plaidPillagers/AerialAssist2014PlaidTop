// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc2538.AerialAssist2014.subsystems;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import org.usfirst.frc2538.AerialAssist2014.RobotMap;
import org.usfirst.frc2538.AerialAssist2014.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2538.AerialAssist2014.Robot;
/**
 *
 */
public class Plaidapult extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController winchMotor = RobotMap.plaidapultWinchMotor;
    public DoubleSolenoid triggerActuator = RobotMap.plaidapultTriggerActuator;
    DoubleSolenoid stopActuator = RobotMap.plaidapultStopActuator;
    DigitalInput winchLimitSwitch = RobotMap.plaidapultWinchLimitSwitch;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    AnalogChannel rangeFinder = RobotMap.rangeFinder;
    SpeedController dummyTalon = RobotMap.dummyTalon;
    private final double WINCH_SPEED = .99;
    private final double WINCH_EASE_SPEED = -0.75;
    private final long EASE_WINCH_TIME = 5250;
    public final long THREE_SECOND_DELAY = 3000;
    public boolean winchMaxLoadReached = true;
    public boolean easedWinch = false;
    
    public boolean inRange = false;
    public final long MIN_SHOOTING_DISTANCE = 99;//11 feet
    public final long MAX_SHOOTING_DISTANCE = 140;//180;//15 feet
    
    private long startTime = 0; 
    public boolean configured = true;
    
    public int plaidapultStatus = 0; //0 = free, 1 = winching, 2 = pinIn, 3 = locking, 4 = locked
    public final int FREE = 0;
    public final int WINCHING = 1;
    public final int PIN_IN = 2;
    public final int READY = 3;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        //setDefaultCommand(new DisplayPlaidapultData());
        System.out.println("PLAIDAPULT SWITCH = " + winchLimitSwitch.get());
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public boolean okPullIn(){
        //System.out.println("winch limit switch = " + winchLimitSwitch.get());
        return !winchLimitSwitch.get();
    }
    
    public void pullIn(){
        if(okPullIn()){
            winchMotor.set(WINCH_SPEED);
            //System.out.println("****PULLING IN WINCH******");
        }
        else{
            winchMotor.set(0);
            winchMaxLoadReached = true;
            //System.out.println("*************STOPPING WINCH*********");
        }
    }
    
    public void easeWinch(){
        //System.out.println("Winch Time = " + getTime());
        if(getTime() < EASE_WINCH_TIME){
            winchMotor.set(WINCH_EASE_SPEED);
            plaidapultStatus = WINCHING;
            //System.out.println("-------------EASE WINCH----------");
        }
        else{
            winchMotor.set(0);
            easedWinch = true;
            //System.out.println("--------------STOPPING WINCH=-----------");
        }
    }
    public void firePlaidapult(){
        triggerActuator.set(DoubleSolenoid.Value.kReverse);
        plaidapultStatus = FREE;
    }
    public void lockPlaidapult(){
        triggerActuator.set(DoubleSolenoid.Value.kForward);
        plaidapultStatus = PIN_IN;
    }
    
    public void stop(){
        winchMotor.set(0);
    }
    public double displayDistance(){
        double voltage = rangeFinder.getAverageVoltage();
        double distanceInches = voltage/0.009766;
        //System.out.println("range finder = " + distanceInches);
        if(distanceInches < Robot.plaidapult.MAX_SHOOTING_DISTANCE){
            System.out.println("IN RANGE");
        }
        return distanceInches;
    }
    
    public void displayPlaidapultData(){
        SmartDashboard.putBoolean("Winch Limit Switch Status", winchLimitSwitch.get());
        SmartDashboard.putString("Trigger Actuator Status", triggerActuator.getSmartDashboardType());
    }
    
    public void resetTiming() {
        startTime = System.currentTimeMillis();
    }
    
    public long getTime() {
        return System.currentTimeMillis() - startTime;
    }
    public void configTalon(){
        if(getTime() <= 1000){
            dummyTalon.set(1);
            System.out.println("SETTING TALON FORWARD");
        }
        else if(getTime() > 1000 && getTime() <= 2000){
            dummyTalon.set(-1);
            System.out.print("SETTING TALON IN REVERSE");
        }
        else if(getTime() > 2000 && getTime() <= 3000){
            dummyTalon.set(0);
            System.out.println("SETTING TALON TO NEUTRAL");
        }
        else{
            System.out.println("*****TALON CONFIGURED*****");
            configured = true;
        }
    }
}
