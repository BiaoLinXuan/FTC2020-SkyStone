package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.FtcLib.Hardware.FtcMotor.FtcMotor;
import org.firstinspires.ftc.teamcode.FtcLib.Hardware.FtcMotor.FtcPIDFCoefficientsTable;
import org.firstinspires.ftc.teamcode.FtcLib.Sensor.FtcIMU.FtcIMU;

@TeleOp(name = "骚操作",group = "测试")

public class OmniTest extends OpMode {

    public double maxSpeed,xSpeed,ySpeed,aSpeed;
    public double lfs, lbs, rfs, rbs;
    public double xset,yset;
    FtcIMU ftcIMU = null;
    FtcMotor ftcMotor = null;
    @Override
    public void init() {
        ftcIMU = new FtcIMU("imu",hardwareMap);

        ftcMotor = new FtcMotor("m1",hardwareMap, FtcPIDFCoefficientsTable.CHASSIS_VELOCITY);

        xset = 0;
        yset = 1000;
        aSpeed = 0;
        maxSpeed = 1000;
    }

    @Override
    public void loop() {
        double degree = ftcIMU.getYaw();
        xSpeed = xset*Math.cos(Math.toRadians(degree)) + yset*Math.sin(Math.toRadians(degree));
        ySpeed = xset*Math.sin(Math.toRadians(degree)) + yset*Math.cos(Math.toRadians(degree));
        xSpeed = 1000;
        ySpeed = 500;
        aSpeed = 100;
        calcSpeed();
        telemetry.addData("yaw",degree);
        telemetry.addData("speedx",xSpeed);
        telemetry.addData("speedy",ySpeed);

        telemetry.addData("lfs",lfs);
        telemetry.addData("lbs",lbs);
        telemetry.addData("rfs",rfs);
        telemetry.addData("rbs",rbs);
        ftcMotor.setSpeed(lfs);
    }

    public void calcSpeed() {
        lfs = xSpeed + ySpeed - aSpeed;
        lbs = -xSpeed + ySpeed - aSpeed;
        rfs = xSpeed - ySpeed - aSpeed;
        rbs = -xSpeed - ySpeed - aSpeed;

        double max = Math.abs(lfs);
        if (max < Math.abs(lbs)) max = Math.abs(lbs);
        if (max < Math.abs(rfs)) max = Math.abs(rfs);
        if (max < Math.abs(rbs)) max = Math.abs(rbs);
        //如果最大速度大于限定速度就按比例缩小所有车轮速度
        if (max > maxSpeed) {
            lfs = (lfs/max)*maxSpeed;
            lbs = (lbs/max)*maxSpeed;
            rfs = (rfs/max)*maxSpeed;
            rbs = (rbs/max)*maxSpeed;
        }

    }

}
