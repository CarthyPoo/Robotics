package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "HolonomicTestDrive (Blocks to Java)")
public class HolonomicTestDrive extends LinearOpMode {

  private DcMotor frontright;
  private DcMotor backright;
  private DcMotor frontleft;
  private DcMotor backleft;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    float vertical;
    float horizontal;
    float pivot;

    frontright = hardwareMap.get(DcMotor.class, "front right");
    backright = hardwareMap.get(DcMotor.class, "back right");
    frontleft = hardwareMap.get(DcMotor.class, "front left");
    backleft = hardwareMap.get(DcMotor.class, "back left");

    // Put initialization blocks here.
    frontright.setDirection(DcMotorSimple.Direction.REVERSE);
    backright.setDirection(DcMotorSimple.Direction.REVERSE);
    waitForStart();
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        vertical = gamepad1.right_stick_y;
        horizontal = -gamepad1.right_stick_x;
        pivot = gamepad1.left_stick_x;
        frontright.setPower(-pivot + (vertical - horizontal));
        backright.setPower(-pivot + vertical + horizontal);
        frontleft.setPower(pivot + vertical + horizontal);
        backleft.setPower(pivot + (vertical - horizontal));
        // Put loop blocks here.
        telemetry.update();
        // Put run blocks here.
      }
    }
  }
}
