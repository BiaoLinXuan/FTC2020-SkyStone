package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.FtcLib.Sensor.FtcIMU.FtcIMU;

@TeleOp(name = "IMU测试",group = "测试")
@Disabled
public class IMUTest extends OpMode {
    FtcIMU imu = null;
    @Override
    public void init() {
        imu = new FtcIMU("imu",hardwareMap);
    }

    public int time = 0;

    @Override
    public void loop() {
        if (time>100){
            time = 0;
            imu.resetReference();
        }
        time++;
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        telemetry.addData("yaw",imu.getYaw());
    }
}
