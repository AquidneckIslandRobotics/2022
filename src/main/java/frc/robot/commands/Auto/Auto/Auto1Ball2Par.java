// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto.Auto;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.Constants;
import frc.robot.commands.Intake.IntakeCommand;
import frc.robot.commands.Shoot.SpinUp;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Chassis.Chassis;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Auto1Ball2Par extends ParallelRaceGroup {
  /** Creates a new Auto1Ball2Par. */
  public Auto1Ball2Par(Intake m_intake, Feed m_feed, Indexer m_indexer, Shooter m_shooter, Chassis m_chassis) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new IntakeCommand(m_intake, m_feed, m_indexer, true),
      new SpinUp(m_shooter, Constants.spinupVel, true),
      new Auto1Ball2Seq(m_chassis)
    );
  }
}
