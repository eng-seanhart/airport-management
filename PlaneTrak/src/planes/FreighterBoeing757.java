package planes;

import planeparts.engine.EngineIF;
import planeparts.fuselage.FuselageIF;
import planeparts.wing.WingIF;

public class FreighterBoeing757 extends CargoPlane{
    private FuselageIF fuselage;

    private EngineIF[] engines;

    private WingIF[] wings;

    public FreighterBoeing757(FuselageIF fuselage, EngineIF[] engines, WingIF[] wings, int cargoTonnage){
        this.fuselage = fuselage;
        this.engines = engines;
        this.wings = wings;
        setCargoTonnage(cargoTonnage);
    }
}
