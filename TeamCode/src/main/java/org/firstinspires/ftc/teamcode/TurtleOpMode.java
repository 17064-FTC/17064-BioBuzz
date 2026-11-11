package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;


public class TurtleOpMode extends OpMode {

    DriveSubsystem drive;
    ElapsedTime timer = new ElapsedTime();

    @Override
    public void init() {
        drive = new DriveSubsystem(telemetry, hardwareMap);
    }

    @Override
    public void loop() {
        drive.populateTelemetry();
    }

}
