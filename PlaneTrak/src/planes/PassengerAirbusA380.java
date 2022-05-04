package planes;

import planeparts.engine.EngineIF;
import planeparts.fuselage.FuselageIF;
import planeparts.wing.WingIF;

public class PassengerAirbusA380 extends PassengerPlane{
    private FuselageIF fuselage;

    private EngineIF[] engines;

    private WingIF[] wings;

    public PassengerAirbusA380(FuselageIF fuselage, EngineIF[] engines, WingIF[] wings, int passengerCount){
        this.fuselage = fuselage;
        this.engines = engines;
        this.wings = wings;
        setPassengerCount(passengerCount);
    }
}
