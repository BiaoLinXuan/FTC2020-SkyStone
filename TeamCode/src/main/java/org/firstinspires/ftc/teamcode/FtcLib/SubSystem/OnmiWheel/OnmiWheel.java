package org.firstinspires.ftc.teamcode.FtcLib.SubSystem.OnmiWheel;

import org.firstinspires.ftc.teamcode.FtcLib.Hardware.FtcMotor.FtcMotor;

public class OnmiWheel {
    public FtcMotor lf, lb, rf, rb;
    public double xSpeed, ySpeed, aSpeed;
    public double maxSpeed = 5 * 360;

    public OnmiWheel(FtcMotor lf, FtcMotor lb, FtcMotor rf, FtcMotor rb, double maxSpeed) {
        this.lf = lf;
        this.lb = lb;
        this.rf = rf;
        this.rb = rb;
        this.maxSpeed = maxSpeed;
    }

    public void setXspeed(double xSpeed) {
        this.xSpeed = xSpeed;
        calcSpeed();
    }

    public void setYspeed(double ySpeed) {
        this.ySpeed = ySpeed;
        calcSpeed();
    }

    public void setAspeed(double aSpeed) {
        this.aSpeed = aSpeed;
        calcSpeed();
    }

    public void setSpeed(double xSpeed, double ySpeed, double aSpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.aSpeed = aSpeed;
        calcSpeed();
    }

    public void calcSpeed() {
        double lfs, lbs, rfs, rbs;
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
        lf.setSpeed(lfs);
        lb.setSpeed(lbs);
        rf.setSpeed(rfs);
        rb.setSpeed(rbs);
    }
}
