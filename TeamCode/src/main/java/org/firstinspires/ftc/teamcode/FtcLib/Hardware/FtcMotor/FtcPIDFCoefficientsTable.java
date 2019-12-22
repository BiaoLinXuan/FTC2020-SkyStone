package org.firstinspires.ftc.teamcode.FtcLib.Hardware.FtcMotor;

public class FtcPIDFCoefficientsTable {
    public static FtcPIDFCoefficients CHASSIS_POSITION = new FtcPIDFCoefficients
            (4,3,5,10,5);
    public static FtcPIDFCoefficients CHASSIS_VELOCITY = new FtcPIDFCoefficients
            (4,3,2,10);
    public static FtcPIDFCoefficients INTAKE = new FtcPIDFCoefficients
            (4,3,2,10);
    public static FtcPIDFCoefficients LIFT = new FtcPIDFCoefficients
            (4,3,2,10);
}
