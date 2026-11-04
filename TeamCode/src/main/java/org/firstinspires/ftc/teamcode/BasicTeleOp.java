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


        telemetry.addLine("Operator - Left Bumper = intake");
        if (gamepad2.left_bumper || gamepad1.left_bumper) {
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

    }
}
