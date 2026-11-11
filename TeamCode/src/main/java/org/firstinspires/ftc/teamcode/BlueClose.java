package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class BlueClose extends TurtleOpMode {

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
            0000 = Zero Gyro
        Step 1000 = Move in Square
            1010 = Move Forward 24 inches
            1020 = Dwell Timer
            1030 = Turn CCW 90
            1040 = Dwell Timer
            1050 = Move Backward 24 inches
            1060 = Dwell Timer
            1070 = Move Left 24 inches
            1080 = Dwell Timer
            1090 = Move Forward 24 inches
            1100 = Dwell Timer
            1110 = Turn CW 90
            1120 = Dwell Timer


    */

        if (step == 0000) {
            drive.zeroGyro();
            step = 1010;
        } else if (step == 1010) {

            drive.autoMove(24, 0, 0);

            if (drive.isRobotAtTarget()) {
                timer.reset();
                step = 1020;
            }
        } else if (step == 1020) {
            if (timer.seconds() >= 0.5) {
                step = 1030;
            }
        } else if (step == 1030) {

            drive.autoMove(0, 0, 90);

            if (drive.isRobotAtTarget()) {
                timer.reset();
                step = 1040;
            }
        } else if (step == 1040) {
            if (timer.seconds() >= 0.5) {
                step = 1050;
            }
        } else if (step == 1050) {

            drive.autoMove(-24, 0, 0);

            if (drive.isRobotAtTarget()) {
                timer.reset();
                step = 1060;
            }
        } else if (step == 1060) {
            if (timer.seconds() >= 0.5) {
                step = 1070;
            }
        } else if (step == 1070) {

            drive.autoMove(0, -24, 0);

            if (drive.isRobotAtTarget()) {
                timer.reset();
                step = 1080;
            }
        } else if (step == 1080) {
            if (timer.seconds() >= 0.5) {
                step = 1090;
            }
        } else if (step == 1090) {

            drive.autoMove(24, 0, 0);

            if (drive.isRobotAtTarget()) {
                timer.reset();
                step = 1100;
            }
        } else if (step == 1100) {
            if (timer.seconds() >= 0.5) {
                step = 1110;
            }
        } else if (step == 1110) {

            drive.autoMove(0, 0, -90);

            if (drive.isRobotAtTarget()) {
                timer.reset();
                step = 1120;
            }
        } else if (step == 1120) {
            if (timer.seconds() >= 0.5) {
                step = 2000;
            }
        }



    }

}


