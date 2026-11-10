package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.DeliverySubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.FlowerSubsystem;



public class TurtleOpMode extends OpMode {

    DriveSubsystem drive;
    IntakeSubsystem intake;
    DeliverySubsystem delivery;
    ShooterSubsystem shooter;
    FlowerSubsystem flower;

    ElapsedTime timer = new ElapsedTime();


    @Override
    public void init() {
        drive = new DriveSubsystem(telemetry, hardwareMap);
        intake = new IntakeSubsystem(hardwareMap);
        delivery = new DeliverySubsystem(hardwareMap);
        shooter = new ShooterSubsystem(hardwareMap);
        flower = new FlowerSubsystem(hardwareMap);
    }

    @Override
    public void loop() {
        drive.populateTelemetry();
    }

}
