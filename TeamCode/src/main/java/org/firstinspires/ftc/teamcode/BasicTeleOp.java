package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.acmerobotics.dashboard.FtcDashboard;


@TeleOp
public class BasicTeleOp extends TurtleOpMode {

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void loop() {
        super.loop();
        drive.fieldCentricDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);


        if (gamepad1.back) {
            drive.zeroGyro();
        }

        if (gamepad1.start || gamepad2.start) {
            drive.zeroForward();
            drive.zeroRight();
            shooter.ShootPollenVelocity = 1200;
        }


        telemetry.addLine("Operator - D-Pad Up = Intake");
        telemetry.addLine("Operator - D-Pad Down = Reverse Intake");
        if (gamepad2.dpad_up || gamepad1.dpad_up) {
            intake.startIntake();

        } else if (gamepad2.dpad_down || gamepad1.dpad_down){
            intake.reverseIntake();



        } else {
            intake.stopIntake();
        }

        if (gamepad2.dpad_left){
            flower.extendFlower();
        }
        else{
            flower.retractFlower();
        }


        telemetry.addLine("Driver - Right bumper = Feeder");
        telemetry.addLine("Driver - Left bumper = Reverse Feeder");
        if (gamepad1.right_bumper && (shooter.getVelocity() > shooter.ShootPollenVelocity-20)) {
            delivery.startDelivery();

        } else if (gamepad2.right_bumper){
            delivery.startDelivery();
        }

        else if (gamepad1.left_bumper || gamepad2.left_bumper){
            delivery.reverseDelivery();

        } else {
            delivery.stopDelivery();
        }

        telemetry.addLine("Operator - Y = Shoot Pollen");
        telemetry.addLine("Operator - A = Reverse Shooter");
        telemetry.addLine("Operator - X or B = Change Shooter Speed");
        if (gamepad2.y || gamepad1.y) {
            shooter.startPollenShooter();

        }
        else if (gamepad2.a) {
            shooter.reverseShooter();

        } else {
            shooter.stopShooter();
        }

        telemetry.addData("Pollen Velocity", shooter.ShootPollenVelocity);
        if (gamepad2.bWasPressed() || gamepad1.bWasPressed()){
            shooter.ShootPollenVelocity = shooter.ShootPollenVelocity + 20;
        }
        if (gamepad2.xWasPressed() || gamepad1.xWasPressed()){
            shooter.ShootPollenVelocity = shooter.ShootPollenVelocity - 20;
        }
    }

}

