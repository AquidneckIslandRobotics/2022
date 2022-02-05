// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feed extends SubsystemBase {
  private CANSparkMax beltneo = new CANSparkMax(Constants.BeltNeo, MotorType.kBrushless);
  
  
  /** Creates a new Feed. */
  public Feed() {
   beltneo = new CANSparkMax(Constants.BeltNeo, null);
   
   
  }
  public void feedRun() {
    beltneo.set(.78);//subject to change during testing 
    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}