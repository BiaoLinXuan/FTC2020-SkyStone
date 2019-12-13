package org.firstinspires.ftc.teamcode.FtcLib.Sensor.FtcGamePad;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.internal.ui.GamepadUser;

public class DirectionFix implements Gamepad.GamepadCallback {

    public GamepadUser gamepadUser = null;
    public double xSpeed, ySpeed, aSpeed;

    public DirectionFix(GamepadUser gamepadUser) {
        this.gamepadUser = gamepadUser;
    }

    @Override
    public void gamepadChanged(Gamepad gamepad) {
        if (gamepad.getUser() == gamepadUser) {
            getDirection(gamepad);
        }
    }


    private void getDirection(Gamepad gamepad) {
        if (gamepad.atRest()) {
            aSpeed = 0;
            xSpeed = 0;
            ySpeed = 0;
        }

        aSpeed = gamepad.left_trigger - gamepad.right_trigger;

        double x = gamepad.left_stick_x;
        double y = -gamepad.left_stick_y;//手柄摇杆上下是反的

        double power = Math.sqrt(Math.abs(x) * Math.abs(x) + Math.abs(y) * Math.abs(y));

        double degree;  //角度变量
        degree = Math.atan(y / x);    //求反三角函数正切
        degree = Math.toDegrees(degree);

        if (x > 0 && y > 0) degree = 0 + degree;
        else if (x < 0 && y > 0) degree = 180 + degree;
        else if (x < 0 && y < 0) degree = 180 + degree;
        else if (x > 0 && y < 0) degree = 360 + degree;

        if (x > 0 && y == 0) degree = 0;
        else if (x < 0 && y == 0) degree = 180;
        else if (x == 0 && y < 0) degree = 270;
        else if (x == 0 && y > 0) degree = 90;

        if ((degree >= 0 && degree <= 30) || degree >= 330) {
            xSpeed = power;
            ySpeed = 0;
            //右
        }
        if (degree > 30 && degree < 60) {
            xSpeed = power;
            ySpeed = power;
            //右前
        }
        if (degree >= 60 && degree <= 120) {
            xSpeed = 0;
            ySpeed = power;
            //前
        }
        if (degree > 120 && degree < 150) {
            xSpeed = -power;
            ySpeed = power;
            //左前
        }
        if (degree >= 150 && degree <= 210) {
            xSpeed = -power;
            ySpeed = 0;
            //左
        }
        if (degree > 210 && degree < 240) {
            xSpeed = -power;
            ySpeed = -power;
            //左后
        }
        if (degree >= 240 && degree <= 300) {
            xSpeed = 0;
            ySpeed = -power;
            //后
        }
        if (degree > 300 && degree < 330) {
            xSpeed = power;
            ySpeed = -power;
            //右后
        }
    }

}
