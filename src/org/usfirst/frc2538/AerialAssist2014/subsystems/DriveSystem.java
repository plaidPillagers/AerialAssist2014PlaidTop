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
import org.usfirst.frc2538.AerialAssist2014.Robot;
/**
 *
 */
public class DriveSystem extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController rightAftWheel = RobotMap.driveSystemRightAftWheel;
    SpeedController leftForeWheel = RobotMap.driveSystemLeftForeWheel;
    SpeedController leftAftWheel = RobotMap.driveSystemLeftAftWheel;
    SpeedController rightForeWheel = RobotMap.driveSystemRightForeWheel;
    RobotDrive robotDrive41 = RobotMap.driveSystemRobotDrive41;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    int n = 0;
    public int joystickInversion = 1;
    final double JOYSTICK_SAFTEY = .03;
    public boolean joystickInverted = false;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DriveMecanum());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	//setDefaultCommand(new DisplayDriveData());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double joystickSaftey(double x){
        if(Math.abs(x) <= JOYSTICK_SAFTEY){
            return 0.0;
        } 
        else{
            return x;
        }
    }
    
    public void driveMecanum(double x, double y, double z){
        
        Joystick driveJoystick = Robot.oi.driveJoystick;
        double throttle = driveJoystick.getThrottle();
        double throttleProportion = throttle*(-.25) +.75;
        robotDrive41.mecanumDrive_Polar(joystickSaftey(y * joystickInversion) * throttleProportion,
                joystickSaftey(x * joystickInversion) * throttleProportion,
                z * joystickInversion);
        //n++;
        System.out.println("@@@@@@@@@@@@@@@@@@     " + joystickInversion + "    @@@@@@@@@@@@@@@@@@@");
        System.out.println("JOYSTICK Y = " + Robot.oi.driveJoystick.getY());
        System.out.println("JOYSTICK X = " + Robot.oi.driveJoystick.getX());
        System.out.println("JOYSTICK Z = " + Robot.oi.driveJoystick.getZ());
        System.out.println("FOR PORT  = " + leftForeWheel.get());
        System.out.println("FOR STARBOARD = " + rightForeWheel.get());
        System.out.println("AFT PORT = " + leftAftWheel.get());
        System.out.println("AFT STARBOARD = " + rightAftWheel.get());
        System.out.println("throttle = " + Robot.oi.driveJoystick.getThrottle());

    }
    public void stop(){
        robotDrive41.mecanumDrive_Polar(0, 0, 0);
    }
    public void displayDriveData(){
        SmartDashboard.putNumber("Port Fore Wheel", leftForeWheel.get());
        SmartDashboard.putNumber("Port Aft Wheel", leftAftWheel.get());
        SmartDashboard.putNumber("Starboard Fore Wheel", rightForeWheel.get());
        SmartDashboard.putNumber("Starboard Aft Wheel", rightAftWheel.get());
    }
}
