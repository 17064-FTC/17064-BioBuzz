package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


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


        telemetry.addLine("Operator - Left Bumper = intake");
        if (gamepad2.left_bumper) {
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

        telemetry.addLine("Operator - Right Bumper = Shooter");
        if (gamepad2.right_bumper) {
            shooter.startShooter();

        } else {
            shooter.stopShooter();
        }

    }
}
