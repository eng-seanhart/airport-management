package planefactories;

import planeparts.engine.EngineIF;
import planeparts.fuselage.FuselageIF;
import planeparts.wing.WingIF;
import planes.PlaneIF;


public interface PlaneFactoryIF {
    public EngineIF[] createEngine();

    public FuselageIF createFuselage();

    public WingIF[] createWings();

    public PlaneIF createPlane(int planeCarryValue);
}
