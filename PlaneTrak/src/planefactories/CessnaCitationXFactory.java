package planefactories;

import planeparts.engine.EngineIF;
import planeparts.engine.RollsRoyceAE3007;
import planeparts.fuselage.CessnaCitationXFuselage;
import planeparts.fuselage.FuselageIF;
import planeparts.wing.CessnaCitationXWing;
import planeparts.wing.WingIF;
import planes.CessnaCitationX;
import planes.PlaneIF;

public class CessnaCitationXFactory implements PlaneFactoryIF{
    @Override
    public EngineIF[] createEngine() {
        return new EngineIF[]{new RollsRoyceAE3007(), new RollsRoyceAE3007()};
    }

    @Override
    public FuselageIF createFuselage() {
        return new CessnaCitationXFuselage();
    }

    @Override
    public WingIF[] createWings() {
        return new WingIF[]{new CessnaCitationXWing(), new CessnaCitationXWing()};
    }

    @Override
    public PlaneIF createPlane(int cargoTonnage) {
        return new CessnaCitationX(createFuselage(), createEngine(), createWings(), cargoTonnage);
    }
}
