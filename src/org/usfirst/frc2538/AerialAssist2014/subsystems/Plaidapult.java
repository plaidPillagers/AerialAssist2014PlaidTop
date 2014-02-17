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
import org.usfirst.frc2538.AerialAssist2014.RobotMap;
import org.usfirst.frc2538.AerialAssist2014.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class Plaidapult extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController winchMotor = RobotMap.plaidapultWinchMotor;
    DoubleSolenoid triggerActuator = RobotMap.plaidapultTriggerActuator;
    DoubleSolenoid stopActuator = RobotMap.plaidapultStopActuator;
    DigitalInput winchLimitSwitch = RobotMap.plaidapultWinchLimitSwitch;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final int WINCH_SPEED = 1;
    AnalogChannel rangeFinder = RobotMap.rangeFinder;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        setDefaultCommand(new DisplayPlaidapultData());
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void pullIn(){
        if(winchLimitSwitch.get()){
            winchMotor.set(WINCH_SPEED);
        }
        else{
            winchMotor.set(0);
        }
    }
    public void firePlaidapult(){
        int n = 0;
        if(n % 2 == 0){
            triggerActuator.set(DoubleSolenoid.Value.kForward);
            n++;
        }
        else{
            triggerActuator.set(DoubleSolenoid.Value.kReverse);
            n++;
        }
    }
    public void displayPlaidapultData(){
        SmartDashboard.putBoolean("Winch Limit Switch Status", winchLimitSwitch.get());
        SmartDashboard.putString("Trigger Actuator Status", triggerActuator.getSmartDashboardType());
    }
    public void displayDistance(){
        double voltage = rangeFinder.getAverageVoltage();
        double distanceInches = voltage/0.009766;
        //System.out.println("distance is" + distanceInches);
    }
}
