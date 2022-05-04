package planefactories;

import planeparts.engine.EngineIF;
import planeparts.engine.RollsRoyceTrent900;
import planeparts.fuselage.AirbusA380Fuselage;
import planeparts.fuselage.FuselageIF;
import planeparts.wing.AirbusA380Wing;
import planeparts.wing.WingIF;
import planes.PassengerAirbusA380;
import planes.PlaneIF;

public class AirbusA380Factory implements PlaneFactoryIF{
    @Override
    public EngineIF[] createEngine() {
        return new EngineIF[]{new RollsRoyceTrent900(), new RollsRoyceTrent900(), new RollsRoyceTrent900(),
                new RollsRoyceTrent900()};
    }

    @Override
    public FuselageIF createFuselage() {
        return new AirbusA380Fuselage();
    }

    @Override
    public WingIF[] createWings() {
        return new WingIF[]{new AirbusA380Wing(), new AirbusA380Wing()};
    }

    @Override
    public PlaneIF createPlane(int passengerCount) {
        return new PassengerAirbusA380(createFuselage(), createEngine(), createWings(), passengerCount);
    }
}
