package org.firstinspires.ftc.teamcode.FtcLib.Sensor.FtcDistenceSensor;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class FtcDistenceSensor {

    public DistanceSensor distanceSensor = null;

    public FtcDistenceSensor(String name, HardwareMap hardwareMap){
        distanceSensor = hardwareMap.get(DistanceSensor.class,name);
    }

    public double getDistence(DistanceUnit distanceUnit){
        return distanceSensor.getDistance(distanceUnit);
    }

    public double getDistence(){
        return distanceSensor.getDistance(DistanceUnit.MM);
    }
}
