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
    int degreesToTurnBy = 5;
  
    for(int i = 0; i < (360/5); i++){
      addCommands(
        new DriveDistance(1, length, drivetrain),
        new TurnDegrees(1, degreesToTurnBy, drivetrain));
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

  private void drawTriangleFromArea(double area, Drivetrain drivetrain){
    double root3 = Math.pow(3,0.5);
    double thing = area*(4/root3);
    double result = Math.pow(thing, 0.5);
    // do some math
    drawTriangle((int)result, drivetrain);
  }

  private void drawSquareFromArea(double area, Drivetrain drivetrain){
    double side = Math.pow(area,0.5);
    drawSquare((int)side, drivetrain);
  }

  private void drawCircleFromArea(double area, Drivetrain drivetrain){
    double side = Math.pow((area/Math.PI),0.5);
    drawCircle((int)side, drivetrain);
  }

  private void whatever(int var, Drivetrain drivetrain){
    for (int i = 0; i < 1000; i++){
      addCommands(
        new DriveDistance(1, var, drivetrain),
        new TurnDegrees(1, 180, drivetrain));
    }
  }
  
  private void draw_hexagon( int side_length, Drivetrain drivetrain ) {
    for (int i = 0; i < 6; i++){
      addCommands(
        new DriveDistance(1, side_length, drivetrain),
        new TurnDegrees(1, 60, drivetrain));
    }

  }

  private void draw_hexagon_from_area(double area, Drivetrain drivetrain){
    double side = (Math.pow(2*area, 0.5))/(3*(Math.sqrt(3)));
    draw_hexagon((int)side, drivetrain);
  }


    /**
     * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
     * turn around and drive back.
     *
     * @param drivetrain The drivetrain subsystem on which this command will run
     */
    public AutonomousDistance(Drivetrain drivetrain) {
      draw_hexagon_from_area(100000, drivetrain);
    }
  }
  