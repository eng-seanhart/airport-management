package planefactories;

import planeparts.engine.EngineIF;
import planeparts.engine.PW2000;
import planeparts.fuselage.Boeing757Fuselage;
import planeparts.fuselage.FuselageIF;
import planeparts.wing.Boeing757Wing;
import planeparts.wing.WingIF;
import planes.FreighterBoeing757;
import planes.PlaneIF;

public class Boeing757Factory implements PlaneFactoryIF{
    @Override
    public EngineIF[] createEngine() {
        return new EngineIF[]{new PW2000(), new PW2000()};
    }

    @Override
    public FuselageIF createFuselage() {
        return new Boeing757Fuselage();
    }

    @Override
    public WingIF[] createWings() {
        return new WingIF[]{new Boeing757Wing(), new Boeing757Wing()};
    }

    @Override
    public PlaneIF createPlane(int passengerCount) {
        return new FreighterBoeing757(createFuselage(), createEngine(), createWings(), passengerCount);
    }
}
