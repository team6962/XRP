// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonomousDistance extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
   * turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  private void drawCircle(int radius, Drivetrain drivetrain){
    double length = (Math.PI/180)*radius;
    int degreesToTurnBy = 1;
  
    for(int i = 0; i < 360; i++){
      addCommands(
        new DriveDistance(0.5, length, drivetrain),
        new TurnDegrees(0.5, degreesToTurnBy, drivetrain));
    }
  }
  private void drawSquare(int sideLength, Drivetrain drivetrain){
    int degreesToTurnBy = 90;
    for(int i = 0; i < 4; i++){
      addCommands(
        new DriveDistance(1, sideLength, drivetrain),
        new TurnDegrees(1, degreesToTurnBy, drivetrain));
    }
  }
  private void drawTriangle(int sideLength, Drivetrain drivetrain){
    int degreesToTurnBy = 120;
    for (int i = 0; i < 3; i++){
      addCommands(
        new DriveDistance(1, sideLength, drivetrain),
        new TurnDegrees(1, degreesToTurnBy, drivetrain));
    }
  }
  private void whatever(int var, Drivetrain drivetrain){
    for (int i = 0; i < 1000; i++){
      addCommands(
        new DriveDistance(1, var, drivetrain),
        new TurnDegrees(1, 180, drivetrain));
    }
  }
  
  
    /**
     * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
     * turn around and drive back.
     *
     * @param drivetrain The drivetrain subsystem on which this command will run
     */
    public AutonomousDistance(Drivetrain drivetrain) {
      drawCircle(100, drivetrain);
    }
  }
  