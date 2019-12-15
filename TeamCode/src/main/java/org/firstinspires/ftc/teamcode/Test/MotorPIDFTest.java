package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.FtcLib.Hardware.FtcMotor.FtcMotor;
import org.firstinspires.ftc.teamcode.FtcLib.Hardware.FtcMotor.FtcPIDFCoefficientsTable;

@TeleOp(name = "电机PIDF测试", group = "测试")
@Disabled
public class MotorPIDFTest extends OpMode {

    FtcMotor ftcMotor;

    @Override
    public void init() {
        ftcMotor = new FtcMotor("m1", hardwareMap,FtcPIDFCoefficientsTable.CHASSIS_POSITION);
        ftcMotor.resetEncoder();
        ftcMotor.setRotateTo(0, 5000);
    }

    @Override
    public void loop() {
        ftcMotor.motor.setVelocity(1000, AngleUnit.DEGREES);
        telemetry.addData("r",ftcMotor.isRunning());
    }
}
