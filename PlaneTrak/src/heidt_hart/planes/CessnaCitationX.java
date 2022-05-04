package heidt_hart.planes;

import heidt_hart.planeparts.engine.EngineIF;
import heidt_hart.planeparts.fuselage.FuselageIF;
import heidt_hart.planeparts.wing.WingIF;

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