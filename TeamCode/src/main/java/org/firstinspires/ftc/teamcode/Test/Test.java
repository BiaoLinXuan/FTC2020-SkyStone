package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.FtcLib.Hardware.FtcMotor.FtcMotor;
import org.firstinspires.ftc.teamcode.FtcLib.Hardware.FtcMotor.FtcPIDFCoefficientsTable;

@TeleOp(name = "电机PIDF测试")

public class Test extends OpMode {

    FtcMotor ftcMotor = new FtcMotor("m1",hardwareMap);

    @Override
    public void init() {
        ftcMotor.setBrake(true);
        ftcMotor.setMotor(FtcPIDFCoefficientsTable.CHASSIS_PIDF);
    }

    @Override
    public void loop() {
        ftcMotor.setRotateTo(100,2000);
    }
}
