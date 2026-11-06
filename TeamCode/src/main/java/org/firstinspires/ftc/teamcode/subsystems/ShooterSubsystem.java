package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class ShooterSubsystem {

    DcMotorEx Shooter;


    public static double ShootPollenPower = 0.5;
    public static double ShootPollenVelocity = 1200;
    public static double ShootNectarPower = 0.5;

    public ShooterSubsystem(HardwareMap hardwareMap){
        Shooter = hardwareMap.get(DcMotorEx.class,"Shooter");
        Shooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

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


}

