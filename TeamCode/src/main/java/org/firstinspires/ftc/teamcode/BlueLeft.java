package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Timer;

@Autonomous
public class BlueLeft extends TurtleOpMode {

    int step = 0;
    ElapsedTime timer = new ElapsedTime();

    @Override
    public void init() {

        super.init();
    }

    @Override
    public void loop() {
        super.loop();
        telemetry.addLine("Step: " + step);

        if (step == 0) {
            timer.reset();
            drive.zeroGyro();
            step = 5;
        } else if (step == 5) {

            if (timer.seconds() >= 10) {
                step = 11;

            }
        } else if (step == 11) {

            shooter.startPollenShooter();
            timer.reset();

            step = 12;



        } else if (step == 12) {

            if (timer.seconds() >= 2) {
                step = 13;
            }
        } else if (step == 13) {

            delivery.startDelivery();
            intake.startIntake();
            timer.reset();

            step = 14;


        } else if (step == 14) {

            if (timer.seconds() >= 4) {
                step = 15;

            }
        } else if (step == 15) {

            intake.stopIntake();
            delivery.stopDelivery();
            shooter.stopShooter();

            step = 20;



        } else if (step == 20) {

            drive.autoMove(-18, 0, 0);

            if (drive.isRobotAtTarget()) {
                timer.reset();
                step = 25;
            }
        } else if (step == 25) {

            if (timer.seconds() >= 0.5) {
                step = 30;

            }

        } else if (step == 30) {

            drive.autoMove(0, 43, 0);

            if (drive.isRobotAtTarget()) {
                timer.reset();
                step = 35;
            }
        } else if (step == 35) {

            if (timer.seconds() >= 0.5) {

                step =1000;
            }

        }


    }

}


