// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto.Auto;

import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeDeserializer;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Auto.AutoLimeAim;
import frc.robot.commands.Auto.AutoStraight;
import frc.robot.commands.Auto.AutoTurn;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Chassis.Chassis;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Testing extends SequentialCommandGroup {
  /** Creates a new Testing. */
  public Testing(Chassis m_chassis, Limelight m_limelight) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new InstantCommand(() -> m_chassis.breakVcoast(false), m_chassis),
      new AutoStraight(m_chassis, 0.5, 0.3),
      new AutoLimeAim(m_chassis, m_limelight, 0.1, 1),
      new AutoStraight(m_chassis, 1, -0.3)
       );
    // addCommands(
    //   new InstantCommand(() -> m_chassis.breakVcoast(false), m_chassis),
    //   new AutoStraight(m_chassis, 2, 0.4)
    //    );
  }
}
