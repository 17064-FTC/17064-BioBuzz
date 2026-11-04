package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class ShooterSubsystem {

    DcMotor Shooter;


    public static double ShootPollenPower = 0.5;
    public static double ShootNectarPower = 0.5;

    public ShooterSubsystem(HardwareMap hardwareMap){
        Shooter = hardwareMap.get(DcMotor.class,"Shooter");


    }

    public void startShooter(){
        Shooter.setPower(ShootPollenPower);

    }
    public void startPollenShooter(){
        Shooter.setPower(ShootPollenPower);

    }

    public void startNectarShooter(){
        Shooter.setPower(ShootNectarPower);

    }

    public void stopShooter(){
        Shooter.setPower(0);

    }


}

