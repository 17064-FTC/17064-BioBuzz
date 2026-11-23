package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class ShooterSubsystem {

    DcMotorEx Shooter;
    Telemetry telemetry;


    public static double ShootPollenPower = 0.5;
    public static double ShootPollenVelocity = 1200;
    public static double ShootNectarPower = 0.5;

    public ShooterSubsystem(Telemetry telemetry, HardwareMap hardwareMap){
        this.telemetry = telemetry;
        Shooter = hardwareMap.get(DcMotorEx.class,"Shooter");

        Shooter.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER, new PIDFCoefficients(100, 0, 0, 12.13));

//        Shooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

    }

    public void populateTelemetry() {
        telemetry.addData("Shooter - Current Velocity", Shooter.getVelocity());
    }

    public void startShooter(){
        Shooter.setPower(ShootPollenPower);

    }
    public void startPollenShooter(){
        Shooter.setVelocity(ShootPollenVelocity);

        //Shooter.setPower(ShootPollenPower);

    }

    public void startNectarShooter(){
        Shooter.setPower(ShootNectarPower);

    }

    public void reverseShooter(){
        Shooter.setPower(-1);
    }

    public void stopShooter(){
        Shooter.setVelocity(0);
        //Shooter.setPower(0);

    }

    public double getVelocity(){
        return Shooter.getVelocity();
    }


}

