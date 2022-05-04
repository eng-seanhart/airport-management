package planes;

import planeparts.engine.EngineIF;
import planeparts.fuselage.FuselageIF;
import planeparts.wing.WingIF;

public class CessnaCitationX extends PassengerPlane{
    private FuselageIF fuselage;

    private EngineIF[] engines;

    private WingIF[] wings;

    public CessnaCitationX(FuselageIF fuselage, EngineIF[] engines, WingIF[] wings, int passengerCount){
        this.fuselage = fuselage;
        this.engines = engines;
        this.wings = wings;
        setPassengerCount(passengerCount);
    }
}