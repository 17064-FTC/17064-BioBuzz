package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class BlueClose extends TurtleOpMode {

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
            drive.zeroGyro();
            step = 10;
        } else if (step == 10) {

            drive.autoMove(0, -12, 0);

            if (drive.isRobotAtTarget()) {
                timer.reset();
                step = 50000000;
            }
        } else if (step == 15) {

            if (timer.seconds() >= 0.5) {
                step = 20;
            }

        } else if (step == 20) {

            drive.autoMove(0, 0, 90);

            if (drive.isRobotAtTarget()) {
                step = 25;
            }
        } else if (step == 25) {

            if (timer.seconds() >= 0.5) {
                step = 30;
            }
        } else if (step == 30) {

            drive.autoMove(0, 0, -90);

            if (drive.isRobotAtTarget()) {
                step = 35;
            }
        } else if (step == 35) {

            if (timer.seconds() >= 0.5) {
                step = 40;
            }
        } else if (step == 40) {

            drive.autoMove(-12, 0, 0);

            if (drive.isRobotAtTarget()) {
                step = 50;
            }
        }



    }

}


