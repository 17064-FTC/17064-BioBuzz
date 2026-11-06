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



        if(gamepad1.back){
            drive.zeroGyro();
        }

        if(gamepad1.start){
            drive.zeroForward();
            drive.zeroRight();
        }


        telemetry.addLine("Operator - D-Pad Up = Intake");
        if (gamepad2.dpad_up) {
            intake.startIntake();

        } else {
            intake.stopIntake();
        }


        telemetry.addLine("Driver - Right bumper = Feeder");
        if (gamepad1.right_bumper) {
            delivery.startDelivery();

        } else {
            delivery.stopDelivery();
        }

        telemetry.addLine("Operator - Y = Shoot Pollen");
        telemetry.addLine("Operator - X or B = Shoot Nectar");
        if (gamepad2.y || gamepad1.y) {
            shooter.startPollenShooter();

        }
        else if (gamepad2.x || gamepad1.x || gamepad2.b || gamepad1.b ) {
            shooter.startNectarShooter();

        } else {
            shooter.stopShooter();
        }
        telemetry.addLine("Operator - D-Pad Down = Reverse Intake & Reverse Delivery (Get EVERYTHING out!)");
        if (gamepad2.dpad_down) {
            intake.reverseIntake();
            delivery.reverseDelivery();

        } else {
            intake.stopIntake();
            delivery.stopDelivery();
            telemetry.addLine("Operator - A = Reverse Shooter");
            if (gamepad2.a) {
                shooter.reverseShooter();

            } else {
                shooter.stopShooter();
        }

    }
}
