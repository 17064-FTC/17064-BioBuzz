package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DeliverySubsystem {
    CRServo feederLeft, feederRight;
    public DeliverySubsystem (HardwareMap hardwareMap) {
        feederLeft = hardwareMap.get(CRServo.class, "feederLeft");
        feederRight = hardwareMap.get(CRServo.class, "feederRight");
    }

    public void startDelivery (){
        feederLeft.setPower(1);
        feederRight.setPower(1);
    }
    public void stopDelivery (){
        feederLeft.setPower(0);
        feederRight.setPower(0);
    }

    public void reverseDelivery (){
        feederLeft.setPower(-1);
        feederRight.setPower(-1);
    }
}
