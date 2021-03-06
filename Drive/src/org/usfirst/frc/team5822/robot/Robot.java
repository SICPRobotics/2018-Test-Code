/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5822.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5822.robot.commands.ExampleCommand;
import org.usfirst.frc.team5822.robot.subsystems.ExampleSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Robot extends TimedRobot 
{
	Joystick j = new Joystick(0);
	Joystick k = new Joystick(1);
	
	//TalonSRX frontLeft, frontRight;
	WPI_TalonSRX frontL, frontR, rearL, rearR;
	DifferentialDrive robotBase;
	SpeedControllerGroup left, right;
	
	@Override
	public void robotInit() 
	{
//		frontLeft = new TalonSRX(0);
//		TalonSRX rearLeft = new TalonSRX(1);
//		rearLeft.set(ControlMode.Follower, 0);
//		
//		frontRight = new TalonSRX(2);
//		TalonSRX rearRight = new TalonSRX(3);
//		rearRight.set(ControlMode.Follower, 2);
		
		frontL = new WPI_TalonSRX(0);
		rearL = new WPI_TalonSRX(1);
		frontR = new WPI_TalonSRX(2);
		rearR = new WPI_TalonSRX(3);
		
		left = new SpeedControllerGroup(frontL, rearL);
		right = new SpeedControllerGroup(frontR, rearR);
		
		robotBase = new DifferentialDrive(left, right);
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() 
	{
	}

	@Override
	public void teleopPeriodic() 
	{
		//frontLeft.set(ControlMode.PercentOutput, k.getY());
		//frontRight.set(ControlMode.PercentOutput, j.getY());
		
		robotBase.arcadeDrive(j.getY(), j.getX());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
