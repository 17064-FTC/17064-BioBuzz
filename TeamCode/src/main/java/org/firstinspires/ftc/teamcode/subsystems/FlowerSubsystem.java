package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FlowerSubsystem {
    Servo flowerServo;

    public FlowerSubsystem(HardwareMap hardwareMap) {
        flowerServo = hardwareMap.get(Servo.class, "flowerServo");
        flowerServo.setDirection(Servo.Direction.REVERSE);
    }


    public void extendFlower (){ flowerServo.setPosition(0.35);}
    public void retractFlower (){ flowerServo.setPosition(0);}
    }

