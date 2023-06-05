// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.DriveCommand;
import frc.robot.Subsystem.SwerveDrive;

public class RobotContainer {

  private SwerveDrive m_swerveDrive;
  private AHRS m_swerveGyro;
  private XboxController m_driveController;

  public RobotContainer() {

    m_swerveGyro = new AHRS(Port.kMXP);
    m_swerveGyro.reset();
    m_swerveGyro.setAngleAdjustment(0.0);

    m_swerveDrive = new SwerveDrive(m_swerveGyro);

    m_driveController = new XboxController(Constants.driverControllerPort);

    configureDefaultCommands();
    configureBindings();
  }

  private void configureDefaultCommands() {
    m_swerveDrive.setDefaultCommand(new DriveCommand(m_driveController, m_swerveDrive));
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
