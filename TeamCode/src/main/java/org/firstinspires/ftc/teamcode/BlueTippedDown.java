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

        Thousands Place = Major Step
        Tens Place = Minor Step
        Ones Place = Frantic Debug (At Comp Fixes, should be changed before the next event)

        Step 0000 = Start auto
            0000 - Reset Gyro
            0010 - Delay start of code
        Step 1000 = Shoot preloads
            1010 - Start Shooter
            1020 - Wait 2 Seconds
            1030 - Start Delivery
            1040 - Wait 4 Seconds
            1050 - Stop All Systems
        Step 2000 = Move to park
            2010 - Move Back 18 Inches
            2020 - Dwell Timer
            2030 - Move Left 43 Inches
            2040 - Dwell Timer

         */

        if (step == 0000) {
            timer.reset();
            drive.zeroGyro();
            step = 0010;
        } else if (step == 0010) {

            if (timer.seconds() >= 10) {
                step = 1010;

            }
        } else if (step == 1010) {

            shooter.startPollenShooter();
            timer.reset();

            step = 1020;



        } else if (step == 1020) {

            if (timer.seconds() >= 2) {
                step = 1030;
            }
        } else if (step == 1030) {

            delivery.startDelivery();
            intake.startIntake();
            timer.reset();

            step = 1040;


        } else if (step == 1040) {

            if (timer.seconds() >= 4) {
                step = 1050;

            }
        } else if (step == 1050) {

            intake.stopIntake();
            delivery.stopDelivery();
            shooter.stopShooter();

            step = 2010;



        } else if (step == 2010) {

            drive.autoMove(-18, 0, 0);

            if (drive.isRobotAtTarget()) {
                timer.reset();
                step = 2020;
            }
        } else if (step == 2020) {

            if (timer.seconds() >= 0.5) {
                step = 2030;

            }

        } else if (step == 2030) {

            drive.autoMove(0, 43, 0);

            if (drive.isRobotAtTarget()) {
                timer.reset();
                step = 2040;
            }
        } else if (step == 2040) {

            if (timer.seconds() >= 0.5) {

                step = 3000;
            }

        }


    }

}


