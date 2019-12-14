package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.FtcLib.Sensor.FtcDistenceSensor.FtcDistenceSensor;

public class DistenceSensorTest extends OpMode {

    FtcDistenceSensor ftcDistenceSensor = null;

    @Override
    public void init() {
        ftcDistenceSensor = new FtcDistenceSensor("d1",hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("distence",ftcDistenceSensor.getDistence());
    }
}
