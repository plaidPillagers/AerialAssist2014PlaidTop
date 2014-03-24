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

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import org.usfirst.frc2538.AerialAssist2014.RobotMap;
import org.usfirst.frc2538.AerialAssist2014.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2538.AerialAssist2014.Robot;

/**
 *
 */
public class Pincers extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController swivelMotor = RobotMap.pincersSwivelMotor;
    DoubleSolenoid armActuator = RobotMap.pincersArmActuator;
    DoubleSolenoid elevatorActuator1 = RobotMap.pincersElevatorActuator1;
    //DoubleSolenoid elevatorActuator2 = RobotMap.pincersElevatorActuator2;
    DigitalInput forwardLimitSwitch = RobotMap.pincersForwardLimitSwitch;
    DigitalInput aftLimitSwitch = RobotMap.pincersAftLimitSwitch;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController portWheel = RobotMap.pincersPortWheel;
    SpeedController starboardWheel = RobotMap.pincersStarboardWheel;
    public boolean armForward = true;
    public boolean elevatorRaise = false;
    public boolean pincerSwitchReset = false;
    public static final double AUTO_SWIVEL_SPEED = .75;
    public boolean autoMoveSwivelDone = false;
    public int wheelState = 0;//0 = stop, 1 = forward, -1 reverse
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new SwivelPincer());
        //setDefaultCommand(new DisplayPincerData());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public boolean okForward() {
        //System.out.println("forward switch = " + forwardLimitSwitch.get());
        return !forwardLimitSwitch.get();
    }

    public boolean okAft() {
        //System.out.println("aft switch = " + aftLimitSwitch.get());
        return !aftLimitSwitch.get();
    }

    public void autoMoveSwivelForward() {
        //System.out.println("....forward...");
        //Joystick shooterJoystick = Robot.oi.shooterJoystick;
        //double throttle = shooterJoystick.getThrottle();
        //double throttleProportion = throttle * (-.25) + .75; 
        if (!autoMoveSwivelDone) {
            //double y = Robot.oi.shooterJoystick.getY();
            if (okForward()) {
                //Attack Joystick is inverted, multiply values by -1
                swivelMotor.set(AUTO_SWIVEL_SPEED * (1));
                //System.out.println("SWIVEL MOTOR = " + swivelMotor.get());
            } else {
                swivelMotor.set(0);
            }
        }
    }

    public void autoMoveSwivelAft() {
        //System.out.println("....and aft...");
        //Joystick shooterJoystick = Robot.oi.shooterJoystick;
        //double throttle = shooterJoystick.getThrottle();
        //double throttleProportion = throttle * (-.25) + .75; 

        //double y = Robot.oi.shooterJoystick.getY();
        if (!autoMoveSwivelDone) {
            if (okAft()) {
                //Attack joystick is inverted, multiply values by -1
                swivelMotor.set(AUTO_SWIVEL_SPEED * (-1));
            } else {
                swivelMotor.set(0);
            }
        }
    }

    public void moveSwivel() {
        if (autoMoveSwivelDone) {
            Joystick shooterJoystick = Robot.oi.shooterJoystick;
            double throttle = shooterJoystick.getThrottle();
            double throttleProportion = throttle * (-.25) + .75;
            double y = shooterJoystick.getY();

            if (y < 0 && okForward()) {//origianlly y <0
                swivelMotor.set(throttleProportion * y * (1));
                //System.out.println("MOVING FORWARD" + throttleProportion * y * (12));
            } else if (y > 0 && okAft()) {//originally y>0
                swivelMotor.set(throttleProportion * y * (1));
                //System.out.println("MOVING AFT" + throttleProportion * y * (12));
            } else {
                swivelMotor.set(0);
                //System.out.println("STOP MOVING!");
            }
            //System.out.println(" swivel motor: " + swivelMotor.get());
        }
    }

    public void swivelStop() {
        swivelMotor.set(0);
    }

    public void toggleElevator() {
        if (elevatorRaise) {
            elevatorActuator1.set(DoubleSolenoid.Value.kForward);
        } else {
            elevatorActuator1.set(DoubleSolenoid.Value.kReverse);
        }
        //elevatorActuator2.set(DoubleSolenoid.Value.kForward);
    }

    public void testLimitSwitchesInput() {
        //System.out.println("Forward limit switch on: " + forwardLimitSwitch.get());
        //System.out.println("Aft limit switch on: " + aftLimitSwitch.get());
    }

    public void lowerElevator() {
        elevatorActuator1.set(DoubleSolenoid.Value.kReverse);
        //elevatorActuator2.set(DoubleSolenoid.Value.kReverse);
    }

    public void toggleArm() {
        //System.out.println("Opening arm....");
        if (armForward) {
            armActuator.set(DoubleSolenoid.Value.kForward);
            System.out.println("opening pincers++++++++");
        } else {
            armActuator.set(DoubleSolenoid.Value.kReverse);
            System.out.println("Colsing pincers++++++++++++");
        }
    }

    public void closeArm() {
        armActuator.set(DoubleSolenoid.Value.kReverse);
        armForward = true;
    }
    
    public void spinWheels(){
        portWheel.set(wheelState);
        starboardWheel.set(wheelState);
    }
    
    public void stopWheels(){
        portWheel.set(0);
        starboardWheel.set(0);
    }

    public void displayPincerData() {
        SmartDashboard.putString("Arm Status", armActuator.getSmartDashboardType());
        SmartDashboard.putString("Elevator Status", elevatorActuator1.getSmartDashboardType());
        SmartDashboard.putNumber("Swivel Status", swivelMotor.get());
        SmartDashboard.putBoolean("Forward Limit Switch", forwardLimitSwitch.get());
        SmartDashboard.putBoolean("Aft Limit Switch", aftLimitSwitch.get());
    }

}
