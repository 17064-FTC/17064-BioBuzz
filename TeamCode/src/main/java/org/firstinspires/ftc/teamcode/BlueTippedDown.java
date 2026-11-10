package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class BlueTippedDown extends TurtleOpMode {

    int step = 0;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void loop() {
        super.loop();
        telemetry.addLine("Step: " + step);

        /*

        Hundreds Place = Major Step
        Tens Place = Minor Step
        Ones Place = Frantic Debug (At Comp Fixes, should be changed before the next event)

        Step 0 = Start auto
            0 - Reset Gyro
            10 - Delay start of code
        Step 100 = Shoot preloads
            100 - Start Shooter
            110 - Wait 2 Seconds
            120 - Start Delivery
            130 - Wait 4 Seconds
            140 - Stop All Systems
        Step 200 = Move to park
            200 - Move Back 18 Inches
            210 - Dwell Timer
            220 - Move Left 43 Inches
            230 - Dwell Timer

         */

        if (step == 0) {
            timer.reset();
            drive.zeroGyro();
            step = 10;
        } else if (step == 10) {

            if (timer.seconds() >= 10) {
                step = 100;

            }
        } else if (step == 100) {

            shooter.startPollenShooter();
            timer.reset();

            step = 110;



        } else if (step == 110) {

            if (timer.seconds() >= 2) {
                step = 120;
            }
        } else if (step == 120) {

            delivery.startDelivery();
            intake.startIntake();
            timer.reset();

            step = 130;


        } else if (step == 130) {

            if (timer.seconds() >= 4) {
                step = 140;

            }
        } else if (step == 140) {

            intake.stopIntake();
            delivery.stopDelivery();
            shooter.stopShooter();

            step = 200;



        } else if (step == 200) {

            drive.autoMove(-18, 0, 0);

            if (drive.isRobotAtTarget()) {
                timer.reset();
                step = 210;
            }
        } else if (step == 210) {

            if (timer.seconds() >= 0.5) {
                step = 220;

            }

        } else if (step == 220) {

            drive.autoMove(0, 43, 0);

            if (drive.isRobotAtTarget()) {
                timer.reset();
                step = 230;
            }
        } else if (step == 230) {

            if (timer.seconds() >= 0.5) {

                step = 300;
            }

        }


    }

}


