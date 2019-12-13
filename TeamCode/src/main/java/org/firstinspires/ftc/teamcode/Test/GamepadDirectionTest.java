package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.internal.ui.GamepadUser;
import org.firstinspires.ftc.teamcode.FtcLib.Sensor.FtcGamePad.DirectionFix;

public class GamepadDirectionTest extends OpMode {
    DirectionFix directionFix = null;
    @Override
    public void init() {
        directionFix = new DirectionFix(GamepadUser.ONE);
    }

    @Override
    public void loop() {
        telemetry.addData("x",directionFix.xSpeed);
        telemetry.addData("y",directionFix.ySpeed);
        telemetry.addData("a",directionFix.aSpeed);

    }
}
