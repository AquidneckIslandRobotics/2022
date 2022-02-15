// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallCount;
import frc.robot.subsystems.Intake;

public class RunIntakeWheels extends CommandBase {
  private Intake m_intake;
  /** Creates a new RunIntakeWheels. */
  public RunIntakeWheels(Intake Subsystem) {
    m_intake = Subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  boolean detec = false;
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intake.setSpeed(-.75);
    if(/*Input Detected &&*/(!(detec))){
      BallCount.increaseBallCount(1);
      detec = true;
    }

    if(/*Input Not Detected &&*/((detec))){
      detec = false;
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
