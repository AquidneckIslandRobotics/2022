// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto.Auto;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Auto.AutoLimeAim;
import frc.robot.commands.Auto.AutoStraight;
import frc.robot.commands.Auto.AutoTurn;
import frc.robot.commands.Shoot.FireAUTO;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.FeedWheel;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Chassis.Chassis;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoCPosition3 extends SequentialCommandGroup {
  /** Creates a new AutoCPosition3. */
  public AutoCPosition3(Chassis chassis, Intake intake, Indexer indexer, Feed feed, FeedWheel feedWheels, Shooter shooter, Limelight limelight, double distance1, double distance2, double distance3, double spinUpVel, double backSpinVel, double degrees1, double degrees2, double degrees3) {

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    // addCommands(
    //   new InstantCommand(() -> chassis.breakVcoast(false), chassis),
    //   new DriveAndIntake(chassis, intake, indexer, distance1, -0.4), 
    //   new AutoStraight(chassis, distance2, 0.4),
    //   new AutoTurnandSpinUp(chassis, shooter, spinUpVel, degrees1, 0.2, true),
    //   new FireAUTO(feed, feedWheels, indexer, intake, 0.2),
    //   new AutoTurn(chassis, degrees2, 0.2),
    //   new AutoStraight(chassis, distance3, 0.4),
    //   new AutoTurnandSpinUp(chassis, shooter, spinUpVel, degrees3, 0.2, true),
    //   new FireAUTO(feed, feedWheels, indexer, intake, 0.3)
    
    // );

    //LIMELIGHT AIMING
    double limeThres = 1;
    double turnSpeed = 0.2;
    addCommands(
      new InstantCommand(() -> chassis.breakVcoast(false), chassis),
      new InstantCommand(() -> intake.autoIntakeStart(intake, indexer), intake),
      new AutoStraight(chassis, distance1, 0.4),
      new InstantCommand(() -> intake.autoIntakeStop(intake, indexer), intake),
      new AutoStraight(chassis, distance2, -0.4),
      new InstantCommand(() -> shooter.startWheels(spinUpVel, backSpinVel), shooter),
      new AutoTurn(chassis, degrees1, turnSpeed),
      new AutoLimeAim(chassis, limelight, turnSpeed, limeThres),
      new FireAUTO(feed, feedWheels, indexer, intake, 0.2),
      new InstantCommand(() -> shooter.stopWheels(), shooter),
      new AutoTurn(chassis, degrees2, turnSpeed),
      new InstantCommand(() -> intake.autoIntakeStart(intake, indexer), intake),
      new AutoStraight(chassis, distance3, -0.4),
      new InstantCommand(() -> intake.autoIntakeStop(intake, indexer), intake),
      new InstantCommand(() -> shooter.startWheels(spinUpVel, backSpinVel), shooter),
      new AutoTurn(chassis, degrees3, 0.2),
      new AutoLimeAim(chassis, limelight, 0.2, limeThres),
      new FireAUTO(feed, feedWheels, indexer, intake, 0.3),
      new InstantCommand(() -> shooter.stopWheels(), shooter)
    );
  }
}
