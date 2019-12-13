package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.FtcLib.Hardware.FtcServo.FtcServo;

public class ServoTest extends OpMode {
    FtcServo ftcServo = null;
    @Override
    public void init() {
        ftcServo = new FtcServo("s1",hardwareMap);
    }

    @Override
    public void loop() {
        ftcServo.setAngle(0);
        sleep(1000);
        ftcServo.setAngle(45);
        sleep(1000);
        ftcServo.setAngle(90);
        sleep(1000);
        ftcServo.setAngle(135);
        sleep(1000);
        ftcServo.setAngle(180);
        sleep(3000);
    }

    private void sleep(int ms){
        try {
            Thread.sleep(ms);

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
